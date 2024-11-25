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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.board.model.Board;
import com.ssafy.tong.board.model.BoardCategory;
import com.ssafy.tong.board.model.CategoryViewResponse;
import com.ssafy.tong.board.model.service.BoardCategoryService;

@RestController
@RequestMapping("/api/boardCategory")
@CrossOrigin(origins = "http://192.168.210.55:5173", allowCredentials = "true", allowedHeaders = "*")
// 게시판 카테고리
public class BoardCategoryController {
	private final BoardCategoryService boardCategoryService;
	public BoardCategoryController(BoardCategoryService boardCategoryService) {
		this.boardCategoryService = boardCategoryService;
	}
	
	// 전체 조회
	@GetMapping
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> responseEntity;
		try {
			List<BoardCategory> list = boardCategoryService.list();
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
	
	
	// 상세 조회 : 카테고리별 게시글 조회
	@GetMapping("{category_id}")
	public ResponseEntity<Object> detail(@PathVariable("category_id") int categoryId) {
		List<Board> list = boardCategoryService.detail(categoryId);
		if(list == null) { // 요청한 게시글 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	
	// 삭제
	@DeleteMapping("{category_id}")
	public void remove(@PathVariable("category_id") int categoryId) {
		boardCategoryService.remove(categoryId);
		
	}
	

	// 등록
	@PostMapping
	public void regist(@RequestBody BoardCategory boardCategory) {
		boardCategoryService.regist(boardCategory);
	}
	
	
	// 수정
	@PutMapping("{category_id}")
	public void modify(@PathVariable("category_id") int categoryId, @RequestBody BoardCategory boardCategory) {
		boardCategory.setCategoryId(categoryId);
		boardCategoryService.modify(boardCategory);
	}
	
	// 핫 게시판 선정(TOP3)
	@GetMapping("/top-viewed")
	public ResponseEntity<List<CategoryViewResponse>> getTopViewedCategories() {
		return ResponseEntity.ok(boardCategoryService.findTopViewedCategories());
	}
	
	// 카테고리 찜 등록
	@PostMapping("/hold/{categoryId}")
	public ResponseEntity<String> toggleHold(@PathVariable Integer categoryId, @RequestParam String userId) {
        System.out.println(categoryId);
        System.out.println(userId);
		try {
            if (categoryId == null || userId == null || userId.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("잘못된 요청입니다.");
            }
        	boardCategoryService.toggleHold(categoryId, userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("찜하기 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

	// 카테고리 찜 조회
	@GetMapping("/hold")
	public ResponseEntity<List<BoardCategory>> getHoldsByUser(@RequestParam String userId) {
	    return ResponseEntity.ok(boardCategoryService.getHoldsByUser(userId));
	}
	
}
