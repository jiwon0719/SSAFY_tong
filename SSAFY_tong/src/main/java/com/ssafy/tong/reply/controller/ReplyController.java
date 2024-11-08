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

import com.ssafy.tong.reply.model.Reply;
import com.ssafy.tong.reply.model.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
@CrossOrigin
public class ReplyController {
	private final ReplyService replyService;
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	// 전체 조회
	@GetMapping
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> responseEntity;
		try {
			List<Reply> list = replyService.list();
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
	
	
	// 삭제
	@DeleteMapping("{reply_id}")
	public void remove(@PathVariable("reply_id") int replyId) {
		replyService.remove(replyId);
	}

	
	// 등록
	@PostMapping
	public void regist(@RequestBody Reply reply) {
		replyService.regist(reply);
	}	
}
