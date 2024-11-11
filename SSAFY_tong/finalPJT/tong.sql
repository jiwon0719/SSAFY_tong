CREATE SCHEMA IF NOT EXISTS tong;
USE tong;

-- user 테이블: 사용자 정보
CREATE TABLE `user` (
     `user_id` VARCHAR(50) NOT NULL,  -- 아이디는 최대 50자
     `user_type` CHAR(1) NOT NULL COMMENT 'U : 일반 유저, E: 전문가 유저, A: 관리자',  -- CHAR(1)로 변경
     `password` VARCHAR(60) NOT NULL,  -- 비밀번호는 60자 정도
     `name` VARCHAR(50) NOT NULL,  -- 이름은 50자
     `email` VARCHAR(100) NOT NULL,  -- 이메일은 100자
     `phone` VARCHAR(20) NOT NULL,  -- 전화번호는 20자
     `birthdate` VARCHAR(10) NOT NULL,  -- `생일축하합니다~` 기능 - 로그인 시 인터셉터
     `address` VARCHAR(100) NOT NULL,  -- 주소는 100자
     `updated_password` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 비밀번호 변경시 길이
     `is_kakao_member` CHAR(1) COMMENT 'O : 카카오 유저, X: 일반 유저',  
     `user_profile_img_path` VARCHAR(255), -- user 프로필 이미지 경로 , 후에 default로 기본 이미지 경로 설정
     PRIMARY KEY (`user_id`)
);


-- expert 테이블: 전문가 정보
CREATE TABLE `expert` (
    `expert_id` INT NOT NULL AUTO_INCREMENT,  
    `user_id` VARCHAR(50) NOT NULL,  -- user_id는 50자
    `location` VARCHAR(100) NOT NULL,  -- 위치 정보는 100자
    `introduction` VARCHAR(500) NOT NULL,  -- 전문가 소개는 500자
    `price` INT NOT NULL,  -- 가격은 INT로
    `price_detail` VARCHAR(500) NOT NULL,  -- 가격 상세는 500자
    `grade` VARCHAR(10) NOT NULL,  -- 등급은 10자 ex) 점장, 프로
    `total_score` INT, -- INSERT 시에 update. 회원들이 매긴 점수 전체
    `total_score_cnt` INT, -- INSERT 시에 update. 회원들이 매긴 갯수 
    `company_name` VARCHAR(100) NOT NULL,  -- 회사명은 100자
    `latitude` DOUBLE NOT NULL,  -- 위도는 DOUBLE
    `longitude` DOUBLE NOT NULL,  -- 경도는 DOUBLE
    PRIMARY KEY (`expert_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- expert_career 테이블: 전문가 경력 정보
CREATE TABLE `expert_career` (
    `expert_career_id` INT NOT NULL AUTO_INCREMENT,  
    `expert_id` INT NOT NULL,  
    `career_detail` VARCHAR(200) NULL,  -- 경력 설명은 200자
    `start_date` VARCHAR(10),  
    `end_date` VARCHAR(10),  
    -- 　`expert_career_order` INT AUTO_INCREMENT,　　　한번에　테이블에　ａｉ　는　１개만　설정가능
    PRIMARY KEY (`expert_career_id`),
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);


-- expert_image 테이블: 전문가 자기소개 이미지 정보
CREATE TABLE `expert_image` (
    `file_id` INT NOT NULL AUTO_INCREMENT,
    `expert_id` INT NOT NULL,  
    `file_path` VARCHAR(255) ,  
    `ori_name` VARCHAR(255) ,  
    `system_name` VARCHAR(255),  
    `extension` VARCHAR(10),  
    PRIMARY KEY (`file_id`),
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);

-- matching 테이블: 유저와 전문가 매칭 정보
CREATE TABLE `matching` (
    `matching_id` INT NOT NULL AUTO_INCREMENT,  
    `user_id` VARCHAR(50) NOT NULL,  -- 사용자의 id 정보
    `expert_user_id` VARCHAR(50) NOT NULL,  -- 전문가의 id 정보 
    `status` char(1) DEFAULT 'X' ,  -- 매칭 : O , 아니면 : X
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    `score` TINYINT ,  -- 점수는 TINYINT로 충분
    PRIMARY KEY (`matching_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- user_expert_chat 테이블: 유저와 전문가 간의 채팅
CREATE TABLE `user_expert_chat` (
    `chat_id` INT NOT NULL AUTO_INCREMENT,
    `matching_id` INT NOT NULL,        -- matching_id 이용해서 "전문가, 사용자의 채팅방" 이름으로 채팅방 작성
    `sender_id` VARCHAR(50) NOT NULL,  -- 보낸 사람 ID는 50자
    `content` VARCHAR(255),  -- 채팅 내용
    `sent_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    `is_read` char(1) DEFAULT 'X',  -- 읽음 :  O, 안읽음 : X
    PRIMARY KEY (`chat_id`),
    FOREIGN KEY (`matching_id`) REFERENCES `matching`(`matching_id`) ON DELETE CASCADE
);

-- board_category 테이블: 게시판 카테고리
CREATE TABLE `board_category` (
    `category_id` INT NOT NULL AUTO_INCREMENT,  
    `user_id` VARCHAR(50) NOT NULL,  
    `category` VARCHAR(10) NOT NULL,  -- 카테고리명은 10자
    `description` VARCHAR(50) NOT NULL,  -- 카테고리 설명은 50자
    PRIMARY KEY (`category_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- board_category_hold 테이블 : 사용자가 특정 게시판 찜  -> 나중에 분류할때 우선적으로 보일수 있도록
CREATE TABLE `board_category_hold` (
	`board_category_hold_id` INT NOT NULL AUTO_INCREMENT,
    `category_id` INT NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,  
    `is_hold` char(1) DEFAULT 'X',  -- 찜 함 :  O, 찜 안함 : X
    PRIMARY KEY (`board_category_hold_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`category_id`) REFERENCES `board_category`(`category_id`) ON DELETE CASCADE
);


-- board 테이블: 게시글
CREATE TABLE `board` (
    `board_id` INT NOT NULL AUTO_INCREMENT,  
    `category_id` INT NOT NULL,  
    `title` VARCHAR(20) NOT NULL,  -- 제목은 20자
    `writer` VARCHAR(50) NOT NULL,  -- 작성자 ID는 50자
    `content` VARCHAR(255) NOT NULL,  -- 게시글 내용은 TEXT로
    `view_cnt` INT NULL,  -- 조회수는 INT
    `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    PRIMARY KEY (`board_id`),
    FOREIGN KEY (`writer`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`category_id`) REFERENCES `board_category`(`category_id`) ON DELETE CASCADE
);

-- comment 테이블: 게시글 댓글, 대댓글
CREATE TABLE `comment` (
    `comment_id` INT NOT NULL AUTO_INCREMENT,  
    `board_id` INT NOT NULL,  -- 게시글 ID
    `commenter` VARCHAR(50) NOT NULL,  -- 작성자 ID
    `content` VARCHAR(255) NOT NULL,  -- 댓글 내용
    `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성 일자
    `parent_comment_id` INT DEFAULT NULL,  -- 부모 댓글 ID (NULL일 경우 일반 댓글, 아니면 답글)
    PRIMARY KEY (`comment_id`),
    FOREIGN KEY (`board_id`) REFERENCES `board`(`board_id`) ON DELETE CASCADE,
    FOREIGN KEY (`commenter`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`parent_comment_id`) REFERENCES `comment`(`comment_id`) ON DELETE CASCADE
);


-- calendar 테이블: 유저의 일정
CREATE TABLE `calendar` (
    `calendar_id` INT NOT NULL AUTO_INCREMENT,  
    `user_id` VARCHAR(50) NOT NULL,  -- user_id는 50자
    `year` TINYINT NOT NULL,  -- 연도
    `month` TINYINT NOT NULL,  -- 월
    `date` TINYINT NOT NULL,  -- 일
    PRIMARY KEY (`calendar_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- quest 테이블: 유저와 전문가 간의 퀘스트
CREATE TABLE `quest` (
    `quest_id` INT NOT NULL AUTO_INCREMENT,  
    `calendar_id` INT NOT NULL,  
    `expert_id` INT NOT NULL,  
    `user_id` VARCHAR(50) NOT NULL,  
    `quest_title` VARCHAR(50) NOT NULL,  -- 퀘스트 제목은 50자
    `quest_detail` VARCHAR(100) NOT NULL,  -- 퀘스트 상세 내용은 100자
    `completion_status` char(1) DEFAULT 'X',  -- 퀘스트 중 : X , 퀘스트 완료 : O
    PRIMARY KEY (`quest_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- reservation 테이블: 예약 정보
CREATE TABLE `reservation` (
    `reservation_id` INT NOT NULL AUTO_INCREMENT,  
    `calendar_id` INT NOT NULL,  
    `user_id` VARCHAR(50) NOT NULL,  
    `expert_id` INT NOT NULL,  
    `time` VARCHAR(50) NOT NULL, 
    `status` char(1) DEFAULT 'X',  -- 예약 중 : X , 예약 완료 : O
    PRIMARY KEY (`reservation_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);



-- -----------------------------------------------------
select * from user;

DELETE FROM user WHERE name = '유승호';
