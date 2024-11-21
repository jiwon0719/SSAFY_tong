import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import { useCalendarStore } from '@/stores/calendar'
import { useUserStore } from './user'

const CALENDAR_EXPERT_API_URL = 'http://localhost:8080/api/calendar'
const RESERVATION_API_URL =     'http://localhost:8080/api/expert/reservations'
const QUEST_API_URL =           'http://localhost:8080/api/expert/quests'
const MATCHING_API_URL =        `http://localhost:8080/api/matching`

export const useExpertCalendarStore = defineStore('expertCalendar', () => {
  const store = useCalendarStore()
  const userStore = useUserStore();

  // state
  const pickerDate = ref(new Date()) // 문자열이 아닌 Date 객체로 초기화
  const reservations = ref([])
  const isLoading = ref(false)
  const error = ref(null)
  const userMatchingList = ref([])
  const quests = ref([])
  const expertUserId = computed(() => userStore.userId) // 전문가가 로그인 했으니 본인 아이디 가져올 것 // API 호출 시 반응형으로 동작

  // getters
  const formattedDate = computed(() => {
    if (!pickerDate.value) return null
    const date = new Date(pickerDate.value)
    return {
      year: date.getFullYear(),
      month: date.getMonth() + 1,
      date: date.getDate()
    }
  })

  const pendingReservations = computed(() => 
    reservations.value.filter(r => r.status === 'X')
  )

  const acceptedReservations = computed(() => 
    reservations.value.filter(r => r.status === 'O')
  )

  const rejectedReservations = computed(() =>
    reservations.value.filter(r => r.status === 'R')  // 거절(R)
   )

   const activeQuests = computed(() => 
    quests.value.filter(q => q.status === 'ONGOING')
  )

  const completedQuests = computed(() => 
    quests.value.filter(q => q.status === 'COMPLETED')
  )


  // actions
  const fetchReservations = async (date) => {
    try {
      isLoading.value = true
      const { year, month, date: day } = formattedDate.value
      
      console.log('Picked Date:', date)
      console.log('Formatted Date:', formattedDate.value)
      
      const params = {
        expertId: expertUserId.value, 
        date: `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')}`
      }
      console.log('Request Params:', params)
   
      const response = await axios.get(`${CALENDAR_EXPERT_API_URL}/expert/reservations`, { params })
      console.log('API Response:', response.data)
      
      const reservationList = response.data.list || response.data
      
      if (Array.isArray(reservationList)) {
        reservations.value = reservationList.map(reservation => ({
          ...reservation,
          pickDate: params.date
        }))
        console.log('Updated Reservations:', reservations.value)
      } else {
        console.error('Invalid response format:', reservationList)
      }
   
    } catch (err) {
      console.error('Error details:', err.response || err)
      error.value = '예약 정보를 불러오는데 실패했습니다.'
      throw err
    } finally {
      isLoading.value = false
    }
   }

  // 예약 수락 / 거절
  const updateReservationStatus = async (reservationId, status) => {
    try {
      isLoading.value = true
      
      await axios.patch(`${RESERVATION_API_URL}/${reservationId}?status=${status}`)

      reservations.value = reservations.value.map(reservation => 
        reservation.reservationId === reservationId
          ? { ...reservation, status }
          : reservation
      )
    } catch (err) {
      error.value = '예약 상태 업데이트에 실패했습니다.'
      throw err
    } finally {
      isLoading.value = false
    }
  }



  // 퀘스트 관련 actions 추가
  // 전문가별 유저 매칭 목록 조회 (UserList 형태로 반환)
  const getExpertMatchings = async () => {
    try {
      console.log('매칭 목록 요청 시작 - expertId:', expertUserId.value);

      const response = await axios.get(`${MATCHING_API_URL}/expert/${expertUserId.value}`)
      console.log('매칭 목록 API 응답 데이터:', response);
      console.log('매칭 목록 데이터:', response.data);

      // 응답 데이터 배열인지 확인
      if (!Array.isArray(response.data)) {
        console.error('API 응답이 배열 형태가 아닙니다:', response.data);
        userMatchingList.value = [];
      } else {
        userMatchingList.value = response.data;
      }      

      return response.data
    } catch (error) {
      console.error("매칭된 유저 목록을 가져오는데 실패했습니다:", error)
      console.error("에러 상세: ", error.response?.data);
      userMatchingList.value = [];
      throw error
    } finally {
    }
  }

  // 부여한 퀘스트 조회
  const fetchQuests = async (date) => {
    try {
      isLoading.value = true
      const { year, month, date: day } = formattedDate.value

      console.log("Picked Date for Quests: ", date);
      console.log("Formmated Date for Quests: ", formattedDate.value)

      const params = {
        expertId: expertUserId.value, 
        date: `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')}`
      }
      console.log("Quest Request Params: ", params)

      const response = await axios.get(`${CALENDAR_EXPERT_API_URL}/expert/quests`, { params })
      console.log("Quest API Response : ", response.data )

      const questList = response.data.list || response.data

      if (Array.isArray(questList)) {
        quests.value = questList.map(quest => ({
          ...quest,
          pickDate: params.date
        }))
        console.log('Updated Quests:', quests.value)
      } else {
        console.error('Invalid quest response format:', questList)
      }
    } catch (err) {
      error.value = '퀘스트 목록을 불러오는데 실패했습니다.'
      throw err
    } finally {
      isLoading.value = false
    }
  }

  const createQuest = async (questData) => {
    try {
      isLoading.value = true

      // 요청 전 데이터 확인
      console.log('Original questData:', questData);

      // 백앤드 API 
      const response = await axios.post(`http://localhost:8080/api/calendar/quest`, questData);
      
      // 응답 데이터 확인
      console.log('Server response:', response.data);

      // 새로 생성된 퀘스트를 목록에 추가
      quests.value.push(response.data)
      return response.data
    } catch (err) {
      console.error('Error details:', err);
      // axios 에러일 경우 response data도 확인
      if (err.response) {
        console.error('Server error response:', err.response.data);
        console.error('Status code:', err.response.status);
      }
      error.value = err.message || '퀘스트 생성에 실패했습니다.'
      throw err
    } finally {
      isLoading.value = false
    }
  }

  const updateQuestStatus = async (questId, status) => {
    try {
      isLoading.value = true
      await axios.patch(`${QUEST_API_URL}/${questId}`, { status })
      
      // 상태 업데이트된 퀘스트 반영
      quests.value = quests.value.map(quest =>
        quest.id === questId ? { ...quest, status } : quest
      )
    } catch (err) {
      error.value = '퀘스트 상태 업데이트에 실패했습니다.'
      throw err
    } finally {
      isLoading.value = false
    }
  }


  const setPickerDate = (date) => {
    pickerDate.value = date // new Date(date) 제거
  }

  const clearError = () => {
    error.value = null
  }

  return {
    // state
    pickerDate,
    reservations,
    isLoading,
    error,
    userMatchingList,
    quests,
    expertUserId, 
    
    // getters
    formattedDate,
    pendingReservations,
    acceptedReservations,
    rejectedReservations,
    activeQuests,
    completedQuests,
    
    // actions
    fetchReservations,
    updateReservationStatus,
    setPickerDate,
    clearError,
    fetchQuests,
    createQuest,
    updateQuestStatus, 
    getExpertMatchings
  }
})