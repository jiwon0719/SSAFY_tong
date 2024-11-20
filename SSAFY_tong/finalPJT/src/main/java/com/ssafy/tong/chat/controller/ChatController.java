package com.ssafy.tong.chat.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.ssafy.tong.chat.model.ChatMessage;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.Date;

@Controller
public class ChatController {
    
    private final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @MessageMapping("/chat.send/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public ChatMessage send(@Payload ChatMessage message, 
                          @DestinationVariable String roomId,
                          SimpMessageHeaderAccessor headerAccessor) {
        logger.debug("메시지 수신: room={}, sender={}, content={}, headers={}", 
                    roomId, message.getSender(), message.getContent(), 
                    headerAccessor.getMessageHeaders());
        message.setTimestamp(new Date());
        return message;
    }

    @MessageMapping("/chat.join/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public ChatMessage join(@Payload ChatMessage message, 
                          @DestinationVariable String roomId,
                          SimpMessageHeaderAccessor headerAccessor) {
        logger.debug("사용자 입장: room={}, user={}, headers={}", 
                    roomId, message.getSender(), 
                    headerAccessor.getMessageHeaders());
        message.setType("JOIN");
        message.setContent(message.getSender() + "님이 입장하셨습니다.");
        message.setTimestamp(new Date());
        return message;
    }
}