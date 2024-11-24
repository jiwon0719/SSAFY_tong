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
              color="#E2495B"
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
              color="#E2495B"
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
                    <!-- {{ item.raw.name }} -->
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
              <v-list v-if="sortedQuests.length > 0">
                <v-list-item v-for="quest in sortedQuests" :key="quest.questId">
                  <v-list-item-title class="d-flex align-center justify-space-between text-subtitle-1 my-2">
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" class="mr-2">mdi-trophy-outline</v-icon>
                      {{ quest.questTitle }}
                    </div>
                    <div class="d-flex align-center">
                      <span class="mr-2">{{ quest.questDetail }}</span>
                      <!-- 상태 칩 -->
                      <v-chip
                        :color="getQuestStatusColor(quest.completionStatus)"
                        size="small"
                        class="mr-2 white--text"
                      >
                        {{ getQuestStatusText(quest.completionStatus) }}
                      </v-chip>
                      <!-- 상태가 'X'(도전중)일 때만 버튼 표시 -->
                      <div v-if="quest.completionStatus === 'X'" class="d-flex">
                        <v-btn
                          size="small"
                          color="success"
                          class="mr-1"
                          @click="updateQuestStatus(quest.questId, 'O')"
                          variant="tonal"
                        >
                          성공
                        </v-btn>
                        <v-btn
                          size="small"
                          color="error"
                          @click="updateQuestStatus(quest.questId, 'F')"
                          variant="tonal"
                        >
                          실패
                        </v-btn>
                      </div>
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
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';

// Store
const store = useCalendarStore()
const userStore = useUserStore()
const quests = ref([])
const calendarData = ref({
  quests: [],
  reservations: []
})
const reservations = ref([])

// 반응형 데이터
const { userId } = storeToRefs(userStore);

// Local state
const showReservationForm = ref(false)  
const snackbar = ref(false)
const snackbarText = ref('')
const snackbarColor = ref('#E2495B')

// 오늘 날짜 이전은 선택 불가 (예약 폼에서만 사용)
const minDate = new Date().toISOString().split('T')[0]

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
   await store.createReservation(userId.value)
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
    const data = await store.fetchCalendarByDate(newDate)
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


// 오늘 날짜 가져오기
const today = computed(() => {
  return new Date().toISOString().split('T')[0]
})


onMounted(async () => {
  try {
    // 데이터가 없을 때만 초기 로드
    if (!store.reservations.length && !quests.value.length) {
      const data = await store.loadInitialData(userId.value)
      if (data.calendar) {
        quests.value = data.calendar.quests
        reservations.value = data.calendar.reservations
        calendarData.value = data.calendar
      }
    }
  } catch (error) {
    showSnackbar('데이터 조회에 실패했습니다.', 'error')
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

const { sortedReservations, sortedQuests } = storeToRefs(store)

// 퀘스트 상태 관련 함수
const getQuestStatusColor = (completionStatus) => {
  switch(completionStatus) {
    case 'O': return 'success'    // 성공
    case 'F': return 'error'      // 실패
    default: return 'warning'     // 도전중 (X)
  }
}

const getQuestStatusText = (completionStatus) => {
  switch(completionStatus) {
    case 'O': return '성공'
    case 'F': return '실패'
    default: return '도전중'
  }
}

// 퀘스트 상태 업데이트 함수
const updateQuestStatus = async (questId, newStatus) => {
  try {
    // API 호출 - 실제 구현 시 store에 추가
    await store.updateQuestStatus(questId, newStatus)
    
    // 로컬 상태 업데이트
    const questIndex = quests.value.findIndex(q => q.questId === questId)
    if (questIndex !== -1) {
      quests.value[questIndex] = {
        ...quests.value[questIndex],
        completionStatus: newStatus
      }
    }
    
    showSnackbar('퀘스트 상태가 업데이트되었습니다.', 'success')
  } catch (error) {
    console.error('퀘스트 상태 업데이트 실패:', error)
    showSnackbar('퀘스트 상태 업데이트에 실패했습니다.', 'error')
  }
}

</script>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

<style scoped>
/* 컴포넌트 전체에 폰트 적용 */
:deep(.v-application) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

/* 모든 텍스트 요소에 폰트 적용 */
:deep(.text-h6),
:deep(.text-subtitle-1),
:deep(.v-list-item-title),
:deep(.v-list-item-subtitle),
:deep(.v-card-title),
:deep(.v-card-subtitle),
:deep(.v-card-text),
:deep(.v-btn),
:deep(.v-chip) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

.v-date-picker {
  width: 100%;
}

/* 캘린더 커스텀 스타일 */
:deep(.custom-calendar) {
  .v-date-picker-header {
    padding: 4px 8px;
    font-family: 'Noto Sans KR', sans-serif !important;
  }
  
  .v-date-picker-header__value {
    color: #E2495B;
    font-family: 'Noto Sans KR', sans-serif !important;
  }

  /* 날짜 버튼 기본 스타일 */
  .v-date-picker-month button {
    color: #666;
    font-family: 'Noto Sans KR', sans-serif !important;
  }

  /* 선택된 날짜 스타일 */
  .v-date-picker-month button.v-btn--selected {
    background-color: #E2495B !important;
    color: white !important;
  }

  /* hover 상태 */
  .v-date-picker-month button:hover {
    background-color: rgba(226, 73, 91, 0.1) !important;
  }

  /* 오늘 날짜 스타일 */
  .v-date-picker-month button.v-btn--today {
    border: 1px solid #E2495B;
  }

  .v-date-picker-table {
    height: auto;
  }
}
</style>