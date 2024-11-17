package com.ssafy.tong.matching.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.matching.model.Matching;
import com.ssafy.tong.matching.model.service.MatchingService;

@RestController
@RequestMapping("/api/matching")
@CrossOrigin
public class MatchingController {
    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    // 매칭 신청
    @PostMapping
    public ResponseEntity<?> regist(@RequestBody Matching matching) {
        try {
            matchingService.regist(matching);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("매칭 신청 중 오류가 발생했습니다: " + e.getMessage());
        }
    }   

    // 매칭 상태 확인
    // 신청 전에 사용자와 전문가 간의 매칭 상태 확인을 위함
    @GetMapping("/check/{userId}/{expertUserId}")
    public ResponseEntity<Boolean> checkExistingMatching(@PathVariable String userId, @PathVariable String expertUserId) {
        try {
            boolean exists = matchingService.checkExistingMatching(userId, expertUserId);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    
    
    // 유저별 매칭 현황 조회 (ExpertList 정보 포함)
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserMatchings(@PathVariable String userId) {
        try {
            List<ExpertList> list = matchingService.getUserMatchingList(userId);
            if (list == null || list.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("매칭 목록 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    // 점수 업데이트
    @PutMapping("/{expertId}/score")
    public ResponseEntity<?> updateScore(
        @PathVariable int expertId, 
        @RequestParam String userId, 
        @RequestParam int score
    ) {
        try {
            System.out.println("ExpertId: " + expertId + ", UserId: " + userId + ", Score: " + score);  // 로그 추가
            matchingService.updateScore(expertId, userId, score);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();  // 상세 에러 로그 출력
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("점수 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    
    
}