package com.ssafy.tong.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.comment.model.Comment;
import com.ssafy.tong.comment.model.service.CommentService;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
// 댓글
public class CommentController {
	private final CommentService commentService;
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	// (댓글) 전체 조회
	// 게시글별 댓글 조회 필요
	@GetMapping("{board_id}")
	public ResponseEntity<Object> list(@PathVariable("board_id") int boardId) {
		ResponseEntity<Object> responseEntity;
		try {
			List<Comment> list = commentService.list(boardId);
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
	
	
	// (댓글) 삭제
	@DeleteMapping("{comment_id}")
	public void remove(@PathVariable("comment_id") int commentId) {
		commentService.remove(commentId);
	}

	
	// (댓글) 등록
	@PostMapping
	public void regist(@RequestBody Comment comment) {
		System.out.println(comment);
		commentService.regist(comment);
	}	
	
	
}
