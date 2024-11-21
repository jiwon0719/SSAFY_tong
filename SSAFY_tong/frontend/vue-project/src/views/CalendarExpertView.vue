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
              color="#E2495B"
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
                          :color="reservation.status === 'O' ? STATUS_COLORS.ACCEPTED : 
                                 (reservation.status === 'R' ? STATUS_COLORS.REJECTED : STATUS_COLORS.PENDING)"
                          small
                          class="ml-2 white--text"
                        >
                          {{ reservation.status === 'O' ? '수락됨' : (reservation.status === 'R' ? '거절됨' : '신청 중') }}
                        </v-chip>
                      </div>
                    </v-list-item-title>
                    
                    <!-- 버튼 -->
                    <div class="d-flex justify-end mt-2" v-if="reservation.status === 'X'">
                      <v-btn
                        :color="STATUS_COLORS.ACCEPTED"
                        small
                        class="mr-2"
                        @click="handleStatusChange(reservation.reservationId, 'O')"
                      >
                        수락
                      </v-btn>
                      <v-btn
                        :color="STATUS_COLORS.REJECTED"
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

          <!-- 퀘스트 관리 카드 -->
          <v-card color="white" class="mt-4">
            <v-card-title class="text-h6" style="color: #E2495B">
              Quest Management
            </v-card-title>
            <v-card-subtitle style="color: rgba(226, 73, 91, 0.7)">
              매칭된 회원에게 퀘스트를 생성하고 관리하세요
            </v-card-subtitle>

            <v-card-text>
              <v-expansion-panels>
                <v-expansion-panel>
                  <v-expansion-panel-header>
                    <v-icon color="#E2495B" class="mr-2">mdi-plus</v-icon>
                    새 퀘스트 생성
                  </v-expansion-panel-header>
                  <v-expansion-panel-content>
                    <v-form ref="questForm" v-model="isFormValid">
                      <v-select
                        v-model="newQuest.userId"
                        :items="store.userMatchingList"
                        item-title="name"
                        item-value="userId"
                        label="매칭된 회원 선택"
                        required
                        :rules="[v => !!v || '회원을 선택해주세요']"
                      ></v-select>
                      
                      <v-text-field
                        v-model="newQuest.title"
                        label="퀘스트 제목"
                        required
                        :rules="[v => !!v || '제목을 입력해주세요']"
                      ></v-text-field>
                      
                      <v-textarea
                        v-model="newQuest.description"
                        label="퀘스트 내용"
                        required
                        :rules="[v => !!v || '내용을 입력해주세요']"
                      ></v-textarea>

                      <v-btn
                        color="#E2495B"
                        class="white--text"
                        @click="createQuest"
                        :disabled="!isFormValid"
                      >
                        퀘스트 생성
                      </v-btn>
                    </v-form>
                  </v-expansion-panel-content>
                </v-expansion-panel>
              </v-expansion-panels>

              <!-- 퀘스트 목록 -->
              <v-list v-if="store.quests.length > 0" class="mt-4">
                <v-list-item v-for="quest in store.quests" :key="quest.questId" class="mb-2">
                  <v-list-item-content>
                    <v-list-item-title class="d-flex justify-space-between align-center">
                      <div>
                        <v-icon color="#E2495B" class="mr-2">mdi-trophy-outline</v-icon>
                        {{ quest.questTitle }}
                      </div>
                      <v-chip
                        :color="getQuestStatusColor(quest.completionStatus)"
                        small
                        class="white--text"
                      >
                        {{ getQuestStatusText(quest.completionStatus) }}
                      </v-chip>
                    </v-list-item-title>
                    
                    <v-list-item-subtitle class="mt-2">
                      <div class="d-flex align-center">
                        <v-icon small color="grey" class="mr-1">mdi-account</v-icon>
                        {{ quest.userId }}
                      </div>
                    </v-list-item-subtitle>
                    
                    <v-list-item-subtitle class="mt-2 grey--text">
                      {{ quest.questDetail }}
                    </v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
              <div v-else class="text-center pa-4 text-subtitle-1">
                생성된 퀘스트가 없습니다.
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
import { ref, computed, watch, onMounted } from 'vue'
import { useExpertCalendarStore } from '@/stores/expertCalendar'
import { useUserStore } from '@/stores/user';

const store = useExpertCalendarStore()
const userStore = useUserStore();

const expertId = userStore.userId;

// 색상 상수 정의
const STATUS_COLORS = {
  ACCEPTED: '#1976d2',
  REJECTED: '#9E9E9E',
  PENDING: '#FFA726'
}

// Local state for snackbar
const snackbar = ref({
  show: false,
  message: '',
  color: ''
})

// Computed for reservations
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

// Quest Management
const isFormValid = ref(false)
const questForm = ref(null)

const newQuest = ref({
  userId: '',
  title: '',
  description: ''
})

// 스낵바 메시지 추가
const showMessage = (message, color = 'success') => {
  snackbar.value = {
    show: true,
    message,
    color
  }
}

// Calendar functions
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

// Quest functions
const getQuestStatusColor = (status) => {
  const colors = {
    'X': '#4CAF50',  // 초록색
    'O': '#1976D2',  // 파란색
    'F': '#9E9E9E'   // 회색
  }
  return colors[status] || '#757575'
}

const getQuestStatusText = (status) => {
  const texts = {
    'X': '진행중',
    'O': '완료됨',
    'F': '실패'
  }
  return texts[status] || '알 수 없음'
}

const createQuest = async () => {
  console.log("createQuest 함수 시작")
  console.log("questForm 상태:", questForm.value);  // form 상태 확인
  console.log("isFormValid 상태:", isFormValid.value);  // validation 상태 확인
  
  if (!questForm.value.validate()) return
  
  if (!store.pickerDate) {
    showMessage('날짜를 선택해주세요.', 'error')
    return
  }

  console.log("선택한 날짜: ", store.pickerDate)

  try {
    // 선택된 날짜를 'YYYY-MM-DD' 형식으로 변환
    const selectedDate = new Date(store.pickerDate)
    const formattedDate = `${selectedDate.getFullYear()}-${String(selectedDate.getMonth() + 1).padStart(2, '0')}-${String(selectedDate.getDate()).padStart(2, '0')}`
    
    console.log("포맷된 날짜:", formattedDate)
    
    const questData = {
      expertUserId: expertId,
      userId: newQuest.value.userId,
      questTitle: newQuest.value.title,
      questDetail: newQuest.value.description, 
      pickDate: formattedDate,
      completionStatus: 'X' 
    }

    console.log("생성할 퀘스트 데이터:", questData)
    await store.createQuest(questData)
    
    showMessage('퀘스트가 성공적으로 생성되었습니다.')
    
    // 폼 초기화
    questForm.value.reset()
    newQuest.value = {
      userId: '',
      title: '',
      description: ''
    }
    
    // 퀘스트 목록 새로고침
    await store.fetchQuests()
  } catch (error) {
    console.error('Quest creation error:', error)
    showMessage('퀘스트 생성에 실패했습니다.', 'error')
  }
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
    await store.fetchQuests(newDate)
  }
})


// 컴포넌트 마운트 시 데이터 로드
onMounted(async () => {
  try {
    if (!store.pickerDate.value) {
      store.setPickerDate(new Date()) // 날짜가 없으면 현재 날짜 설정
    }
    await store.getExpertMatchings()
    await store.fetchReservations(store.pickerDate.value) // 예약 데이터도 함께 로드
    await store.fetchQuests()
  } catch (error) {
    showMessage('데이터 로딩에 실패했습니다.', 'error')
  }
})
</script>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

<style scoped>
:deep(*) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

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

.v-list-item {
  border: 1px solid #eee;
  border-radius: 8px;
  margin-bottom: 8px;
}
</style>