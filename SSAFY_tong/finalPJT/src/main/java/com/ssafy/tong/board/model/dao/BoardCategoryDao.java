package com.ssafy.tong.board.model.dao;

import java.util.List;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;

public interface BoardCategoryDao {
	// 전체 조회
	List<BoardCategory> selectBoardCategory();
	// 상세 조회
	List<Board> selectBoardCategoryByPk(int categoryId);
	// 삭제
	void deleteBoardCategory(int categoryId);
	// 삽입
	void insertBoardCategory(BoardCategory boardCategory);
	// 수정
	void updateBoardCategory(BoardCategory boardCategory);
}
