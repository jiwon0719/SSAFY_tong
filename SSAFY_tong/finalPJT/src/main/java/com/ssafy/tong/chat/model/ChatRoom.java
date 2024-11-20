package com.ssafy.tong.chat.model;

import java.util.UUID;

public class ChatRoom {
    private String roomId;
    private String name;

    // Getters
    public String getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 정적 팩토리 메서드
    public static ChatRoom create(String name) {
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }

    // 기본 생성자
    public ChatRoom() {
    }

    // toString 메서드 추가
    @Override
    public String toString() {
        return "ChatRoom{" +
                "roomId='" + roomId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}