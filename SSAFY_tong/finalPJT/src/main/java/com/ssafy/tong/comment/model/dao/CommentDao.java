package com.ssafy.tong.comment.model.dao;

import java.util.List;

import com.ssafy.tong.comment.model.Comment;

public interface CommentDao {

	List<Comment> selectComment(int boardId);

	void deleteComment(int commentId);

	void insertComment(Comment comment);

}
