package com.ssafy.tong.chat.dao;

import java.util.List;

import com.ssafy.tong.chat.model.ChatMessage;
import com.ssafy.tong.chat.model.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

public interface ChatDao {
    List<ChatRoom> findChatRoomsByUserId(String userId);
    List<ChatMessage> findChatHistoryByMatchingId(Long matchingId);
    void saveMessage(ChatMessage message);
    void updateMessageReadStatus(Long chatId);
    void updateAllMessagesAsRead(Long matchingId);
    int getUnreadMessageCount(Long matchingId, String userId);
}