package com.ssafy.tong.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;
import com.ssafy.tong.board.model.CategoryViewResponse;
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
	// 핫게
	@Override
	public List<CategoryViewResponse> findTopViewedCategories() {
		return boardCategoryDao.selectTopViewedCategories();
	}
	// 카테고리 찜 등록
	@Override
	public void toggleHold(Integer categoryId, String userId) {
	    System.out.println("Service - categoryId: " + categoryId + ", userId: " + userId);
	    
	    try {
	        // 1. 현재 찜 상태 조회
	        Map<String, Object> check = boardCategoryDao.findHoldByCategoryAndUser(categoryId, userId);
	        System.out.println("현재 찜 상태: " + check);
	        
	        if (check == null) {
	            // 2. 찜이 없으면 새로 등록
	            System.out.println("새로운 찜 등록");
	            boardCategoryDao.insertHold(categoryId, userId, "O");
	        } else {
	            // 3. 있으면 상태 토글
	            String currentStatus = (String) check.get("is_hold");
	            String newStatus = "O".equals(currentStatus) ? "X" : "O";
	            System.out.println("찜 상태 변경: " + currentStatus + " -> " + newStatus);
	            boardCategoryDao.updateHold(categoryId, userId, newStatus);
	        }
	    } catch (Exception e) {
	        System.out.println("서비스 에러 발생: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
	    }
	}
	// 카테고리 찜 조회
	@Override
	public List<BoardCategory> getHoldsByUser(String userId) {
	   return boardCategoryDao.findHoldsByUser(userId);
	}

}
