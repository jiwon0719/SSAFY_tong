package com.ssafy.tong.board.model.service;

import java.util.List;

import com.ssafy.tong.board.model.Board;

public interface BoardService {
	// 전체 조회
	List<Board> list();
	// 상세 조회
	Board detail(int boardId);
	// 삭제
	void remove(int boardId);
	// 등록
	void regist(Board board);
	// 수정
	void modify(Board board);
	// 조회수 증가
	void incrementViewCount(int boardId);
	// 댓글수 조회
	int getCommentCount(int boardId);
}
