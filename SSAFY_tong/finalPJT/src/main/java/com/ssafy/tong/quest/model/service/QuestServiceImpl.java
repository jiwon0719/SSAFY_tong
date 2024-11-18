package com.ssafy.tong.quest.model.service;

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


}
