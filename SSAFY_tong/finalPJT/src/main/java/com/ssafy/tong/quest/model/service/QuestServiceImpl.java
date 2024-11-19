package com.ssafy.tong.quest.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.quest.model.dao.QuestDao;

@Service
public class QuestServiceImpl implements QuestService {
	private final QuestDao questDao;
	public QuestServiceImpl(QuestDao questDao) {
		this.questDao = questDao;
	}
	@Override
	public Quest registQuest(Quest quest) {
		// TODO Auto-generated method stub
		return null;
	}
	// (일반회원용) 퀘스트 성공/실패
	@Override
	public void updateStatus(int questId, String status) {
        // 상태값 검증
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid status value");
        }
        
        // 예약 존재 여부 확인
        if (questDao.getQuest(questId) == null) {
            throw new RuntimeException("Quest not found");
        }
        
        // 상태 업데이트
        Map<String, Object> params = new HashMap<>();
        params.put("questId", questId);
        params.put("status", status);
        
        questDao.updateStatus(params);
    }
    
    private boolean isValidStatus(String status) {
        return status != null && status.length() == 1 && 
               Arrays.asList('O', 'X', 'F').contains(status.charAt(0));
    }
}
