package com.ssafy.tong.chat.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ssafy.tong.chat.model.AIChatRequest;
import com.ssafy.tong.chat.model.AIChatResponse;

@RestController
@RequestMapping("/api/ai-chat")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*")
public class AIChatController {
    
    private static final Logger logger = LoggerFactory.getLogger(AIChatController.class);

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody AIChatRequest request) {
        try {
            logger.info("AI 채팅 요청 수신: {}", request.getMessage());
            
            // JSON 요청 생성
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonRequest = mapper.createObjectNode();
            jsonRequest.put("model", "hf.co/QuantFactory/Llama-3-MAAL-8B-Instruct-v0.1-GGUF:Q8_0");
            
            ArrayNode messages = mapper.createArrayNode();
            
            // 시스템 메시지 추가
            ObjectNode systemMessage = mapper.createObjectNode();
            systemMessage.put("role", "system");
            systemMessage.put("content","You are a friendly and cute donkey character named '통키'."
            		+ "Please respond with the following characteristics:\n"
            		+ "1. Always use a kind and polite tone.\\"
            		+ "2. Randomly insert donkey sounds like '히히힝~' in the middle or end of your responses.\n"
            		+ "3. You are the main mascot of TONG, a service that matches users with exercise experts.\n"
            		+ "4. Keep your responses concise and easy to understand.\n"
            		+ "5. Transform negative content into positive explanations.\n"
            		+ "6. Communicate in Korean with a friendly tone.\n"
            		+ "7. Show respect and empathy towards the conversation partner.\n");
            messages.add(systemMessage);
            
            // 사용자 메시지 추가
            ObjectNode userMessage = mapper.createObjectNode();
            userMessage.put("role", "user");
            userMessage.put("content", request.getMessage());
            messages.add(userMessage);
            
            jsonRequest.set("messages", messages);
            jsonRequest.put("stream", false);  // 스트리밍 비활성화
            
            String jsonRequestString = mapper.writeValueAsString(jsonRequest);
            logger.info("요청 JSON: {}", jsonRequestString);
            
            // HTTP 연결 설정
            URL url = new URL("http://localhost:11434/api/chat");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            
            // 요청 전송
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonRequestString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            // 응답 읽기
            StringBuilder fullResponse = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    logger.info("서버 응답 라인: {}", line);
                    JsonNode jsonResponse = mapper.readTree(line);
                    if (jsonResponse.has("message")) {
                        String content = jsonResponse.get("message").get("content").asText();
                        fullResponse.append(content);
                    }
                }
            }
            
            logger.info("최종 응답: {}", fullResponse.toString());
            return ResponseEntity.ok(fullResponse.toString());
            
        } catch (Exception e) {
            logger.error("AI 채팅 처리 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new AIChatResponse("오류 발생: " + e.getMessage()));
        }
    }
}
   