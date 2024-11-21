package com.ssafy.tong.chat.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.chat.model.ChatMessage;
import com.ssafy.tong.chat.model.ChatRoom;
import com.ssafy.tong.chat.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*")
public class ChatController {
    
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
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
    public ResponseEntity<List<ChatMessage>> getChatHistory(@PathVariable Long matchingId) {
        List<ChatMessage> history = chatService.getChatHistory(matchingId);
        return ResponseEntity.ok(history);
    }

    @MessageMapping("/chat/{matchingId}")
    @SendTo("/topic/chat/{matchingId}")
    public ChatMessage handleChat(@DestinationVariable Long matchingId, ChatMessage message) {
        chatService.saveMessage(message);
        return message;
    }
}