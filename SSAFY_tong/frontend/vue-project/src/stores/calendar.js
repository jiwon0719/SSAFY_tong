// stores/calendar.js
import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import axios from 'axios'
import { useMatchingStore } from './matching'
import { useUserStore } from './user'

const CALENDAR_API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/calendar`
const QUEST_API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/quest`

export const useCalendarStore = defineStore('calendar', () => {
  // store
  const userStore = useUserStore();

  // 상태 정의
  const pickerDate = ref(null)
  const selectedExpertId = ref(null) // 객체 전체 저장하기
  const selectedTime = ref(null)
  const calendarData = ref({
    quests: [],
    reservations: []
  })
  const isLoading = ref(false)
  const matchingExperts = ref([])

  // matching store
  const matchingStore = useMatchingStore()

  // 예약 가능 시간
  const availableTimes = [
    '09:00', '10:00', '11:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00'
  ]

  const reservations = computed(() => {
    return calendarData.value?.reservations || []
  })
  
  const quests = computed(() => {
    return calendarData.value?.quests || []
  })

  // 정렬된 퀘스트와 예약 computed 추가
  const sortedReservations = computed(() => {
    return [...reservations.value].sort((a, b) => a.time.localeCompare(b.time))
  })

  const sortedQuests = computed(() => {
    return [...quests.value].sort((a, b) => 
      new Date(a.pickDate) - new Date(b.pickDate)
    )
  })

  // 매칭된 전문가 목록 조회
  const fetchMatchingExperts = async (userId) => {
    try {
      const result = await matchingStore.getUserMatchings(userId)
      console.log('Fetched experts:', result)
      
      // response가 있고 배열인지 확인
      if (result && Array.isArray(result)) {
        matchingExperts.value = result.filter(match => match.status === 'O')
      } else {
        console.warn('Invalid result format:', result)
        matchingExperts.value = []
      }
      return matchingExperts.value
    } catch (error) {
      console.error('매칭된 전문가 조회 실패:', error)
      matchingExperts.value = []
      throw error
    }
  }

  // 새로운 메서드 추가: 초기 데이터 로드
  const loadInitialData = async (userId) => {
    try {
      const today = new Date().toISOString().split('T')[0]
      
      const [experts, calendar] = await Promise.all([
        fetchMatchingExperts(userId),
        fetchCalendarByDate(today)
      ])
      
      return {
        experts,
        calendar
      }
    } catch (error) {
      console.error('초기 데이터 로드 실패:', error)
      throw error
    }
  }


  // 특정 날짜의 일정 조회
  const fetchCalendarByDate = async (date) => {
    try {
      let formattedDate
      if (date instanceof Date) {
        formattedDate = date.toISOString().split('T')[0]
      } else if (typeof date === 'string') {
        // 문자열이 이미 'YYYY-MM-DD' 형식인지 확인
        // 날짜 파싱
        // 자바스크립트는 Date 객체에서 월이 0부터 시작함!
        const [year, month, day] = date.split('-')
        const newDate = new Date(year, month - 1, day)
        formattedDate = newDate.toISOString().split('T')[0]
      }
      
      const userId = userStore.userId; 
      console.log('Fetching calendar for:', userId, formattedDate)
      const response = await axios.get(`${CALENDAR_API_URL}/${userId}/${formattedDate}`)
      console.log('API Response:', response.data)
  
      calendarData.value = {
        quests: Array.isArray(response.data.quests) ? response.data.quests : [],
        reservations: Array.isArray(response.data.reservations) ? response.data.reservations : []
      }
      
      return calendarData.value
    } catch (error) {
      console.error('일정 조회 실패:', error)
      throw error
    }
  }




  // 예약 생성
  const createReservation = async () => {
    if (!selectedTime.value || !pickerDate.value || !selectedExpertId.value) {
      throw new Error('필수 정보가 누락되었습니다.')
    }

    isLoading.value = true
    try {
      const userId = userStore.userId;
      const reservationData = {
        userId: userId,
        expertUserId: selectedExpertId.value.userId,
        pickDate: formatDate(pickerDate.value, 'api'),
        time: selectedTime.value,
        status: 'X' // 대기중
      }

      console.log('Sending reservation data:', reservationData)
      await axios.post(`${CALENDAR_API_URL}/reservation`, reservationData)
      
      // 예약 생성 후 일정 목록 새로고침
      await fetchCalendarByDate(pickerDate.value)
      
      // 폼 초기화
      resetForm()

      return true
    } catch (error) {
      console.error('예약 생성 실패:', error)
      throw error
    } finally {
      isLoading.value = false
    }
  }

  // 예약 상태 텍스트 변환
  const getReservationStatus = (status) => {
    return status === 'O' ? '예약 확정' : '예약 대기중'
  }

  // 폼 초기화
  const resetForm = () => {
    selectedTime.value = null
    selectedExpertId.value = null
  }

  // 날짜 포맷팅 함수 수정
  const formatDate = (date, format = 'display') => {
    if (!date) return ''
    const d = new Date(date)
    
    if (format === 'api') {
        // API 요청용 YYYY-MM-DD 형식
        return new Date(Date.UTC(d.getFullYear(), d.getMonth(), d.getDate()))
            .toISOString()
            .split('T')[0]
    }
    
    // 화면 표시용 포맷
    return new Intl.DateTimeFormat('ko-KR', {
        year: 'numeric',
        month: 'long',
        day: 'numeric'
    }).format(d)
  }

  // 퀘스트 상태 업데이트
  const updateQuestStatus = async(questId, newStatus) => {
    isLoading.value = true
    try {
      await axios.patch(`${QUEST_API_URL}/${questId}`, null, {
        params: { status: newStatus}
      })

      // 현재 선택된 날짜의 일정 새로고침 
      if(pickerDate.value) {
        const userId = userStore.userId;
        // 로그인 유저로 바꾸기
        await fetchCalendarByDate(pickerDate.value)
      }

      return true
    } catch (error) {
      console.log('퀘스트 상태 업데이트 실패 : ', error)
      throw new Error(error.response?.data?.message || '퀘스트 상태 업데이트에 실패했습니다.')
    } finally {
      isLoading.value = false
    }
  }


  return {
    // 상태
    pickerDate,
    selectedExpertId,
    selectedTime,
    calendarData,
    isLoading,
    matchingExperts,
    availableTimes,
    
    // computed
    reservations,
    quests,
    sortedReservations,  // 새로 추가
    sortedQuests,        // 새로 추가
    
    // 메서드
    fetchMatchingExperts,
    fetchCalendarByDate,
    createReservation,
    getReservationStatus,
    resetForm,
    formatDate,
    updateQuestStatus,
    loadInitialData,
  }
})