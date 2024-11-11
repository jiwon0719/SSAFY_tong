package com.ssafy.tong.expert.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.dao.ExpertDao;

@Service
public class ExpertServiceImpl implements ExpertService {
	private final ExpertDao expertDao;
	public ExpertServiceImpl(ExpertDao expertDao) {
		this.expertDao = expertDao;
	}
	// 전제 조회
	@Override
	public List<Expert> list() {
		return expertDao.selectExpert();
	}
	// 상세 조회
	@Override
	public Expert detail(int expertId) {
		return expertDao.selectExpertByPK(expertId);
	}
	// 삭제
	@Override
	public void remove(int expertId) {
		expertDao.deleteExpert(expertId);
	}
	// 등록
	// 파일업로드 
	@Override
	public void regist(Expert expert) {
		expertDao.insertExport(expert); // 전문가 번호 auto_increment
		ExpertImage expertImage = expert.getExpertImage();
		if(expertImage != null) {
			expertImage.setExpertId(expert.getExpertId());
			expertDao.insertExportImage(expertImage);
		}
	}
	// 수정
	@Override
	public void modify(Expert expert) {
		expertDao.updateExpert(expert);
	}

}
