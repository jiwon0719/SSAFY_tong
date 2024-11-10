package com.ssafy.tong.expert.controller;

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

import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.service.ExpertService;

@RestController
@RequestMapping("/api/expert")
@CrossOrigin
// 전문가
// 본인 PR 자기소개 페이지
public class expertController {
	private final ExpertService expertService;
	public expertController(ExpertService expertService) {
		this.expertService = expertService;
	}
	
	// 전체 조회
	@GetMapping
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> responseEntity;
		try {
			List<Expert> list = expertService.list();
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
	@GetMapping("{expert_id}")
	public ResponseEntity<Expert> detail(@PathVariable("expert_id") int expertId) {
		Expert expert = expertService.detail(expertId);
		if(expert == null) { // 요청한 게시글 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(expert);
	}
	
	
	// 삭제
	@DeleteMapping("{expert_id}")
	public void remove(@PathVariable("expert_id") int expertId) {
		expertService.remove(expertId);
		
	}
	

	// 등록
	@PostMapping
	public void regist(@RequestBody Expert expert) {
		expertService.regist(expert);
	}
	
	
	// 수정
	@PutMapping("{expert_id}")
	public void modify(@PathVariable("expert_id") int expertId, @RequestBody Expert expert) {
		expert.setExpertId(expertId);
		expertService.modify(expert);
	}
}
