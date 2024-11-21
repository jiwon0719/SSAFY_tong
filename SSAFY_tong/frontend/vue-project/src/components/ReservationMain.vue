<template>
  <div class="content-wrapper h-100 cursor-pointer" @click="navigateToCalendar">
    <div class="container">
      <!-- Animated header -->
      <div class="schedule-header">
        <div class="schedule-icon mb-4">
          <!-- <v-icon size="24" color="#333">mdi-calendar</v-icon> -->
        </div>
        <div class="date-text">
          <div v-for="(line, idx) in lines" :key="idx" class="date-line">
            {{ line }}
          </div>
        </div>
      </div>

      <!-- Cards container -->
      <div class="cards-container">
        <!-- Quest card -->
        <div class="card-wrapper">
          <div class="title-text">Quest</div>
          <v-card class="inner-card" elevation="0">
            <v-card-text class="pa-4">
              <div v-if="isLoading" class="text-center">
                <v-progress-circular indeterminate color="#E2495B" size="32"></v-progress-circular>
              </div>
              <v-list v-else-if="todayQuests.length > 0" density="comfortable">
                <v-list-item v-for="quest in todayQuests" :key="quest.questId" class="list-item mb-2">
                  <v-list-item-title class="d-flex align-center justify-space-between">
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" size="20" class="mr-2">mdi-trophy-outline</v-icon>
                      <span class="quest-title">{{ quest.questTitle }}</span>
                      <span class="quest-detail ml-2">({{ quest.questDetail }})</span>
                    </div>
                    <v-chip
                      :color="getQuestStatusColor(quest.completionStatus)"
                      size="small"
                      class="status-chip"
                    >
                      {{ getQuestStatusText(quest.completionStatus) }}
                    </v-chip>
                  </v-list-item-title>
                </v-list-item>
              </v-list>
              <div v-else class="empty-text">
                오늘의 퀘스트가 없습니다 ✨
              </div>
            </v-card-text>
          </v-card>
        </div>

        <!-- Reservation card -->
        <div class="card-wrapper">
          <div class="title-text">Reservation</div>
          <v-card class="inner-card" elevation="0">
            <v-card-text class="pa-4">
              <div v-if="isLoading" class="text-center">
                <v-progress-circular indeterminate color="#E2495B" size="32"></v-progress-circular>
              </div>
              <v-list v-else-if="todayReservations.length > 0" density="comfortable">
                <v-list-item v-for="reservation in todayReservations" :key="reservation.reservationId" class="list-item mb-2">
                  <v-list-item-title class="d-flex align-center justify-space-between">
                    <div class="d-flex align-center">
                      <v-icon color="#E2495B" size="20" class="mr-2">mdi-clock-outline</v-icon>
                      <span class="time-text">{{ reservation.time }}</span>
                    </div>
                    <div class="d-flex align-center">
                      <span class="expert-text mr-2">{{ reservation.expertUserId }}</span>
                      <v-chip
                        :color="getStatusColor(reservation.status)"
                        size="small"
                        class="status-chip"
                      >
                        {{ getStatusText(reservation.status) }}
                      </v-chip>
                    </div>
                  </v-list-item-title>
                </v-list-item>
              </v-list>
              <div v-else class="empty-text">
                새로운 수업을 예약해보세요 💝
              </div>
            </v-card-text>
          </v-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, watch } from 'vue'
import { storeToRefs } from 'pinia'
import { useCalendarStore } from '@/stores/calendar'
import { useRouter } from 'vue-router'

const router = useRouter()
const store = useCalendarStore()
const { isLoading, calendarData } = storeToRefs(store)

const lines = ref([])

const initAnimation = () => {
  const date = new Date()
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const dayOfWeek = new Intl.DateTimeFormat('ko-KR', { weekday: 'long' }).format(date)
  
  const allLines = [
    `${year}년`, 
    `${month}월 ${day}일`,
    dayOfWeek,
    '일정을 확인하세요'
  ]

  let currentIndex = 0
  const interval = setInterval(() => {
    if (currentIndex < allLines.length) {
      lines.value.push(allLines[currentIndex])
      currentIndex++
    } else {
      clearInterval(interval)
    }
  }, 300)
}

// 오늘 퀘스트, 예약 일정 보여주기
// 현재 날짜로 고정
const today = ref(`${new Date().getFullYear()}-${String(new Date().getMonth() + 1).padStart(2, '0')}-${String(new Date().getDate()).padStart(2, '0')}`)

const navigateToCalendar = () => {
  router.push('/calendar')
}

const todayQuests = computed(() => calendarData.value?.quests ?? [])
const todayReservations = computed(() => calendarData.value?.reservations ?? [])

const getQuestStatusColor = (status) => {
  switch(status) {
    case 'O': return 'success'
    case 'F': return 'error'
    default: return 'warning'
  }
}

const getQuestStatusText = (status) => {
  switch(status) {
    case 'O': return '성공'
    case 'F': return '실패'
    default: return '도전중'
  }
}

const getStatusColor = (status) => {
  switch(status) {
    case 'O': return '#E2495B'
    case 'R': return '#9E9E9E'
    default: return '#FFA726'
  }
}

const getStatusText = (status) => {
  switch(status) {
    case 'O': return '예약 확정'
    case 'R': return '예약 취소'
    default: return '신청 중'
  }
}

onMounted(async () => {
  initAnimation()
  try {
    await store.fetchCalendarByDate(today.value)
    console.log('Fetching data for:', today.value)
  } catch (error) {
    console.error('Failed to fetch calendar data:', error)
  }
})

watch(() => calendarData.value, (newValue) => {
  console.log('Calendar data updated:', newValue)
}, { deep: true })
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

.content-wrapper {
  padding: 20px;
  font-family: 'Noto Sans KR', sans-serif;
  height: 100%;
}

.container {
  display: flex;
  height: 100%;
  gap: 24px;
}

.schedule-header {
  width: 200px; /* 날짜 안내  사이즈 */
  padding: 5px 0;
}

.date-text {
  font-size: 22px; /* 날짜 안내 글자 크기 */
  font-weight: 700;
  color: #333;
}

/* 애니메이션 시간 조절 */
.date-line {
  animation: slideIn 1.5s ease-out;
  margin-bottom: 4px;
}

@keyframes slideIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.cards-container {
  flex: 1;
  display: flex;
  gap: 24px;
}

.card-wrapper {
  flex: 1.5; /* 카드 크기 */
  background-color: #F8F9FE;
  border-radius: 16px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  min-height: 0;
}

.title-text {
  font-size: 24px;
  font-weight: 700;
  color: #E2495B;
  margin-bottom: 16px;
  letter-spacing: 0.5px;
}

.inner-card {
  background-color: white;
  border-radius: 12px;
  flex: 1;
  display: flex;
  flex-direction: column;
}

.v-card-text {
  flex: 1;
  overflow-y: auto;
  padding: 16px !important;
}

.v-list {
  height: auto;
  background: transparent !important;
  padding: 0 !important;
}

:deep(.v-list) {
  overflow: hidden !important;
}

.list-item {
  background-color: #F8F9FE !important;
  border-radius: 8px !important;
  transition: transform 0.2s;
}

.list-item:hover {
  transform: translateX(4px);
}

.quest-title, .time-text {
  font-size: 16px;
  font-weight: 500;
}

.quest-detail, .expert-text {
  font-size: 14px;
  color: #666;
}

.status-chip {
  font-size: 12px !important;
  font-weight: 700 !important;
}

.empty-text {
  text-align: center;
  color: #666;
  font-size: 16px;
  padding: 32px 0;
}

.cursor-pointer {
  cursor: pointer;
}

.h-100 {
  height: 100%;
}
</style>