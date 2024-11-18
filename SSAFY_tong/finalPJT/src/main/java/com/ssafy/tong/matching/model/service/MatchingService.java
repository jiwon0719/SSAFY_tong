package com.ssafy.tong.matching.model.service;

import java.util.List;

import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.matching.model.Matching;

public interface MatchingService {
	// 등록(신청) 
	void regist(Matching matching);
	// 매칭 상태 확인
	boolean checkExistingMatching(String userId, String expertUserId);
	// 상세 조회
	List<ExpertList> getUserMatchingList(String userId);
	// 점수 업데이트 
	void updateScore(int expertId, String userId, int score);

}
