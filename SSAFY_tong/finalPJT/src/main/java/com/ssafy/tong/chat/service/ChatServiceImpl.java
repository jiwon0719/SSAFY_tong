package com.ssafy.tong.chat.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ssafy.tong.chat.dao.ChatDao;
import com.ssafy.tong.chat.model.ChatMessage;
import com.ssafy.tong.chat.model.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService {

	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
    private final ChatDao chatDao;

    public ChatServiceImpl(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Override
    public List<ChatRoom> getChatRoomsByUserId(String userId) {
        try {
            logger.info("Fetching chat rooms for user: {}", userId);
            return chatDao.findChatRoomsByUserId(userId);
        } catch (Exception e) {
            logger.error("Error in getChatRoomsByUserId: ", e);
            throw e;
        }
    }

    @Override
    public List<ChatMessage> getChatHistory(Long matchingId) {
        return chatDao.findChatHistoryByMatchingId(matchingId);
    }

    @Override
    public void saveMessage(ChatMessage message) {
        chatDao.saveMessage(message);
    }

    @Override
    public void updateMessageReadStatus(Long chatId) {
        try {
            logger.info("Updating message read status for chat ID: {}", chatId);
            chatDao.updateMessageReadStatus(chatId);
        } catch (Exception e) {
            logger.error("Error in updateMessageReadStatus: ", e);
            throw e;
        }
    }

    @Override
    public void updateAllMessagesAsRead(Long matchingId) {
        try {
            logger.info("Updating all messages as read for matching ID: {}", matchingId);
            chatDao.updateAllMessagesAsRead(matchingId);
        } catch (Exception e) {
            logger.error("Error in updateAllMessagesAsRead: ", e);
            throw e;
        }
    }

    @Override
    public int getUnreadMessageCount(Long matchingId, String userId) {
        try {
            logger.info("Getting unread message count for matching ID: {} and user ID: {}", matchingId, userId);
            return chatDao.getUnreadMessageCount(matchingId, userId);
        } catch (Exception e) {
            logger.error("Error in getUnreadMessageCount: ", e);
            throw e;
        }
    }
}