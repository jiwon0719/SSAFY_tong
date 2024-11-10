package com.ssafy.tong.expert.model.dao;

import java.util.List;

import com.ssafy.tong.expert.model.Expert;

public interface ExpertDao {
	// 전체 조회
	List<Expert> selectExpert();
	// 상세 조회
	Expert selectExpertByPK(int expertId);
	// 삭제
	void deleteExpert(int expertId);
	// 삽입
	void insertExport(Expert expert);
	// 수정
	void updateExpert(Expert expert);

}
