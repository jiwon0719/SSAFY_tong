package com.ssafy.tong.quest.model.dao;

import java.util.Map;

public interface QuestDao {

	Object getQuest(int questId);

	void updateStatus(Map<String, Object> params);

}
