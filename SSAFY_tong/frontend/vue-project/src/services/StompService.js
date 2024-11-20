import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

class StompService {
  constructor() {
      this.client = null;
      this.subscription = null;
  }

  connect(roomId, username, onMessageReceived) {
      const serverUrl = 'http://localhost:8080/ws';
      const socket = new SockJS(serverUrl);
      
      this.client = new Client({
          webSocketFactory: () => socket,
          connectHeaders: {},
          debug: function (str) {
              console.log(str);
          },
          reconnectDelay: 5000,
          heartbeatIncoming: 4000,
          heartbeatOutgoing: 4000,
      });

      this.client.onConnect = (frame) => {
          console.log('Connected: ' + frame);
          
          // Subscribe to the room
          this.subscription = this.client.subscribe(`/topic/room.${roomId}`, (message) => {
              const receivedMessage = JSON.parse(message.body);
              onMessageReceived(receivedMessage);
          });

          // Send join message
          this.sendMessage(roomId, username, '', 'JOIN');
      };

      this.client.onStompError = (frame) => {
          console.error('Stomp error:', frame);
      };

      this.client.onWebSocketClose = () => {
          console.log('WebSocket Connection Closed');
          this.reconnect(roomId, username, onMessageReceived);
      };

      try {
          this.client.activate();
      } catch (error) {
          console.error('Connection error:', error);
          setTimeout(() => {
              this.connect(roomId, username, onMessageReceived);
          }, 5000);
      }
  }

  reconnect(roomId, username, onMessageReceived) {
      setTimeout(() => {
          this.connect(roomId, username, onMessageReceived);
      }, 5000);
  }

  disconnect() {
      if (this.subscription) {
          this.subscription.unsubscribe();
      }
      if (this.client) {
          this.client.deactivate();
      }
  }

  sendMessage(roomId, sender, content, type = 'CHAT') {
      if (this.client && this.client.connected) {
          const message = {
              roomId: roomId,
              sender: sender,
              content: content,
              type: type
          };
          
          this.client.publish({
              destination: '/app/chat.sendMessage',
              body: JSON.stringify(message)
          });
      } else {
          console.warn('WebSocket connection not established. Message not sent.');
      }
  }
}

export default new StompService();