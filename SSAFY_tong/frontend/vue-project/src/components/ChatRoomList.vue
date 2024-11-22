<template>
  <div class="chat-list">
    <h1>채팅방 목록</h1>
    
    <!-- 에러 메시지 표시 -->
    <div v-if="error" class="error-message">
      {{ error }}
    </div>
    
    <!-- 채팅방 목록 -->
    <div v-else>
      <div v-if="matchedRooms.length === 0" class="no-rooms">
        현재 진행 중인 채팅이 없습니다.
      </div>
      <div 
        v-else
        v-for="room in matchedRooms" 
        :key="room.matchingId" 
        class="chat-link"
        @click="enterRoom(room)"
      >
        <img :src="defaultAvatar" alt="avatar" class="avatar" />
        <div class="chat-details">
          <div class="chat-name">
            {{ room.partnerName }}
          </div>
          <div class="chat-message">{{ room.lastMessage || '새로운 대화를 시작하세요' }}</div>
        </div>
        <div class="chat-meta">
          <div class="chat-date">{{ room.lastMessageTime || '' }}</div>
          <div v-if="room.unreadCount > 0" class="unread-badge">
            {{ room.unreadCount }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '../stores/user';
import axios from 'axios';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

export default {
  name: 'ChatRoomList',
  setup() {
    const router = useRouter();
    const userStore = useUserStore();
    const matchedRooms = ref([]);
    const error = ref(null);
    const defaultAvatar = "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg";
    const stompClient = ref(null);
    const userId = userStore.getUserId;
    const updateInterval = ref(null);

    // WebSocket 구독 관리를 위한 Map 추가
    const subscriptions = ref(new Map());

    // 읽지 않은 메시지 수 업데이트 함수 수정
    const updateUnreadCounts = async () => {
      if (!matchedRooms.value) return;
      
      try {
        const responses = await Promise.all(
          matchedRooms.value.map(room => 
            axios.get(
              `http://localhost:8080/api/chat/unread/${room.matchingId}/${userId}`,
              {
                headers: {
                  'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
                }
              }
            )
          )
        );
        
        responses.forEach((response, index) => {
          matchedRooms.value[index].unreadCount = response.data;
        });
      } catch (error) {
        console.error('Error updating unread counts:', error);
      }
    };

    // 채팅방 구독 함수 수정
    const subscribeToRoom = (room) => {
      if (subscriptions.value.has(room.matchingId)) {
        return;
      }

      const subscription = stompClient.value.subscribe(
        `/topic/chat/${room.matchingId}`,
        async (message) => {
          try {
            const receivedMessage = JSON.parse(message.body);
            console.log(`Received message in room ${room.matchingId}:`, receivedMessage);

            if (receivedMessage.type === 'CHAT' && receivedMessage.senderId !== userId) {
              const targetRoom = matchedRooms.value.find(r => r.matchingId === room.matchingId);
              if (targetRoom) {
                // 마지막 메시지 정보만 업데이트
                targetRoom.lastMessage = receivedMessage.content;
                targetRoom.lastMessageTime = formatTime(new Date());
                
                // 서버에서 실제 읽지 않은 메시지 수 조회
                const unreadResponse = await axios.get(
                  `http://localhost:8080/api/chat/unread/${room.matchingId}/${userId}`,
                  {
                    headers: {
                      'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
                    }
                  }
                );
                targetRoom.unreadCount = unreadResponse.data;

                // 채팅방 순서 변경
                const index = matchedRooms.value.indexOf(targetRoom);
                if (index > 0) {
                  matchedRooms.value.splice(index, 1);
                  matchedRooms.value.unshift(targetRoom);
                }
              }
            }
          } catch (error) {
            console.error('Error processing message:', error);
          }
        }
      );

      subscriptions.value.set(room.matchingId, subscription);
    };

    // WebSocket 연결 함수
    const connectWebSocket = async () => {
      const maxRetries = 3;
      let retryCount = 0;

      const connect = async () => {
        try {
          if (stompClient.value?.connected) return;

          const socket = new SockJS('http://localhost:8080/tongChat');
          stompClient.value = Stomp.over(socket);
          
          await new Promise((resolve, reject) => {
            stompClient.value.connect(
              {},
              () => {
                console.log('WebSocket Connected');
                matchedRooms.value.forEach(room => subscribeToRoom(room));
                resolve();
              },
              (error) => {
                console.error('연결 실패:', error);
                reject(error);
              }
            );
          });
        } catch (error) {
          retryCount++;
          if (retryCount < maxRetries) {
            console.log(`재연결 시도 ${retryCount}/${maxRetries}`);
            await new Promise(resolve => setTimeout(resolve, 2000));
            return connect();
          }
          throw error;
        }
      };

      return connect();
    };

    // 채팅방 목록 조회 함수 수정
    const fetchMatchedRooms = async () => {
      try {
        userStore.loadTokenFromStorage();
        await userStore.fetchUserInfo();
        
        if (!userStore.token && !userStore.kakaoToken) {
          error.value = '로그인이 필요합니다.';
          router.push('/login');
          return;
        }

        const userId = userStore.getUserId;
        console.log('Fetching rooms for userId:', userId);

        if (!userId) {
          console.error('UserId is not available');
          error.value = '사용자 정보를 찾을 수 없습니다.';
          return;
        }

        const response = await axios.get(
          `http://localhost:8080/api/chat/rooms/${userId}`,
          {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          }
        );

        // 기존 구독 해제
        subscriptions.value.forEach(subscription => {
          subscription.unsubscribe();
        });
        subscriptions.value.clear();

        // 새로운 채팅방 목록 설정
        matchedRooms.value = response.data;
        
        // WebSocket 연결 및 새로운 구독 설정
        if (stompClient.value?.connected) {
          matchedRooms.value.forEach(room => {
            subscribeToRoom(room);
          });
        } else {
          await connectWebSocket();
        }

        // 읽지 않은 메시지 수 업데이트
        await updateUnreadCounts();
      } catch (error) {
        console.error('채팅방 목록 조회 실패:', error);
        error.value = '채팅방 목록을 불러오는데 실패했습니다.';
      }
    };

    // 시간 포맷팅 함수 추가
    const formatTime = (date) => {
      const hours = date.getHours().toString().padStart(2, '0');
      const minutes = date.getMinutes().toString().padStart(2, '0');
      return `${hours}:${minutes}`;
    };

    // enterRoom 함수 수정
    const enterRoom = async (room) => {
      console.log('Entering room:', room);
      try {
        // 서버에 읽음 처리 요청
        await axios.post(
          `http://localhost:8080/api/chat/read/${room.matchingId}/${userId}`,
          null,
          {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          }
        );
        
        // 읽지 않은 메시지 수 초기화
        room.unreadCount = 0;
        
        // 채팅방으로 이동
        router.push({
          name: 'chatRoom',
          params: { roomId: room.matchingId.toString() },
          query: { 
            partnerName: room.partnerName,
            matchingId: room.matchingId.toString()
          }
        });
      } catch (error) {
        console.error('Error marking messages as read:', error);
      }
    };

    // 컴포넌트 마운트 시
    onMounted(async () => {
      await fetchMatchedRooms();
      await connectWebSocket();
      
      // 백업용 주기적 업데이트 (5분)
      updateInterval.value = setInterval(updateUnreadCounts, 300000);
    });

    onUnmounted(() => {
      // 구독 해제
      subscriptions.value.forEach(subscription => {
        subscription.unsubscribe();
      });
      subscriptions.value.clear();

      // WebSocket 연결 해제
      if (stompClient.value?.connected) {
        stompClient.value.disconnect();
      }

      // 인터벌 정리
      if (updateInterval.value) {
        clearInterval(updateInterval.value);
      }
    });

    return {
      matchedRooms,
      error,
      defaultAvatar,
      enterRoom: (room) => {
        console.log('Entering room:', room);
        // 채팅방 입장 시 해당 방의 읽지 않은 메시지 수를 0으로 초기화
        room.unreadCount = 0;
        router.push({
          name: 'chatRoom',
          params: { 
            roomId: room.matchingId.toString() 
          },
          query: { 
            partnerName: room.partnerName,
            matchingId: room.matchingId.toString()
          }
        });
      }
    };
  }
}
</script>

<style scoped>
.chat-list {
  width: 100%;
  max-width: 800px;
  height: 80vh;
  overflow-y: auto;
  margin: 0 auto;
  padding: 0 10px;
  background-color: #ffffff;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.chat-list h1 {
  padding: 20px;
  margin: 0;
  color: #333;
  border-bottom: 1px solid #eee;
}

/* 스크롤바 스타일 */
.chat-list::-webkit-scrollbar {
  width: 8px;
}

.chat-list::-webkit-scrollbar-thumb {
  background-color: #E2495B;
  border-radius: 10px;
}

.chat-list::-webkit-scrollbar-thumb:hover {
  background-color: #FF6B81;
}

.chat-link {
  display: flex;
  align-items: center;
  padding: 15px;
  border-bottom: 1px solid #eee;
  cursor: pointer;
  transition: background-color 0.2s;
}

.chat-link:hover {
  background-color: #f9f9f9;
}

.avatar {
  width: 3vw;
  height: 3vw;
  max-width: 50px;
  max-height: 50px;
  border-radius: 50%;
  margin-right: 15px;
}

.chat-details {
  flex: 1;
  min-width: 0;
}

.chat-name {
  font-size: 1.1rem;
  font-weight: bold;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.chat-message {
  font-size: 0.9rem;
  color: #666;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.chat-meta {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  min-width: 70px;
  margin-left: 10px;
}

.chat-date {
  font-size: 0.8rem;
  color: #999;
  text-align: right;
  margin-bottom: 5px;
}

.unread-badge {
  background-color: #FF6B81;
  color: white;
  border-radius: 50%;
  min-width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2px 6px;
  font-size: 0.8rem;
  font-weight: bold;
  margin-top: 5px;
}

.error-message {
  color: #E2495B;
  text-align: center;
  padding: 20px;
  font-weight: bold;
}

.no-rooms {
  text-align: center;
  color: #999;
  padding: 40px 20px;
  font-size: 1.1rem;
}
</style>