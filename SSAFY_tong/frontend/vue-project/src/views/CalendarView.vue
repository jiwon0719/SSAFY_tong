<template>
  <v-app>
    <v-container>
      <v-row>
        <!-- 좌측: 캘린더 또는 예약 폼 -->
        <v-col cols="12" sm="6" class="my-2 px-1">
          <!-- 캘린더 영역 -->
          <v-card v-if="!showReservationForm" class="pa-4" color="white">
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

          <!-- 예약 폼 영역 -->
          <v-card v-else class="pa-4" color="white">
            <div class="d-flex justify-space-between align-center mb-4">
              <div class="text-h6" style="color: #E2495B">Reservation</div>
              <v-btn icon @click="showReservationForm = false" color="#E2495B">
                <v-icon>mdi-close</v-icon>
              </v-btn>
            </div>

            <v-date-picker
              v-model="store.pickerDate"
              class="mx-auto custom-calendar"
              elevation="0"
              :min="minDate"
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

            <!-- 전문가 선택 -->
            <v-select
              v-model="store.selectedExpertId"
              :items="store.matchingExperts"
              item-title="name" 
              item-value="userId"
              label="전문가 선택"
              class="mb-4"
              color="#E2495B"
              persistent-hint
              @update:model-value="handleExpertSelect"        
            >
              <!-- 커스텀 아이템 템플릿 -->
              <template v-slot:item="{ props, item }">
                <v-list-item 
                  v-bind="props"
                  @click="handleExpertSelect(item.raw)"
                >
                  <v-list-item-title>
                    {{ item.raw.name }}
                  </v-list-item-title>
                  <v-list-item-subtitle>
                    {{ item.raw.grade }} ({{ item.raw.userId }})
                  </v-list-item-subtitle>
                </v-list-item>
              </template>      
            </v-select>
            <!-- item-title : 화면에 표시되는 값 -->
            <!-- item-value : 실제 선택되는 값 -->

            <!-- 시간 선택 -->
            <v-select
              v-model="store.selectedTime"
              :items="store.availableTimes"
              label="예약 시간 선택"
              :disabled="!store.selectedExpertId"
              class="mb-4"
              color="#E2495B"
            ></v-select>

            <v-btn
              block
              color="#E2495B"
              @click="handleReservation"
              :disabled="!store.selectedTime || !store.selectedExpertId"
              :loading="store.isLoading"
              class="white--text"
            >
              예약 신청하기
            </v-btn>
          </v-card>
        </v-col>

        <!-- 우측: 퀘스트와 예약 일정 -->
        <v-col cols="12" sm="6" class="my-2 px-1">
          <!-- 퀘스트 섹션 -->
          <v-card class="mb-4" color="white">
          <v-card-title class="text-h6 d-flex align-center" style="color: #E2495B">
            Quest
            <span class="text-subtitle-1 ml-2" style="color: rgba(226, 73, 91, 0.7)">
              {{ store.pickerDate ? new Date(store.pickerDate).toLocaleDateString('ko-KR', {
                year: 'numeric', 
                month: 'long', 
                day: 'numeric'
              }) : new Date().toLocaleDateString('ko-KR', {
                year: 'numeric',
                month: 'long', 
                day: 'numeric'
              }) }}
            </span>
          </v-card-title>
          <v-card-subtitle style="color: rgba(226, 73, 91, 0.7)">
            당신의 트레이너가 정해준 퀘스트를 확인하세요!
          </v-card-subtitle>
          <v-card-text>
            <v-list v-if="quests.length > 0">
              <v-list-item v-for="quest in quests" :key="quest.questId">
                <v-list-item-title class="d-flex align-center justify-space-between text-subtitle-1 my-2">
                  <div class="d-flex align-center">
                    <v-icon color="#E2495B" class="mr-2">mdi-trophy-outline</v-icon>
                    {{ quest.questTitle }}
                  </div>
                  <div class="d-flex align-center">
                    {{ quest.questDetail }}
                  </div>
                </v-list-item-title>
              </v-list-item>
            </v-list>
            <div v-else class="text-center pa-4 text-subtitle-1">
              등록된 퀘스트가 없습니다.
            </div>
          </v-card-text>
          </v-card>

          <!-- 예약 일정 섹션 -->
          <v-card color="white">
            <v-card-title class="text-h6 d-flex align-center" style="color: #E2495B">
              Reservation 
              <span class="text-subtitle-1 ml-2" style="color: rgba(226, 73, 91, 0.7)">
                {{ store.pickerDate ? new Date(store.pickerDate).toLocaleDateString('ko-KR', {
                  year: 'numeric', 
                  month: 'long', 
                  day: 'numeric'
                }) : new Date().toLocaleDateString('ko-KR', {
                  year: 'numeric',
                  month: 'long', 
                  day: 'numeric'
                }) }}
              </span>
            </v-card-title>
            <v-card-subtitle style="color: rgba(226, 73, 91, 0.7)">
              운동 일정을 확인하세요!
            </v-card-subtitle>
            <v-card-text>
              <v-list v-if="store.reservations.length > 0">
                <v-list-item v-for="reservation in sortedReservations" :key="reservation.reservationId">
                  <v-list-item-title class="d-flex align-center justify-space-between text-subtitle-1 my-2">
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" class="mr-2">mdi-clock-outline</v-icon>
                      {{ reservation.time }}
                    </div>
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" class="mr-2">mdi-account</v-icon>
                      {{ reservation.expertUserId }}
                      <v-chip
                        :color="getStatusColor(reservation.status)"
                        size="small"
                        class="ml-2 white--text"
                      >
                        {{ getStatusText(reservation.status) }}
                      </v-chip>
                    </div>
                  </v-list-item-title>
                </v-list-item>
              </v-list>
              <div v-else class="text-center pa-4 text-subtitle-1">
                예약된 일정이 없습니다.
              </div>
            </v-card-text>
          </v-card>

          <!-- 예약 신청 버튼 -->
          <v-btn
            color="#E2495B"
            class="mt-4 white--text"
            block
            @click="showReservationForm = true"
            v-if="!showReservationForm"
          >
            예약 신청하기
          </v-btn>
        </v-col>
      </v-row>

      <!-- 스낵바 -->
      <v-snackbar v-model="snackbar" :color="snackbarColor">
        {{ snackbarText }}
      </v-snackbar>
    </v-container>
  </v-app>
</template>

<script setup>
import { ref, watch, computed, onMounted } from 'vue'
import { useCalendarStore } from '@/stores/calendar'

// Store
const store = useCalendarStore()
const quests = ref([])
const calendarData = ref({
  quests: [],
  reservations: []
})
const reservations = ref([])

// Local state
const showReservationForm = ref(false)  
const snackbar = ref(false)
const snackbarText = ref('')
const snackbarColor = ref('#E2495B')

// 오늘 날짜 이전은 선택 불가 (예약 폼에서만 사용)
const minDate = new Date().toISOString().split('T')[0]

// 현재 로그인한 사용자 ID (실제로는 auth store 등에서 가져와야 함)
const userId = 'user'

// 이벤트 데이터 (퀘스트와 예약이 있는 날짜)
const events = computed(() => {
  if (!quests.value || !store.reservations) return []
  
  const questEvents = quests.value?.map(quest => ({
    date: quest.pickDate,
    type: 'quest'
  })) || []
  
  const reservationEvents = store.reservations?.map(reservation => ({
    date: reservation.pickDate,
    type: 'reservation'
  })) || []

  return [...questEvents, ...reservationEvents]
})

// 이벤트 타입에 따른 색상 지정
const getEventColor = (event) => {
 return event.type === 'quest' ? '#E2495B' : '#FFB6C1'
}

// 날짜 포맷팅
const formatDate = (date) => {
 if (!date) return ''
 const d = new Date(date)
 return new Intl.DateTimeFormat('ko-KR', {
   year: 'numeric',
   month: 'long'
 }).format(d)
}

// 스낵바 표시 함수 
const showSnackbar = (text, color = '#E2495B') => {
 snackbarText.value = text
 snackbarColor.value = color
 snackbar.value = true
}

// 예약 처리
const handleReservation = async () => {
 try {
   await store.createReservation(userId)
   showSnackbar('예약이 신청되었습니다.')
   showReservationForm.value = false
 } catch (error) {
   showSnackbar('예약 신청에 실패했습니다.', 'error')
 }
}

// 전문가 선택
const handleExpertSelect = (expert) => {
 if (expert) {
   store.selectedExpertId = expert
 }
}

// Watches
// 날짜 선택 시 데이터 조회 로직
watch(() => store.pickerDate, async (newDate) => {
  if (!newDate) return
  
  try {
    const data = await store.fetchCalendarByDate(userId, newDate)
    console.log('Calendar data received:', data)
    calendarData.value = data // store에서 이미 형식화된 데이터를 받음
    quests.value = data.quests
    reservations.value = data.reservations
  } catch (error) {
    console.error('데이터 조회 실패:', error)
    showSnackbar('일정 조회에 실패했습니다.', 'error')
  }
})

// 선택된 전문가 감시
watch(() => store.selectedExpertId, (newExpert) => {
 if (newExpert) {
   console.log('Selected expert changed:', newExpert)
 }
}, { deep: true })

// Lifecycle Hooks
onMounted(async () => {
 try {
   await store.fetchMatchingExperts(userId)
 } catch (error) {
   showSnackbar('전문가 목록 조회에 실패했습니다.', 'error')
 }
})


const getStatusColor = (status) => {
  switch(status) {
    case 'O': return '#E2495B'  // 수락됨
    case 'R': return '#9E9E9E'  // 거절됨
    default: return '#FFA726'   // 신청 중
  }
}

const getStatusText = (status) => {
  switch(status) {
    case 'O': return '예약 확정'
    case 'R': return '예약 취소'
    default: return '신청 중'
  }
}

const sortedReservations = computed(() => {
 return [...store.reservations].sort((a, b) => a.time.localeCompare(b.time))
})

</script>

<style scoped>
.v-date-picker {
  width: 100%;
}

/* 캘린더 커스텀 스타일 */
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