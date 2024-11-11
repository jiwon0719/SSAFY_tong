package com.ssafy.tong.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
		"com.ssafy.tong.board.model.dao", 
		"com.ssafy.tong.comment.model.dao", 
		"com.ssafy.tong.reply.model.dao", 
		"com.ssafy.tong.expert.model.dao",
		"com.ssafy.tong.user.model.dao"
})
public class DBConfig {
	
}
