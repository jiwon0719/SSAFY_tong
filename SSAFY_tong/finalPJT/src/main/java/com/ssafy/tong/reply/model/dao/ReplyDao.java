package com.ssafy.tong.reply.model.dao;

import java.util.List;

import com.ssafy.tong.comment.model.Comment;

public interface ReplyDao {
	// 전체 조회
	List<Comment> selectReply(int parentCommentId);
	// 삭제
	void deleteReply(int replyId);
	// 등록
	void insertReply(Comment reply);

}
