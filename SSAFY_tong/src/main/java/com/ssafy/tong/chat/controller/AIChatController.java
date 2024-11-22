package com.ssafy.tong.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
            
            ProcessBuilder pb = new ProcessBuilder(
                "curl",
                "http://localhost:11434/api/chat",
                "-d",
                String.format(
                    "{\"model\": \"QuantFactory/Llama-3-MAAL-8B-Instruct-v0.1-GGUF\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
                    request.getMessage().replace("\"", "\\\""))
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
            return ResponseEntity.ok(new AIChatResponse(response.toString()));
            
        } catch (Exception e) {
            logger.error("AI 채팅 처리 중 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new AIChatResponse("죄송합니다. 오류가 발생했습니다: " + e.getMessage()));
        }
    }
} 