package com.ssafy.tong.reply.model.dao;

import java.util.List;

import com.ssafy.tong.reply.model.Reply;

public interface ReplyDao {
	// 전체 조회
	List<Reply> selectReply();
	// 삭제
	void deleteReply(int replyId);
	// 등록
	void insertReply(Reply reply);

}
