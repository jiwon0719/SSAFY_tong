package com.ssafy.tong.chat.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.ssafy.tong.chat.model.ChatMessage;
import com.ssafy.tong.chat.model.ChatRoom;
import com.ssafy.tong.chat.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*")
public class ChatController {
    
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(ChatService chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/rooms/{userId}")
    public ResponseEntity<?> getChatRooms(@PathVariable String userId) {
        try {
            logger.info("Fetching chat rooms for user: {}", userId);
            List<ChatRoom> rooms = chatService.getChatRoomsByUserId(userId);
            return ResponseEntity.ok(rooms);
        } catch (Exception e) {
            logger.error("Error fetching chat rooms for user: " + userId, e);
            return ResponseEntity.internalServerError().body("채팅방 목록을 가져오는데 실패했습니다: " + e.getMessage());
        }
    }

    @GetMapping("/history/{matchingId}")
    public ResponseEntity<?> getChatHistory(@PathVariable Long matchingId) {
        try {
            logger.info("Fetching chat history for matching ID: {}", matchingId);
            List<ChatMessage> history = chatService.getChatHistory(matchingId);
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            logger.error("Error fetching chat history: ", e);
            return ResponseEntity.internalServerError().body("채팅 내역을 가져오는데 실패했습니다: " + e.getMessage());
        }
    }

    @PutMapping("/read/{chatId}")
    public ResponseEntity<?> updateMessageReadStatus(@PathVariable Long chatId) {
        try {
            logger.info("Updating read status for chat ID: {}", chatId);
            chatService.updateMessageReadStatus(chatId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error updating message read status: ", e);
            return ResponseEntity.internalServerError().body("메시지 읽음 상태 업데이트 실패: " + e.getMessage());
        }
    }

    @PutMapping("/read-all/{matchingId}")
    public ResponseEntity<?> updateAllMessagesAsRead(@PathVariable Long matchingId) {
        try {
            logger.info("Updating all messages as read for matching ID: {}", matchingId);
            chatService.updateAllMessagesAsRead(matchingId);
            
            // 읽음 상태 변경을 WebSocket을 통해 알림
            ChatMessage readMessage = new ChatMessage();
            readMessage.setMatchingId(matchingId);
            readMessage.setType("READ");
            messagingTemplate.convertAndSend("/topic/chat/" + matchingId, readMessage);
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error updating all messages as read: ", e);
            return ResponseEntity.internalServerError().body("메시지 읽음 처리 실패: " + e.getMessage());
        }
    }

    @MessageMapping("/chat/{matchingId}")
    public void handleChat(@DestinationVariable Long matchingId, ChatMessage message) {
        try {
            logger.info("Handling chat message for matching ID {}: {}", matchingId, message);
            
            if ("CHAT".equals(message.getType())) {
                // 일반 채팅 메시지 처리
                message.setSentAt(LocalDateTime.now());
                message.setIsRead("X");
                chatService.saveMessage(message);
            }
            
            // WebSocket을 통해 구독자들에게 메시지 전송
            messagingTemplate.convertAndSend("/topic/chat/" + matchingId, message);
            
            logger.info("Message successfully processed and sent");
        } catch (Exception e) {
            logger.error("Error processing chat message: ", e);
            throw e;
        }
    }

    @GetMapping("/unread/{matchingId}/{userId}")
    public ResponseEntity<Integer> getUnreadMessageCount(
        @PathVariable Long matchingId,
        @PathVariable String userId
    ) {
        try {
            int count = chatService.getUnreadMessageCount(matchingId, userId);
            System.out.println("Unread count for matching " + matchingId + ": " + count);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            logger.error("Error getting unread message count: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/message")
    public ResponseEntity<?> saveMessage(@RequestBody ChatMessage message) {
        try {
            chatService.saveMessage(message);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error saving message: ", e);
            return ResponseEntity.internalServerError().body("메시지 저장 실패: " + e.getMessage());
        }
    }

    @MessageMapping("/chat/{matchingId}/typing")
    public void handleTyping(@DestinationVariable Long matchingId, ChatMessage message) {
        message.setType("TYPING");
        messagingTemplate.convertAndSend("/topic/chat/" + matchingId, message);
    }
}