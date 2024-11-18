<template>
  <v-app>
    <v-container>
      <v-row>
        <!-- 좌측: 캘린더 -->
        <v-col cols="12" sm="6" class="my-2 px-1">
          <v-card class="pa-4" color="white">
            <div class="text-h6 mb-4" style="color: #E2495B">Calendar</div>
            <v-date-picker
              v-model="store.pickerDate"
              class="mx-auto custom-calendar"
              elevation="0"
              :first-day-of-week="1"
              :show-adjacent-months="true"
              :events="events"
              :event-color="getEventColor"
              locale="ko-KR"
              full-width
            >
              <template v-slot:header="{ date }">
                <div class="text-subtitle-1" style="color: #E2495B">{{ formatDate(date) }}</div>
              </template>
            </v-date-picker>
          </v-card>
        </v-col>
 
        <!-- 우측: 예약 관리 -->
        <v-col cols="12" sm="6" class="my-2 px-1">
          <v-card color="white">
            <v-card-title class="text-h6 d-flex align-center" style="color: #E2495B">
              Reservation Requests
              <span class="text-subtitle-1 ml-2" style="color: rgba(226, 73, 91, 0.7)">
                {{ store.pickerDate ? new Date(store.pickerDate).toLocaleDateString('ko-KR', {
                  year: 'numeric', 
                  month: 'long', 
                  day: 'numeric'
                }) : '' }}
              </span>
            </v-card-title>
            <v-card-subtitle style="color: rgba(226, 73, 91, 0.7)">
              예약 요청을 관리하세요
            </v-card-subtitle>
            <v-card-text>
              <v-list v-if="filteredReservations.length > 0">
                <v-list-item v-for="reservation in filteredReservations" 
                           :key="reservation.reservationId"
                           :class="{'grey lighten-4': reservation.status !== 'X'}">
                  <v-list-item-content>
                    <v-list-item-title class="d-flex justify-space-between align-center">
                      <div>
                        <v-icon color="#E2495B" class="mr-2">mdi-clock-outline</v-icon>
                        {{ reservation.time }}
                      </div>
                      <div class="d-flex align-items-center">
                        <v-icon color="#E2495B" class="mr-2">mdi-account</v-icon>
                        {{ reservation.userId }}
                        <v-chip
                          :color="reservation.status === 'O' ? 'success' : (reservation.status === 'R' ? 'error' : 'warning')"
                          small
                          class="ml-2 white--text"
                        >
                          {{ reservation.status === 'O' ? '수락됨' : (reservation.status === 'R' ? '거절됨' : '신청 중') }}
                        </v-chip>
                      </div>
                    </v-list-item-title>
                    
                    <div class="d-flex justify-end mt-2" v-if="reservation.status === 'X'">
                      <v-btn
                        color="success"
                        small
                        class="mr-2"
                        @click="handleStatusChange(reservation.reservationId, 'O')"
                      >
                        수락
                      </v-btn>
                      <v-btn
                        color="error"
                        small
                        @click="handleStatusChange(reservation.reservationId, 'R')"
                      >
                        거절
                      </v-btn>
                    </div>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
              <div v-else class="text-center pa-4 text-subtitle-1">
                예약 요청이 없습니다.
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
 
      <!-- 스낵바 -->
      <v-snackbar v-model="snackbar.show" :color="snackbar.color">
        {{ snackbar.message }}
      </v-snackbar>
    </v-container>
  </v-app>
 </template>

<script setup>
import { ref, computed, watch } from 'vue'
import { useExpertCalendarStore } from '@/stores/expertCalendar'

const store = useExpertCalendarStore()

// Local state
const snackbar = ref({
  show: false,
  message: '',
  color: ''
})

// Computed
const filteredReservations = computed(() => {
  if (!store.pickerDate || !store.reservations.length) return []
  
  const selectedDate = new Date(store.pickerDate)
  const dateStr = `${selectedDate.getFullYear()}-${String(selectedDate.getMonth() + 1).padStart(2, '0')}-${String(selectedDate.getDate()).padStart(2, '0')}`
  
  return store.reservations
    .filter(r => r.pickDate === dateStr)
    .sort((a, b) => a.time.localeCompare(b.time))
})

const events = computed(() => {
 if (!store.reservations.length) return []
 
 return [...new Set(store.reservations.map(r => 
   new Date(r.calendarId).toISOString().split('T')[0]
 ))]
})

const getEventColor = (event) => {
  const reservation = store.reservations.find(r => r.pickDate === event)
  if (!reservation) return '#FFB6C1'
  
  switch(reservation.status) {
    case 'O': return '#4CAF50'
    case 'R': return '#FF5252'
    case 'X': return '#FFB6C1'
    default: return '#FFB6C1'
  }
}

const formatDate = (date) => {
  if (!date) return ''
  return new Intl.DateTimeFormat('ko-KR', {
    year: 'numeric',
    month: 'long'
  }).format(new Date(date))
}

const handleStatusChange = async (reservationId, newStatus) => {
  try {
    await store.updateReservationStatus(reservationId, newStatus)
    snackbar.value = {
      show: true,
      message: newStatus === 'O' ? '예약을 수락했습니다.' : '예약을 거절했습니다.',
      color: newStatus === 'O' ? 'success' : 'error'
    }
  } catch (error) {
    snackbar.value = {
      show: true,
      message: '처리 중 오류가 발생했습니다.',
      color: 'error'
    }
  }
}

// Watches
watch(() => store.pickerDate, async (newDate) => {
  console.log('Watch triggered - New Date:', newDate)
  if (newDate) {
    await store.fetchReservations(newDate)
  }
})
</script>

<style scoped>
.v-date-picker {
  width: 100%;
}

:deep(.custom-calendar) {
  .v-date-picker-header {
    padding: 4px 8px;
  }
  
  .v-date-picker-header__value {
    color: #E2495B;
  }

  .v-btn--active {
    background-color: #E2495B !important;
    color: white !important;
  }

  .v-btn:not(.v-btn--active) {
    color: #666;
  }

  .v-date-picker-table {
    height: auto;
  }
}
</style>