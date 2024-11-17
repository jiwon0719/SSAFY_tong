package com.ssafy.tong.expert.model.service;

import java.util.List;


import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertCareer;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.ExpertList;

public interface ExpertService {
	// 전체 조회
	List<ExpertList> list();
	// 상세 조회
	// 기본 정보 조회
	Expert detail(int expertId);
	// 커리어 정보 조회
	List<ExpertCareer> getExpertCareers(int expertId);
	// 이미지 정보 조회
	List<ExpertImage> getExpertImages(int expertId);
	// 삭제
	void remove(int expertId);
	// 등록
	// 파일 업로드
	// 경력 업로드
	void regist(Expert expert);
	// 수정
	void modify(Expert expert);

}
