package com.ssafy.tong.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.service.BoardService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin(origins = "http://192.168.210.55:5173", allowCredentials = "true", allowedHeaders = "*")
// 게시판
public class BoardController {
	private final BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체 조회
	@GetMapping
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> responseEntity;
		try {
			List<Board> list = boardService.list();
			if(list.isEmpty()) {
				responseEntity = new ResponseEntity<>(list, HttpStatus.NO_CONTENT); 
			} else {
				responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("문제 발생", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	
	// 상세 조회
	@GetMapping("{board_id}")
	public ResponseEntity<Board> detail(@PathVariable("board_id") int boardId) {
		Board board = boardService.detail(boardId);
//		System.out.println(board);
		if(board == null) { // 요청한 게시글 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(board);
	}
	
	
	// 삭제
	@DeleteMapping("{board_id}")
	public void remove(@PathVariable("board_id") int boardId) {
		boardService.remove(boardId);
		
	}
	

	// 등록
	@PostMapping
	public void regist(@RequestBody Board board) {
//		System.out.println(board);
		boardService.regist(board);
	}
	
	
	// 수정
	@PutMapping("{board_id}")
	public void modify(@PathVariable("board_id") int boardId, @RequestBody Board board) {
		board.setBoardId(boardId);
		boardService.modify(board);
	}
	
    // 조회수 증가
	@PostMapping("/{boardId}/incrementView")
	public ResponseEntity<Void> incrementViewCount(@PathVariable int boardId) {
	    try {
	        boardService.incrementViewCount(boardId);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().build();
	    }
	}
	
    // 댓글 수 조회
	@GetMapping("/{boardId}/commentCount")
	public ResponseEntity<Integer> getCommentCount(@PathVariable int boardId) {
	    try {
	        int count = boardService.getCommentCount(boardId);
	        return ResponseEntity.ok(count);
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().build();
	    }
	}
	
}
