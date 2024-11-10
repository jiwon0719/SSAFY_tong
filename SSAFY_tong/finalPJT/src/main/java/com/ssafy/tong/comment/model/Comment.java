package com.ssafy.tong.comment.model;

public class Comment {
	private int commentId;
	private int boardId;
	private String commenter;
	private String content;
	private String regDate;
	private int parentCommentId;
	
	public int getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", boardId=" + boardId + ", commenter=" + commenter + ", content="
				+ content + ", regDate=" + regDate + ", parentCommentId=" + parentCommentId + "]";
	}
}
