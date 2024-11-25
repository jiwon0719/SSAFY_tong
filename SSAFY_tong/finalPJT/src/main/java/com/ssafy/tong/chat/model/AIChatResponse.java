package com.ssafy.tong.chat.model;

public class AIChatResponse {
    private String response;

    public AIChatResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

	@Override
	public String toString() {
		return "response";
	}
    
    
}