package com.ssafy.tong.expert.model.dao;

import java.util.List;

import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertCareer;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.ExpertList;

public interface ExpertDao {
	// 전체 조회
	List<ExpertList> selectExpertList();
	// 상세 조회
	// 기본 정보 조회
	Expert selectExpertByPK(int expertId);
	// 커리어 정보 조회
	List<ExpertCareer> selectExpertCareerByPk(int expertId);
	// 이미지 정보 조회
	List<ExpertImage> selectExpertImageByPk(int expertId);
	// 삭제
	void deleteExpert(int expertId);
	// 등록
	void insertExport(Expert expert);
	// 파일 업로드
	void insertExportImage(ExpertImage expertImage);
	// 경력 업로드 
	void insertExportCareer(ExpertCareer expertCareer);
	// 수정
	void updateExpert(Expert expert);
	
	String selectUserIdByExpertId(int expertId);

}