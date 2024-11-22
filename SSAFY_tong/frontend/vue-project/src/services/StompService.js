import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

class StompService {
  constructor() {
    this.client = null;
    this.connected = false;
  }

  connect(roomId, username, onMessageReceived) {
    return new Promise((resolve, reject) => {
      try {
        // 기존 연결이 있다면 끊기
        if (this.client) {
          this.disconnect();
        }

        // SockJS 연결 생성
        const socket = new SockJS(`${import.meta.env.VITE_API_BASE_URL}/tongChat`);
        
        // STOMP 클라이언트 설정
        this.client = new Client({
          webSocketFactory: () => socket,
          debug: (str) => console.log('STOMP Debug:', str),
          reconnectDelay: 5000,
          heartbeatIncoming: 4000,
          heartbeatOutgoing: 4000,
        });

        // 연결 성공 핸들러
        this.client.onConnect = (frame) => {
          console.log('STOMP Connected:', frame);
          this.connected = true;

          // 채팅방 구독
          this.client.subscribe(`/topic/chat/${roomId}`, (message) => {
            const receivedMessage = JSON.parse(message.body);
            onMessageReceived(receivedMessage);
          });

          // 입장 메시지 전송
          this.sendJoinMessage(roomId, username);
          resolve();
        };

        // 에러 핸들러
        this.client.onStompError = (error) => {
          console.error('STOMP Error:', error);
          this.connected = false;
          reject(error);
        };

        // 연결 끊김 핸들러
        this.client.onWebSocketClose = () => {
          console.log('WebSocket Connection Closed');
          this.connected = false;
        };

        // 활성화
        this.client.activate();

      } catch (error) {
        console.error('Connection Error:', error);
        reject(error);
      }
    });
  }

  sendMessage(roomId, username, content) {
    if (!this.client || !this.connected) {
      throw new Error('WebSocket is not connected');
    }

    this.client.publish({
      destination: `/app/chat.send/${roomId}`,
      body: JSON.stringify({
        type: 'CHAT',
        roomId: roomId,
        sender: username,
        content: content,
        timestamp: new Date()
      })
    });
  }

  sendJoinMessage(roomId, username) {
    if (!this.client || !this.connected) {
      throw new Error('WebSocket is not connected');
    }

    this.client.publish({
      destination: `/app/chat.join/${roomId}`,
      body: JSON.stringify({
        type: 'JOIN',
        roomId: roomId,
        sender: username,
        content: `${username}님이 입장하셨습니다.`,
        timestamp: new Date()
      })
    });
  }

  disconnect() {
    if (this.client) {
      this.client.deactivate();
      this.connected = false;
    }
  }
}

export default new StompService();