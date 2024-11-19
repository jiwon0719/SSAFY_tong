package com.ssafy.tong.quest.model.service;

import com.ssafy.tong.quest.model.Quest;

public interface QuestService {
	// 등록
	Quest registQuest(Quest quest);
	// 퀘스트 성공/실패
	void updateStatus(int questId, String status);

}
