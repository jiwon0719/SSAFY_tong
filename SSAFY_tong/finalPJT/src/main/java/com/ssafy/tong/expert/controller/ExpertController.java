package com.ssafy.tong.expert.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.tong.expert.model.Expert;
import com.ssafy.tong.expert.model.ExpertCareer;
import com.ssafy.tong.expert.model.ExpertImage;
import com.ssafy.tong.expert.model.ExpertList;
import com.ssafy.tong.expert.model.service.ExpertService;

@RestController
@RequestMapping("/api/expert")
@CrossOrigin(origins = "http://192.168.210.55:5173", allowCredentials = "true", allowedHeaders = "*")
// 전문가
// 본인 PR 자기소개 페이지
public class ExpertController {
	private final ExpertService expertService;
	public ExpertController(ExpertService expertService) {
		this.expertService = expertService;
	}
	
	// 전체 조회
	@GetMapping("/list")
	public ResponseEntity<List<ExpertList>> list() {
	    try {
	        List<ExpertList> experts = expertService.list();
//	        for(ExpertList expert : experts) {
//	        	System.out.println(expert);
//	        }
	        
	        if (experts == null) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(experts);
	    } catch (Exception e) {
	        System.out.println("에러 발생: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	///////////////////////////////////////////////////
	// 이미지 파일 처리 추가 
	@Value("${file.upload.directory}")
	private String uploadDirectory;
	
    // 전문가 이미지 파일 제공
    @GetMapping("/image/{userId}/{fileName}")
    @CrossOrigin(origins = "http://192.168.210.55:5173")  // 개별 메서드에도 추가
    public ResponseEntity<Resource> getImage(@PathVariable String userId, 
                                           @PathVariable String fileName) {
        System.out.println("=== 이미지 요청 시작 ===");
        System.out.println("userId: " + userId);
        System.out.println("fileName: " + fileName);
        
        try {
            Path filePath = Paths.get(uploadDirectory, userId, fileName);
            System.out.println("파일 경로: " + filePath.toString());
            
            File file = filePath.toFile();
            boolean exists = file.exists();
            System.out.println("파일 존재 여부: " + exists);
            
            if (!exists) {
                System.out.println("파일이 존재하지 않습니다.");
                return ResponseEntity.notFound().build();
            }

            Resource resource = new FileSystemResource(file);
            return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
                .body(resource);
                
        } catch(Exception e) {
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /////////////////////////////////////////////////////	
	// 상세 조회
	// 기본 정보 조회
	@GetMapping("{expert_id}")
	public ResponseEntity<Expert> detail(@PathVariable("expert_id") int expertId) {
		Expert expert = expertService.detail(expertId);
		if(expert == null) { // 요청한 게시글 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		// 이미지 URL 설정
        if(expert.getExpertImage() != null) {
            for(ExpertImage image : expert.getExpertImage()) {
                String imageUrl = String.format("/api/expert/image/%s/%s",
                    image.getFilePath(), image.getSystemName());
                image.setFilePath(imageUrl);
            }
        }
		
//        System.out.println(expert);
		return ResponseEntity.status(HttpStatus.OK).body(expert);
	}
	
	// 경력 정보 조회
    @GetMapping("{expert_id}/careers")
    public ResponseEntity<List<ExpertCareer>> getCareers(@PathVariable("expert_id") int expertId) {
        List<ExpertCareer> careers = expertService.getExpertCareers(expertId);
        if(careers == null || careers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(careers);
    }
	
	// 이미지 정보 조회
    @GetMapping("{expert_id}/images")
    public ResponseEntity<List<ExpertImage>> getImages(@PathVariable("expert_id") int expertId) {
    	System.out.println("전문가 상세: 이미지 정보 조회 시작");
        List<ExpertImage> images = expertService.getExpertImages(expertId);
        if(images == null || images.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }
	
    ///////////////////////////////////////////////////////
  
    
    
	// 삭제
	@DeleteMapping("{expert_id}")
	public void remove(@PathVariable("expert_id") int expertId) {
		expertService.remove(expertId);
		
	}
	

	// 등록
	// 파일 업로드
	// 경력 업로드
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> regist(
            @RequestPart("expert") String expertJson,
            @RequestPart("files") List<MultipartFile> files,
            @RequestPart("career") String careerJson
    ) {
        try {
        	
        	// 데이터 잘 오는지 확인
            System.out.println("Expert JSON: " + expertJson);
            System.out.println("Career JSON: " + careerJson);
            System.out.println("Files count: " + files.size());
            
        	
            ObjectMapper mapper = new ObjectMapper();
            Expert expert = mapper.readValue(expertJson, Expert.class);
            List<ExpertCareer> careers = mapper.readValue(careerJson, 
                mapper.getTypeFactory().constructCollectionType(List.class, ExpertCareer.class));

            List<ExpertImage> expertImages = new ArrayList<>();
            
            // 파일 처리
            if (files != null && !files.isEmpty()) {
                String userId = String.valueOf(expert.getUserId());
                File dir = new File("c:/SSAFY/SSAFY_tong/expertImage/" + userId);
                dir.mkdirs();

                for (MultipartFile file : files) {
                    String oriName = file.getOriginalFilename();
                    if (oriName != null && !oriName.isEmpty()) {
                        String extension = oriName.substring(oriName.lastIndexOf(".") + 1);
                        String systemName = UUID.randomUUID().toString() + "." + extension;
                        file.transferTo(new File(dir, systemName));
                        
                        ExpertImage expertImage = new ExpertImage();
                        expertImage.setFilePath(userId);
                        expertImage.setOriName(oriName);
                        expertImage.setSystemName(systemName);
                        expertImage.setExtension(extension);
                        expertImages.add(expertImage);
                    }
                }
            }
            
            expert.setExpertImage(expertImages);
            expert.setExpertCareer(careers);
            expertService.regist(expert);
            
            return ResponseEntity.ok("전문가 등록이 완료되었습니다.");
            
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("전문가 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
	
	
	// 수정
	@PutMapping("{expert_id}")
	public void modify(@PathVariable("expert_id") int expertId, @RequestBody Expert expert) {
		expert.setExpertId(expertId);
		expertService.modify(expert);
	}
	
	
	@GetMapping("/{expertId}/userId")
	public ResponseEntity<String> getExpertUserId(@PathVariable int expertId) {
	    System.out.println("전문가 ID 조회 요청: " + expertId);
	    String userId = expertService.findUserIdByExpertId(expertId);
	    System.out.println("조회된 userId: " + userId);
	    return ResponseEntity.ok(userId);
	}
	
	
}
