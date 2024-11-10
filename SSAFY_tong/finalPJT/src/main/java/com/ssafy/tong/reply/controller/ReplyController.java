package com.ssafy.tong.reply.controller;

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
import com.ssafy.tong.reply.model.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
@CrossOrigin
public class ReplyController {
	private final ReplyService replyService;
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	// (대댓글) 전체 조회
	@GetMapping("{parent_comment_id}")
	public ResponseEntity<Object> list(@PathVariable("parent_comment_id") int parentCommentId) {
		ResponseEntity<Object> responseEntity;
		try {
			List<Comment> list = replyService.list(parentCommentId);
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
	
	
	// (대댓글) 삭제
	@DeleteMapping("{reply_id}")
	public void remove(@PathVariable("reply_id") int replyId) {
		replyService.remove(replyId);
	}

	
	// (대댓글) 등록
	@PostMapping("{parent_comment_id}")
	public void regist(@RequestBody Comment reply, @PathVariable("parent_comment_id") int parentCommentId) {
		reply.setParentCommentId(parentCommentId); 
		replyService.regist(reply);
	}	
}
