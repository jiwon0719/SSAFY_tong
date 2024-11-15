package com.ssafy.tong.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;
import com.ssafy.tong.board.model.dao.BoardCategoryDao;
@Service
public class BoardCategoryServiceImpl implements BoardCategoryService {
	private final BoardCategoryDao boardCategoryDao;
	public BoardCategoryServiceImpl(BoardCategoryDao boardCategoryDao) {
		this.boardCategoryDao = boardCategoryDao;
	}
	
	// 전체 조회
	@Override
	public List<BoardCategory> list() {
		return boardCategoryDao.selectBoardCategory();
	}
	// 상세 조회
	@Override
	public List<Board> detail(int categoryId) {
		return boardCategoryDao.selectBoardCategoryByPk(categoryId);
	}
	// 삭제
	@Override
	public void remove(int categoryId) {
		boardCategoryDao.deleteBoardCategory(categoryId);
	}
	// 등록
	@Override
	public void regist(BoardCategory boardCategory) {
		boardCategoryDao.insertBoardCategory(boardCategory);
	}
	// 수정
	@Override
	public void modify(BoardCategory boardCategory) {
		boardCategoryDao.updateBoardCategory(boardCategory);
	}

}
