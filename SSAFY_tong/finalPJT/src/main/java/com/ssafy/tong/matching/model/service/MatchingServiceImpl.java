package com.ssafy.tong.matching.model.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.expert.model.UserList;
import com.ssafy.tong.matching.model.Matching;
import com.ssafy.tong.matching.model.dao.MatchingDao;

@Service
public class MatchingServiceImpl implements MatchingService {
    private final MatchingDao matchingDao;
    
    public MatchingServiceImpl(MatchingDao matchingDao) {
        this.matchingDao = matchingDao;
    }

    // 등록(신청)
    @Override
    public void regist(Matching matching) {
        matchingDao.insertMatching(matching);
    }

    // 매칭 상태 확인
    @Override
    public boolean checkExistingMatching(String userId, String expertUserId) {
    	return matchingDao.checkExistingMatching(userId, expertUserId);
    }

    // 상세 조회
    @Override
    public List<ExpertList> getUserMatchingList(String userId) {
        return matchingDao.selectMatchingsByUserId(userId);
    }

    @Override
    public List<UserList> getExpertMatchingList(String expertId) {
    	return matchingDao.selectMatchingsByExpertId(expertId);
    }

    // 점수 업데이트
	@Override
	public void updateScore(int expertId, String userId, int score) {
		matchingDao.updateScore(expertId, userId, score);
	}


}