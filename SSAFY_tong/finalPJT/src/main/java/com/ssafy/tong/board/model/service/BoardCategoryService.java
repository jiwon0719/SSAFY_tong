package com.ssafy.tong.board.model.service;

import java.util.List;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;

public interface BoardCategoryService {
	// 전체 조회
	List<BoardCategory> list();
	// 상세 조회
	Board detail(int categoryId);
	// 삭제
	void remove(int categoryId);
	// 등록
	void regist(BoardCategory boardCategory);
	// 수정
	void modify(BoardCategory boardCategory);


}
