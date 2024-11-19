package com.ssafy.tong.quest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
    // (일반회원용) 퀘스트 성공/실패
    @PatchMapping("/{questId}")
    public ResponseEntity<Void> updateQuestStatus(
            @PathVariable int questId,
            @RequestParam String status) {
        questService.updateStatus(questId, status);
        return ResponseEntity.ok().build();
    }
}
