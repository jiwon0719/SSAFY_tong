package com.ssafy.tong.matching.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.expert.model.UserList;
import com.ssafy.tong.matching.model.Matching;

public interface MatchingDao {
	// 등록(신청) 
	void insertMatching(Matching matching);
	// 매칭 상태 확인
	boolean checkExistingMatching(String userId, String expertUserId);
	// 상세 조회
	List<ExpertList> selectMatchingsByUserId(String userId);
	List<UserList> selectMatchingsByExpertId(String expertId);
	// 점수 업데이트 
	int updateScore(int expertId, String userId, int score);
	// 매칭 수락 / 거절(상태 업데이트)
	void updateMatchingStatus(
			@Param("userId") String userId, 
			@Param("expertUserId")String expertUserId, 
			@Param("status")String status
	);
	// 매칭 ID 찾기 메서드 추가
	Long findMatchingId(
		@Param("userId") String userId, 
		@Param("expertUserId") String expertUserId
	);
	
	// 전문가 정보 조회
	Map<String, Object> selectExpertInfo(@Param("expertUserId") String expertUserId);

}
