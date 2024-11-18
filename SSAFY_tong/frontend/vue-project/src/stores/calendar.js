// stores/calendar.js
import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import axios from 'axios'
import { useMatchingStore } from './matching'

const CALENDAR_API_URL = 'http://localhost:8080/api/calendar'

export const useCalendarStore = defineStore('calendar', () => {
  // 상태 정의
  const pickerDate = ref(null)
  const selectedExpertId = ref(null) // 객체 전체 저장하기
  const selectedTime = ref(null)
  const calendarData = ref([]) // 퀘스트와 예약 정보를 모두 포함
  const isLoading = ref(false)
  const matchingExperts = ref([])

  // matching store
  const matchingStore = useMatchingStore()

  // 예약 가능 시간
  const availableTimes = [
    '09:00', '10:00', '11:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00'
  ]

  // computed: 필터링된 예약 목록
  const reservations = computed(() => {
    return calendarData.value.filter(item => item.reservationId)
  })

  // 매칭된 전문가 목록 조회
  const fetchMatchingExperts = async (userId) => {
    try {
      const matchedList = await matchingStore.getUserMatchings(userId)
      console.log('Fetched experts:', matchedList)
      // matching "O" 전문가만 필터링 된다.
      matchingExperts.value = matchedList.filter(match => match.status === 'O')
    } catch (error) {
      console.error('매칭된 전문가 조회 실패:', error)
      throw error
    }
  }

  // 특정 날짜의 일정 조회
  const fetchCalendarByDate = async (userId, date) => {
    if (!date) return
    
    try {
      const formattedDate = date instanceof Date 
        ? date.toISOString().split('T')[0]
        : date
      
      const response = await axios.get(`${CALENDAR_API_URL}/${userId}/${formattedDate}`)
      calendarData.value = response.data
    } catch (error) {
      console.error('일정 조회 실패:', error)
      throw error
    }
  }

  // 예약 생성
  const createReservation = async (userId) => {
    if (!selectedTime.value || !pickerDate.value || !selectedExpertId.value) {
      throw new Error('필수 정보가 누락되었습니다.')
    }

    isLoading.value = true
    try {
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
      await fetchCalendarByDate(userId, pickerDate.value)
      
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

  
  return {
    // 상태
    pickerDate,
    selectedExpertId,
    selectedTime,
    calendarData,
    isLoading,
    matchingExperts,
    availableTimes,
    reservations,
    
    // 메서드
    fetchMatchingExperts,
    fetchCalendarByDate,
    createReservation,
    getReservationStatus,
    resetForm,
    formatDate
  }
})