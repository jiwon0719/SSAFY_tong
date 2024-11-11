package com.ssafy.tong.expert.model.service;

import java.util.List;


import com.ssafy.tong.expert.model.Expert;

public interface ExpertService {
	// 전체 조회
	List<Expert> list();
	// 상세 조회
	Expert detail(int expertId);
	// 삭제
	void remove(int expertId);
	// 등록
	// 파일 업로드
	void regist(Expert expert);
	// 수정
	void modify(Expert expert);

}
