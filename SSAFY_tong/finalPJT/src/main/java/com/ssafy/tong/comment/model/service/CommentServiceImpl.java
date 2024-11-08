package com.ssafy.tong.comment.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.comment.model.Comment;
import com.ssafy.tong.comment.model.dao.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	private final CommentDao commentDao;
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	// 전체 조회
	@Override
	public List<Comment> list() {
		return commentDao.selectComment();
	}
	// 삭제
	@Override
	public void remove(int commentId) {
		commentDao.deleteComment(commentId);
	}
	// 등록
	@Override
	public void regist(Comment comment) {
		commentDao.insertComment(comment);
	}

}
