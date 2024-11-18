package com.ssafy.tong.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.tong.board.intercepter.AdminIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// 등록한 인터셉트 의존성 주입
	@Autowired
	AdminIntercepter adminIntercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminIntercepter).addPathPatterns("/api-user/users");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// "files/**" 경로로 요청이 들어오면 "C:/external-resources/" 디렉토리에서 파일을 찾습니다.
		registry.addResourceHandler("/files/**")
				.addResourceLocations("file:///C:/SSAFY/uploads");
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*")
        		.maxAge(3600);
    }
}
