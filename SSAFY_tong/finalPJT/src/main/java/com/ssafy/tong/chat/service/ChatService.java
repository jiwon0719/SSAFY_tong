package com.ssafy.tong.chat.service;

import java.util.List;

import com.ssafy.tong.chat.model.ChatMessage;
import com.ssafy.tong.chat.model.ChatRoom;

public interface ChatService {
    List<ChatRoom> getChatRoomsByUserId(String userId);
    List<ChatMessage> getChatHistory(Long matchingId);
    void saveMessage(ChatMessage message);
    void updateMessageReadStatus(Long chatId);
    void updateAllMessagesAsRead(Long matchingId);
    int getUnreadMessageCount(Long matchingId, String userId);
}