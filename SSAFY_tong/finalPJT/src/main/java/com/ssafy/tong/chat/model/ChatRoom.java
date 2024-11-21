package com.ssafy.tong.chat.model;


public class ChatRoom {
    private Long matchingId;
    private String userId;
    private String expertUserId;
    private String partnerName;
    private String lastMessage;
    private String lastMessageTime;

    public Long getMatchingId() {
        return matchingId;
    }

    public void setMatchingId(Long matchingId) {
        this.matchingId = matchingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpertUserId() {
        return expertUserId;
    }

    public void setExpertUserId(String expertUserId) {
        this.expertUserId = expertUserId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }
}