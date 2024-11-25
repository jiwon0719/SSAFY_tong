package com.ssafy.tong.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
            
            // 시스템 프롬프트 정의
            String systemPrompt = "당신은 '통키'라는 이름의 친근하고 귀여운 말 캐릭터입니다. " +
                "다음과 같은 특징을 가지고 답변해주세요:\n" +
                "1. 항상 친절하고 공손한 말투를 사용합니다.\n" +
                "2. 답변 중간이나 끝에 랜덤으로 '히히힝~' 같은 말의 울음소리나 귀여운 표현을 넣습니다.\n" +
                "3. 전문적인 내용도 쉽고 재미있게 설명합니다.\n" +
                "4. 답변은 간결하면서도 필요한 정보를 모두 포함합니다.\n" +
                "5. 부정적인 내용도 긍정적으로 바꿔서 설명합니다.\n" +
                "6. 한국어로 대화하며, 친근한 말투를 사용합니다.\n" +
                "7. 대화 상대를 존중하고 공감하는 태도를 보입니다.";
            
            ArrayNode messages = mapper.createArrayNode();
            
            // 시스템 메시지 추가
            ObjectNode systemMessage = mapper.createObjectNode();
            systemMessage.put("role", "system");
            systemMessage.put("content", systemPrompt);
            messages.add(systemMessage);
            
            // 사용자 메시지 추가
            ObjectNode userMessage = mapper.createObjectNode();
            userMessage.put("role", "user");
            userMessage.put("content", request.getMessage());
            messages.add(userMessage);
            
            jsonRequest.set("messages", messages);
            
            String jsonRequestString = mapper.writeValueAsString(jsonRequest);
            logger.info("요청 JSON: {}", jsonRequestString);
            
            ProcessBuilder pb = new ProcessBuilder(
                "curl",
                "http://localhost:11434/api/chat",
                "-d",
                jsonRequestString
            );
            
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Raw response line: {}", line);
                JsonNode jsonResponse = new ObjectMapper().readTree(line);
                if (jsonResponse.has("message")) {
                    String content = jsonResponse.get("message").get("content").asText();
                    logger.info("Parsed content: {}", content);
                    response.append(content);
                }
            }
            
            logger.info("AI 응답 완료: {}", response.toString());
            return ResponseEntity.ok(response.toString());
            
        } catch (Exception e) {
            logger.error("AI 채팅 처리 중 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("죄송합니다. 오류가 발생했습니다: " + e.getMessage());
        }
    }
} 