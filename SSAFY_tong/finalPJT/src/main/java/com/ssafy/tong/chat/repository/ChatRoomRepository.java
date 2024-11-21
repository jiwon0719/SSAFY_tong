package com.ssafy.tong.chat.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.ssafy.tong.chat.model.ChatRoom;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoom> chatRoomMap = new ConcurrentHashMap<>();

    public List<ChatRoom> findAllRooms() {
        List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(result);
        return result;
    }

    public ChatRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name) {
        ChatRoom room = ChatRoom.create(name);
        chatRoomMap.put(room.getRoomId(), room);
        return room;
    }
}