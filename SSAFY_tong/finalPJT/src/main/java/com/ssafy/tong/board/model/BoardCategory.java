package com.ssafy.tong.board.model;

public class BoardCategory {
	private int categoryId;
	private String userId;
	private String category;
	private String description;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BoardCategory [categoryId=" + categoryId + ", userId=" + userId + ", category=" + category
				+ ", description=" + description + "]";
	}
}
