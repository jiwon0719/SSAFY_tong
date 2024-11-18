import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const CALENDAR_EXPERT_API_URL = 'http://localhost:8080/api/calendar'
const RESERVATION_API_URL = 'http://localhost:8080/api/expert/reservations'

export const useExpertCalendarStore = defineStore('expertCalendar', () => {
  // state
  const pickerDate = ref(new Date()) // 문자열이 아닌 Date 객체로 초기화
  const reservations = ref([])
  const isLoading = ref(false)
  const error = ref(null)

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

  // actions
  const fetchReservations = async (date) => {
    try {
      isLoading.value = true
      const { year, month, date: day } = formattedDate.value
      
      console.log('Picked Date:', date)
      console.log('Formatted Date:', formattedDate.value)
      
      const params = {
        expertId: 'expert', 
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
    
    // getters
    formattedDate,
    pendingReservations,
    acceptedReservations, 
    rejectedReservations, 
    
    // actions
    fetchReservations,
    updateReservationStatus,
    setPickerDate,
    clearError
  }
})