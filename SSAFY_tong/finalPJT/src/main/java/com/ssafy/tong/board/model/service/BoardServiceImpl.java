package com.ssafy.tong.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	// 전체 조회
	@Override
	public List<Board> list() {
		return boardDao.selectBoard();
	}
	// 상세 조회
	@Override
	public Board detail(int boardId) {
		return boardDao.selectBoardByPK(boardId);
	}
	// 삭제
	@Override
	public void remove(int boardId) {
		boardDao.deleteBoard(boardId);
	}
	// 등록
	@Override
	public void regist(Board board) {
		boardDao.insertBoard(board);
	}
	// 수정
	@Override
	public void modify(Board board) {
		boardDao.updateBoard(board);
	}

}
