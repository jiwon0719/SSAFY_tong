package com.ssafy.tong.reply.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.reply.model.Reply;
import com.ssafy.tong.reply.model.dao.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {
	private final ReplyDao replyDao;
	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	// 전체 조회
	@Override
	public List<Reply> list() {
		return replyDao.selectReply();
	}
	// 삭제 
	@Override
	public void remove(int replyId) {
		replyDao.deleteReply(replyId);
	}
	// 등록
	@Override
	public void regist(Reply reply) {
		replyDao.insertReply(reply);
	}

}
