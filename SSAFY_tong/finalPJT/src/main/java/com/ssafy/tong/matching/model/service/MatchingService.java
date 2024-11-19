package com.ssafy.tong.matching.model.service;

import java.util.List;

import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.expert.model.UserList;
import com.ssafy.tong.matching.model.Matching;

public interface MatchingService {
	// 등록(신청) 
	void regist(Matching matching);
	// 매칭 상태 확인
	boolean checkExistingMatching(String userId, String expertUserId);
    // 유저별 매칭 현황 조회 (ExpertList 정보 포함)
	List<ExpertList> getUserMatchingList(String userId);
	// 전문가별 유저 매칭 현황 조회(UserList 정보 포함)
	List<UserList> getExpertMatchingList(String expertId);
	// 점수 업데이트 
	void updateScore(int expertId, String userId, int score);

}
