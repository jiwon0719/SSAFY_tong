package com.ssafy.tong.reply.model;

public class Reply {
	private int replyId;
	private int commentId;
	private String replier;
	private String content;
	private String regDate;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getReplier() {
		return replier;
	}
	public void setReplier(String replier) {
		this.replier = replier;
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
		return "Reply [replyId=" + replyId + ", commentId=" + commentId + ", replier=" + replier + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
}
