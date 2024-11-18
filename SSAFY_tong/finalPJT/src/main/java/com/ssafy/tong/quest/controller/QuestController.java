package com.ssafy.tong.quest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tong.quest.model.Quest;
import com.ssafy.tong.quest.model.service.QuestService;

@RestController
@RequestMapping("/api/quest")
@CrossOrigin
public class QuestController {
	private final QuestService questService;
	public QuestController(QuestService questService) {
		this.questService = questService;
	}
	
	
    @PostMapping("/quests")
    public ResponseEntity<Quest> createQuest(@RequestBody Quest questDTO) {
        return ResponseEntity.ok(questService.registQuest(questDTO));
    }
	
	
}
