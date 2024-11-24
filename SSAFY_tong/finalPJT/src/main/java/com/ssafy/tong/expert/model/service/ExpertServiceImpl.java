package com.ssafy.tong.expert.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertCareer;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.expert.model.dao.ExpertDao;
import com.ssafy.tong.user.model.User;
import com.ssafy.tong.user.model.dao.UserDao;

@Service
public class ExpertServiceImpl implements ExpertService {
	private final UserDao userDao;
	
	private final ExpertDao expertDao;
	public ExpertServiceImpl(ExpertDao expertDao, UserDao userDao) {
		this.expertDao = expertDao;
		this.userDao = userDao;
	}
	// 전제 조회
	@Override
	public List<ExpertList> list() {
		return expertDao.selectExpertList();
	}
	// 상세 조회
	// 기본 정보 조회
	@Override
	public Expert detail(int expertId) {
		return expertDao.selectExpertByPK(expertId);
	}
	// 커리어 정보 조회
	@Override
	public List<ExpertCareer> getExpertCareers(int expertId) {
		return expertDao.selectExpertCareerByPk(expertId);
	}
	// 이미지 정보 조회
	@Override
	public List<ExpertImage> getExpertImages(int expertId) {
		return expertDao.selectExpertImageByPk(expertId);
	}
	// 삭제
	@Override
	public void remove(int expertId) {
		expertDao.deleteExpert(expertId);
	}
	// 등록
	// 파일업로드 
	// 경력업로드
	@Override
	public void regist(Expert expert) {
		expertDao.insertExport(expert); // 전문가 번호 auto_increment
		
		int generatedExpertId = expert.getExpertId();
		List<ExpertImage> expertImages = expert.getExpertImage();

		if(expertImages != null && generatedExpertId > 0) {
			// 첫 번째 이미지의 system_name을 사용자 프로필 이미지로 설정
			ExpertImage firstImage = expertImages.get(0); 
			User user = new User(); 
			user.setUserId(expert.getUserId());
			user.setUserProfileImgPath(firstImage.getSystemName());
			userDao.updateUserProfileImage(user);
			
			// 기존 로직
			for(ExpertImage expertImage : expertImages) {
				expertImage.setExpertId(generatedExpertId);
				expertDao.insertExportImage(expertImage);
			}
		}
		
		List<ExpertCareer> expertCareers = expert.getExpertCareer();
		if(expertCareers != null && generatedExpertId > 0) {
			for(ExpertCareer expertCareer : expertCareers) {
				expertCareer.setExpertId(generatedExpertId);
				expertDao.insertExportCareer(expertCareer);
			}
		}
	}
	// 수정
	@Override
	public void modify(Expert expert) {
		expertDao.updateExpert(expert);
	}
	@Override
	public String findUserIdByExpertId(int expertId) {
		return expertDao.selectUserIdByExpertId(expertId);
	}

}
