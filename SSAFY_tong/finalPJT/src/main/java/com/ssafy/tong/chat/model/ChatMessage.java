package com.ssafy.tong.chat.model;

import java.util.Date;

public class ChatMessage {
    private String type;    // 메시지 타입 (CHAT, JOIN 등)
    private String roomId;  // 채팅방 ID
    private String sender;  // 보낸 사람
    private String content; // 메시지 내용
    private Date timestamp; // 전송 시간

    // 기본 생성자
    public ChatMessage() {
    }

    // 모든 필드를 포함한 생성자
    public ChatMessage(String type, String roomId, String sender, String content, Date timestamp) {
        this.type = type;
        this.roomId = roomId;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getter 메서드들
    public String getType() {
        return type;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    // Setter 메서드들
    public void setType(String type) {
        this.type = type;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    // toString 메서드 오버라이드
    @Override
    public String toString() {
        return "ChatMessage{" +
                "type='" + type + '\'' +
                ", roomId='" + roomId + '\'' +
                ", sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}