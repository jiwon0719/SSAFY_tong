package com.ssafy.tong.board.model.dao;

import java.util.List;

import com.ssafy.tong.board.model.Board;

public interface BoardDao {
	// 전체 조회
	List<Board> selectBoard();
	// 상세 조회
	Board selectBoardByPK(int boardId);
	// 삭제
	void deleteBoard(int boardId);
	// 등록
	void insertBoard(Board board);
	// 수정
	void updateBoard(Board board);
	// 조회수 증가
	void updateViewCount(int boardId);
	// 댓글수 조회
	int selectCommentCount(int boardId);

}
