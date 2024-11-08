package com.ssafy.tong.reply.model.service;

import java.util.List;

import com.ssafy.tong.reply.model.Reply;

public interface ReplyService {
	// 전체 조회
	List<Reply> list();
	// 삭제
	void remove(int replyId);
	// 등록
	void regist(Reply reply);
	
}
