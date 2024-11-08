package com.ssafy.tong.comment.model.service;

import java.util.List;

import com.ssafy.tong.comment.model.Comment;

public interface CommentService {
	// 전체 조회
	List<Comment> list();
	// 삭제
	void remove(int commentId);
	// 등록
	void regist(Comment comment);

}
