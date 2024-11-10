package com.ssafy.tong.reply.model.service;

import java.util.List;

import com.ssafy.tong.comment.model.Comment;

public interface ReplyService {
	// 전체 조회
	List<Comment> list(int parentCommentId);
	// 삭제
	void remove(int replyId);
	// 등록
	void regist(Comment reply);
	
}
