package com.ssafy.tong.expert.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.service.ExpertService;

@RestController
@RequestMapping("/api/expert")
@CrossOrigin
// 전문가
// 본인 PR 자기소개 페이지
public class ExpertController {
	private final ExpertService expertService;
	public ExpertController(ExpertService expertService) {
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
	// 파일 업로드
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public void regist(@RequestPart("expert") Expert expert, @RequestPart("file") MultipartFile file) throws Exception {
		String oriName = file.getOriginalFilename(); // 파일 실제 이름
		if(oriName.length() > 0) {
			String extension = oriName.substring(oriName.lastIndexOf(".") + 1); 
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date()); // 수정
			File dir = new File("c:/SSAFY/SSAFY_tong/uploads" + subDir);
			dir.mkdirs();
			String systemName = UUID.randomUUID().toString() + oriName; 
			file.transferTo(new File(dir, systemName));

			ExpertImage expertImage = new ExpertImage();
			expertImage.setFilePath(subDir);
			expertImage.setOriName(oriName);
			expertImage.setSystemName(systemName);
			expertImage.setExtension(extension);
			expert.setExpertImage(expertImage);
			
		}
		expertService.regist(expert);
	}
	
	
	// 수정
	@PutMapping("{expert_id}")
	public void modify(@PathVariable("expert_id") int expertId, @RequestBody Expert expert) {
		expert.setExpertId(expertId);
		expertService.modify(expert);
	}
}
