CREATE SCHEMA IF NOT EXISTS tong;
USE tong;

-- user 테이블: 사용자 정보
CREATE TABLE user (
     user_id VARCHAR(50) NOT NULL,  -- 아이디는 최대 50자
     user_type CHAR(1) NOT NULL COMMENT 'U : 일반 유저, E: 전문가 유저, A: 관리자',  -- CHAR(1)로 변경
     password VARCHAR(60) NOT NULL,  -- 비밀번호는 60자 정도
     name VARCHAR(50) NOT NULL,  -- 이름은 50자
     email VARCHAR(100) NOT NULL,  -- 이메일은 100자
     phone VARCHAR(20) NOT NULL,  -- 전화번호는 20자
     birthdate VARCHAR(10) NOT NULL,  -- 생일축하합니다~ 기능 - 로그인 시 인터셉터
     addressZipcode VARCHAR(100) NOT NULL, -- 우편번호
     address VARCHAR(100) NOT NULL,  -- 도로명 주소
     addressDetail VARCHAR(100) NOT NULL,  -- 상세 주소 like 몇동 몇호
     updated_password TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 비밀번호 변경시 길이
     is_kakao_member CHAR(1), -- 'O : 카카오 유저, X: 일반 유저'
	 userProfileImgPath VARCHAR(255), -- user 프로필 이미지 경로 , 후에 default로 기본 이미지 경로 설정
     PRIMARY KEY (user_id)
);

-- expert 테이블: 전문가 정보
CREATE TABLE `expert` (
    `expert_id` INT NOT NULL AUTO_INCREMENT,  
    `user_id` VARCHAR(50) NOT NULL,  -- user_id는 50자
     `addressZipcode` VARCHAR(100) NOT NULL, -- 우편번호
     `address` VARCHAR(100) NOT NULL,  -- 도로명 주소
     `addressDetail` VARCHAR(100) NOT NULL,  -- 상세 주소 like 몇동 몇호
    `introduction` VARCHAR(500) NOT NULL,  -- 전문가 소개는 500자
    `price` INT NOT NULL,  -- 가격은 INT로
    `price_detail` VARCHAR(500) NOT NULL,  -- 가격 상세는 500자
    `grade` VARCHAR(10) NOT NULL,  -- 등급은 10자 ex) 점장, 프로
    `total_score` INT, -- INSERT 시에 update. 회원들이 매긴 점수 전체
    `total_score_cnt` INT, -- INSERT 시에 update. 회원들이 매긴 갯수 
    `company_name` VARCHAR(100) NOT NULL,  -- 회사명은 100자
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
    `year` INT NOT NULL,  -- 연도
    `month` INT NOT NULL,  -- 월
    `date` INT NOT NULL,  -- 일
    PRIMARY KEY (`calendar_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

-- quest 테이블: 유저와 전문가 간의 퀘스트
CREATE TABLE `quest` (
    `quest_id` INT NOT NULL AUTO_INCREMENT,  
    `calendar_id` INT NOT NULL,  
    `expert_user_id` VARCHAR(50) NOT NULL,  
    `user_id` VARCHAR(50) NOT NULL,  
    `quest_title` VARCHAR(50) NOT NULL,  
    `quest_detail` VARCHAR(100) NOT NULL,  
    `completion_status` CHAR(1) DEFAULT 'X',  
    PRIMARY KEY (`quest_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);
select * from quest;


-- reservation 테이블: 예약 정보
CREATE TABLE `reservation` (
    `reservation_id` INT NOT NULL AUTO_INCREMENT,  
    `calendar_id` INT NOT NULL,  
    `user_id` VARCHAR(50) NOT NULL,  
    `expert_user_id` VARCHAR(50) NOT NULL,  -- INT에서 VARCHAR(50)로 변경
    `time` VARCHAR(50) NOT NULL, 
    `status` CHAR(1) DEFAULT 'X',  
    PRIMARY KEY (`reservation_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);


-- -----------------------------------------------------
-- admin 계정 추가
insert into user(
	user_id, user_type, password, name, email, phone, birthdate, addressZipcode, address, addressDetail, is_kakao_member)
    values(
    "admin", "A", "admin", "admin", "admin@tong.com", "000-0000-0000", "00000000", "12345","주소", "주소상세", "X"); 


select * from board;
select * from comment;
select * from matching;
select * from user;
select * from calendar;
select * from reservation;
select * from quest;
select * from expert;
select * from matching;
select * from user;


-- ------------------------------------------------------
-- User 테이블 데이터
INSERT INTO user (user_id, user_type, password, name, email, phone, birthdate, addressZipcode, address, addressDetail, is_kakao_member) VALUES
('user1', 'U', 'pass123', '김철수', 'kim@email.com', '010-1234-5678', '19900101', '06234', '서울시 강남구 테헤란로', '101동 1004호', 'X'),
('user2', 'U', 'pass124', '이영희', 'lee@email.com', '010-2345-6789', '19910202', '06235', '서울시 강남구 역삼로', '202동 705호', 'O'),
('expert1', 'E', 'pass125', '박전문', 'park@email.com', '010-3456-7890', '19850303', '06236', '서울시 강남구 선릉로', '303동 1202호', 'X'),
('expert2', 'E', 'pass126', '정멘토', 'jung@email.com', '010-4567-8901', '19880404', '04101', '서울시 마포구 백범로', '404동 801호', 'X'),
('expert3', 'E', 'pass127', '홍길동', 'hong@email.com', '010-5678-9012', '19920505', '07230', '서울시 영등포구 여의대로', '505동 1501호', 'X');

-- Expert 테이블 데이터
INSERT INTO expert (user_id, addressZipcode, address, addressDetail, introduction, price, price_detail, grade, company_name) VALUES
('expert1', '06236', '서울시 강남구 선릉로', '303동 1202호', '10년 경력의 퍼스널 트레이너입니다. 체계적인 운동 지도를 제공합니다.', 50000, '1회 상담 5만원 / 10회 45만원 / 20회 80만원', '프로', '헬스케어 센터'),
('expert2', '04101', '서울시 마포구 백범로', '404동 801호', '영양사 자격증을 보유한 다이어트 전문가입니다.', 40000, '1회 상담 4만원 / 10회 35만원 / 20회 60만원', '점장', '피트니스 클럽'),
('expert3', '07230', '서울시 영등포구 여의대로', '505동 1501호', '체육학 박사 학위 보유, 과학적인 운동 지도를 제공합니다.', 60000, '1회 상담 6만원 / 10회 55만원 / 20회 100만원', '프로', '스포츠 센터');
select * from expert;


-- Expert Career 테이블 데이터
INSERT INTO expert_career (expert_id, career_detail, start_date, end_date) VALUES
(1, '메가 휘트니스 트레이너', '2015-01-01', '2018-12-31'),
(1, '헬스케어 센터 센터장', '2019-01-01', '2023-12-31'),
(2, '병원 영양사', '2016-01-01', '2020-12-31'),
(2, '피트니스 클럽 트레이너', '2021-01-01', '2023-12-31'),
(3, '대학교 체육학과 강사', '2018-01-01', '2023-12-31');
select * from expert_career;


-- Expert Image 테이블 데이터


-- Matching 테이블 데이터
INSERT INTO matching (user_id, expert_user_id, status) VALUES
('user1', 'expert1', 'O'),
('user1', 'expert2', 'O'),
('user2', 'expert2', 'O'),
('user2', 'expert3', 'X'),
('user1', 'expert3', 'O');

-- User Expert Chat 테이블 데이터
-- INSERT INTO user_expert_chat (matching_id, sender_id, content, is_read) VALUES
-- (1, 'user1', '상담 가능한 시간을 알려주세요', 'O'),
-- (1, 'expert1', '네, 매주 월요일 2시가 가능합니다', 'O'),
-- (2, 'user1', '식단 관련 문의드립니다', 'X'),
-- (3, 'expert1', '운동 계획 보내드립니다', 'O'),
-- (4, 'user2', '상담 신청합니다', 'X');

-- Board Category 테이블 데이터
INSERT INTO board_category (user_id, category, description) VALUES
('admin', '건강정보', '건강 정보 공유 게시판'),
('admin', '운동정보', '운동 정보 공유 게시판'),
('admin', '식단정보', '식단 정보 공유 게시판'),
('admin', 'Q&A', '질문과 답변 게시판'),
('admin', '후기', '이용 후기 게시판');

-- Board Category Hold 테이블 데이터
-- INSERT INTO board_category_hold (category_id, user_id, is_hold) VALUES
-- (1, 'user1', 'O'),
-- (2, 'user1', 'O'),
-- (3, 'user2', 'O'),
-- (4, 'user2', 'X'),
-- (5, 'user1', 'O');

-- Board 테이블 데이터
INSERT INTO board (category_id, title, writer, content) VALUES
(1, '건강관리 꿀팁', 'user1', '일상적인 건강관리 방법 공유합니다. 1. 충분한 수면 2. 규칙적인 운동 3. 균형 잡힌 식사'),
(2, '홈트레이닝 방법', 'expert1', '집에서 할 수 있는 효과적인 운동 루틴을 소개합니다. 스쿼트, 푸시업, 플랭크 순서로 진행하세요.'),
(3, '다이어트 식단', 'expert2', '건강한 다이어트를 위한 일주일 식단표입니다. 단백질 위주의 식단으로 구성했습니다.'),
(4, '운동 질문있어요', 'user2', '처음 헬스장을 가려고 하는데 필수적으로 준비할 것들이 무엇이 있을까요?'),
(5, '상담 후기입니다', 'user1', '전문가 상담을 받고 한 달간 실천한 결과 5kg 감량에 성공했습니다!');

-- Comment 테이블 데이터
INSERT INTO comment (board_id, commenter, content, parent_comment_id) VALUES
(1, 'expert1', '좋은 정보 감사합니다. 수면의 질을 높이는 방법도 추가해 주시면 좋을 것 같아요.', NULL),
(1, 'user2', '저도 실천해보겠습니다. 많은 도움이 되었어요!', NULL),
(2, 'user1', '홈트레이닝 영상도 있나요?', NULL),
(2, 'expert2', '네, 다음 게시글에서 자세한 동작 방법을 설명해드리겠습니다.', 3),
(3, 'user2', '칼로리 정보도 함께 올려주시면 감사하겠습니다.', NULL);

-- Calendar 테이블 데이터
INSERT INTO calendar (user_id, year, month, date) VALUES
('user1', 2024, 11, 20),
('user1', 2024, 11, 21),
('user2', 2024, 11, 22);

-- Quest 테이블 데이터
INSERT INTO quest (calendar_id, expert_user_id, user_id, quest_title, quest_detail) VALUES
(1, 'expert1', 'user1', '아침 운동하기', '30분 걷기 운동 실천하기'),
(2, 'expert1', 'user1', '식단 기록하기', '오늘의 식단 사진 찍어서 공유하기'),
(3, 'expert2', 'user2', '스트레칭하기', '기상 직후 전신 스트레칭 10분 실천하기'),
(4, 'expert1', 'user1', '물 마시기', '하루 2리터 물 마시기 목표 달성하기'),
(5, 'expert2', 'user2', '근력 운동하기', '스쿼트 30회 3세트 완료하기');

-- Reservation 테이블 데이터
INSERT INTO reservation (calendar_id, user_id, expert_user_id, time) VALUES
(1, 'user1', 'expert1', '14:00'),
(2, 'user1', 'expert1', '15:00'),
(3, 'user2', 'expert2', '16:00'),
(4, 'user1', 'expert1', '17:00'),
(5, 'user2', 'expert2', '18:00');

