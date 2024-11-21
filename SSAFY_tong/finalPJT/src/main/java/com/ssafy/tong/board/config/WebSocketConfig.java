package com.ssafy.tong.board.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    @Bean
    public TaskScheduler webSocketTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("websocket-heartbeat-thread-");
        scheduler.initialize();
        return scheduler;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/tongChat", "/ws-stomp") // "/ws-stomp" 엔드포인트 추가
                .setAllowedOriginPatterns("*")
                .withSockJS()
                .setHeartbeatTime(25000)
                .setDisconnectDelay(5000)
                .setWebSocketEnabled(true);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 구독 경로 설정
        config.enableSimpleBroker("/topic")
              .setHeartbeatValue(new long[]{10000, 10000})
              .setTaskScheduler(webSocketTaskScheduler());
        
        // 메시지 발행 경로 설정
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(handler -> {
            return new WebSocketHandlerDecorator(handler) {
                @Override
                public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                    logger.info("새로운 WebSocket 연결 설정: {}", session.getId());
                    super.afterConnectionEstablished(session);
                }

                @Override
                public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
                    logger.info("WebSocket 연결 종료: {}, 상태: {}", session.getId(), status);
                    super.afterConnectionClosed(session, status);
                }

                @Override
                public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
                    logger.error("WebSocket 전송 에러: {}", exception.getMessage(), exception);
                    super.handleTransportError(session, exception);
                }
            };
        });
        
        // 메시지 크기 및 시간 제한 설정
        registration.setSendTimeLimit(30 * 1000)
                   .setSendBufferSizeLimit(512 * 1024)
                   .setMessageSizeLimit(128 * 1024)
                   .setTimeToFirstMessage(30 * 1000);
    }
}