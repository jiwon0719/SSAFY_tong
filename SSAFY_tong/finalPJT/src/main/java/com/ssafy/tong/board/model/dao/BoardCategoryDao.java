package com.ssafy.tong.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;
import com.ssafy.tong.board.model.CategoryViewResponse;

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
	// 핫게
	List<CategoryViewResponse> selectTopViewedCategories();
	// 카테고리 찜 등록
	Map<String, Object> findHoldByCategoryAndUser(Integer categoryId, String userId);
	void insertHold(Integer categoryId, String userId, String string);
	void updateHold(Integer categoryId, String userId, String newStatus);
	// 카테고리 찜 조회
	List<BoardCategory> findHoldsByUser(String userId);
}
