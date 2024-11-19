package com.ssafy.tong.board.model;

public class CategoryViewResponse {
    private int categoryId;
    private String category;
    private String description;
    private int totalViews;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public int getTotalViews() {
		return totalViews;
	}
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}
	@Override
	public String toString() {
		return "CategoryViewResponse [categoryId=" + categoryId + ", category=" + category + ", description="
				+ description + ", totalViews=" + totalViews + "]";
	}
}
