package com.ssafy.tong.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
		"com.ssafy.tong.board.model.dao", 
		"com.ssafy.tong.comment.model.dao", 
		"com.ssafy.tong.reply.model.dao", 
		"com.ssafy.tong.expert.model.dao",
		"com.ssafy.tong.user.model.dao", 
		"com.ssafy.tong.matching.model.dao", 
		"com.ssafy.tong.calendar.model.dao", 
		"com.ssafy.tong.quest.model.dao", 
		"com.ssafy.tong.reservation.model.dao",
		"com.ssafy.tong.chat.dao"
})
public class DBConfig {
	
}
