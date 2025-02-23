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

            <!-- 퀘스트 생성 버튼 -->
            <v-btn
              color="#E2495B"
              class="mt-4 white--text"
              block
              @click="showQuestForm = !showQuestForm"
              v-if="!showQuestForm"
            >
              퀘스트 생성하기
            </v-btn>
          </v-card>

          <!-- 퀘스트 생성 폼 -->
          <v-card v-if="showQuestForm" class="mt-4 pa-4" color="white">
            <div class="d-flex justify-space-between align-center mb-4">
              <div class="text-h6" style="color: #E2495B">Create Quest</div>
              <v-btn icon @click="showQuestForm = false" color="#E2495B">
                <v-icon>mdi-close</v-icon>
              </v-btn>
            </div>
            
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
          </v-card>
        </v-col>
 
        <!-- 우측: 예약 및 퀘스트 관리 -->
        <v-col cols="12" sm="6" class="my-2 px-1">
          <!-- 예약 -->
          <v-card color="white">
            <v-card-title class="text-h6 d-flex align-center" style="color: #E2495B" >
              Reservation
              <span class="text-subtitle-1 ml-2" style="color: rgba(226, 73, 91, 0.7)">
                {{ store.pickerDate ? new Date(store.pickerDate).toLocaleDateString('ko-KR', {
                  year: 'numeric', 
                  month: 'long', 
                  day: 'numeric'
                }) : '' }}
              </span>
            </v-card-title>
            <v-card-subtitle style="color: black">
              예약 요청을 확인하세요!
            </v-card-subtitle>
            <v-card-text>
              <v-list v-if="filteredReservations.length > 0">
              <v-list-item v-for="reservation in filteredReservations" 
                          :key="reservation.reservationId"
                          :class="{'grey lighten-4': reservation.status !== 'X'}">
                <v-list-item-content>
                  <v-list-item-title class="d-flex justify-space-between align-center">
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" class="mr-2">mdi-clock-outline</v-icon>
                      {{ reservation.time }}
                    </div>
                    <div class="d-flex align-center">
                      <div class="d-flex align-center mr-4">
                        <v-icon color="#E2495B" class="mr-2">mdi-account</v-icon>
                        {{ getUserName(reservation.userId) }}
                      </div>
                      <v-chip
                        :color="reservation.status === 'O' ? STATUS_COLORS.ACCEPTED : 
                                (reservation.status === 'R' ? STATUS_COLORS.REJECTED : STATUS_COLORS.PENDING)"
                        small
                        class="mr-4 white--text"
                      >
                        {{ reservation.status === 'O' ? '수락됨' : (reservation.status === 'R' ? '거절됨' : '신청 중') }}
                      </v-chip>
                      <div v-if="reservation.status === 'X'" class="d-flex">
                        <v-btn
                          :color="STATUS_COLORS.ACCEPTED"
                          size="small"
                          class="mr-2"
                          @click="handleStatusChange(reservation.reservationId, 'O')"
                        >
                          수락
                        </v-btn>
                        <v-btn
                          :color="STATUS_COLORS.REJECTED"
                          size="small"
                          @click="handleStatusChange(reservation.reservationId, 'R')"
                        >
                          거절
                        </v-btn>
                      </div>
                    </div>
                  </v-list-item-title>
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
              Quest
              <span class="text-subtitle-1 ml-2" style="color: rgba(226, 73, 91, 0.7)">
                  {{ store.pickerDate ? new Date(store.pickerDate).toLocaleDateString('ko-KR', {
                    year: 'numeric', 
                    month: 'long', 
                    day: 'numeric'
                  }) : '' }}
                </span>
            </v-card-title>
            <v-card-subtitle style="color: black">
              당신의 회원에게 퀘스트를 생성하고 관리하세요!
            </v-card-subtitle>

            <v-card-text>
              <!-- 퀘스트 목록 -->
              <v-list v-if="store.quests.length > 0">
                <v-list-item v-for="quest in store.quests" :key="quest.questId" class="mb-2">
                  <v-list-item-content>
                    <v-list-item-title class="d-flex align-center justify-space-between">
                      <div class="d-flex align-center">
                        <v-icon color="#E2495B" class="mr-2">mdi-trophy-outline</v-icon>
                        <span>{{ quest.questTitle }}</span>
                      </div>
                      <div class="d-flex align-center">
                        <span class="grey--text mx-4 text-truncate">{{ quest.questDetail }}</span>
                        <div class="d-flex align-center mx-4">
                          <v-icon small color="grey" class="mr-1">mdi-account</v-icon>
                          {{ getUserName(quest.userId) }}
                        </div>
                        <v-chip
                          :color="getQuestStatusColor(quest.completionStatus)"
                          small
                          class="white--text"
                        >
                          {{ getQuestStatusText(quest.completionStatus) }}
                        </v-chip>
                      </div>
                    </v-list-item-title>
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

const showQuestForm = ref(false)       // 퀘스트 폼 표시 여부
const isFormValid = ref(false)         // 폼 유효성 상태
const questForm = ref(null)            // 폼 참조

const newQuest = ref({
  userId: '',
  title: '',
  description: ''
})

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
    // 폼 닫기 (추가된 부분)
    showQuestForm.value = false
    
    await store.fetchQuests()
    
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

// userId를 사용자 이름으로 변환하는 함수
const getUserName = (userId) => {
  const user = store.userMatchingList.find(user => user.userId === userId)
  return user ? user.name : userId // 매칭된 사용자가 없으면 ID를 반환
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

<style scoped>
/* 구글 폰트 - Noto Sans KR 불러오기 */
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

/* 컴포넌트 내의 모든 요소에 Noto Sans KR 폰트 적용 */
:deep(*) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

/* 달력 기본 스타일 */
.v-date-picker {
  width: 100%;
}

/* 커스텀 달력 스타일 */
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

/* 리스트 아이템 스타일 */
.v-list-item {
  margin-bottom: 8px;
}

/* Vuetify 특정 컴포넌트들에 대한 폰트 강제 적용 */
:deep(.v-application) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

:deep(.v-btn) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

:deep(.v-list-item),
:deep(.v-card-title),
:deep(.v-card-subtitle),
:deep(.v-card-text) {
  font-family: 'Noto Sans KR', sans-serif !important;
}

/* 리스트 아이템 내 요소들 정렬 */
.list-item-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}

.list-item-actions {
  display: flex;
  align-items: center;
}


</style>