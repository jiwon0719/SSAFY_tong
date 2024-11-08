CREATE SCHEMA IF NOT EXISTS tong;
USE tong;

CREATE TABLE `user` (
    `user_id` VARCHAR(50) NOT NULL COMMENT '중복허용 X',
    `user_type` VARCHAR(1) NULL COMMENT 'U : 일반 유저, E: 전문가 유저, A: 관리자',
    `password` VARCHAR(50) NULL,
    `name` VARCHAR(50) NULL,
    `email` VARCHAR(255) NULL,
    `phone` VARCHAR(20) NULL,  -- 전화번호는 문자열로 변경
    `birthdate` DATE NULL,      -- DATETIME에서 DATE로 변경
    `address` VARCHAR(50) NULL,
    `updated_password` VARCHAR(50) NULL,
    `is_kakao_member` VARCHAR(255) NULL,
    PRIMARY KEY (`user_id`)
);

    `expert_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `location` VARCHAR(50) NULL,
    `introduction` VARCHAR(500) NULL,
    `price` INT NULL,
    `price_detail` VARCHAR(500) NULL,
    `grade` VARCHAR(50) NULL,
    `average_score` DECIMAL(3,2) NULL COMMENT '평균 점수 업데이트 트리거 또는 스케줄러 사용',  -- 소수점 포함
    `company_name` VARCHAR(50) NULL,
    PRIMARY KEY (`expert_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

CREATE TABLE `expert_career` (
    `career_id` INT NOT NULL AUTO_INCREMENT,
    `expert_id` INT NOT NULL,
    `career_detail` VARCHAR(50) NULL,
    `start_date` DATE NULL,     -- DATETIME에서 DATE로 변경
    `end_date` DATE NULL,       -- DATETIME에서 DATE로 변경
    PRIMARY KEY (`career_id`),
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);

CREATE TABLE `user_image` (
    `file_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `file_path` VARCHAR(50) NULL,
    `ori_name` VARCHAR(50) NULL,
    `system_name` VARCHAR(50) NULL,
    `extension` VARCHAR(50) NULL,
    PRIMARY KEY (`file_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

CREATE TABLE `expert_image` (
    `file_id` INT NOT NULL AUTO_INCREMENT,
    `expert_id` INT NOT NULL,
    `file_path` VARCHAR(50) NULL,
    `ori_name` VARCHAR(50) NULL,
    `system_name` VARCHAR(50) NULL,
    `extension` VARCHAR(50) NULL,
    PRIMARY KEY (`file_id`),
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);

CREATE TABLE `matching` (
    `utoe_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `expert_id` INT NOT NULL,
    `status` VARCHAR(50) NULL,
    `created_at` DATETIME NULL,   -- DATETIME 그대로 유지 (원하는 경우 TIMESTAMP로 변경 가능)
    `score` TINYINT NULL,         -- 스코어의 범위에 따라 TINYINT 사용
    PRIMARY KEY (`utoe_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);

CREATE TABLE `user_expert_chat` (
    `chat_id` INT NOT NULL AUTO_INCREMENT,
    `utoe_id` INT NOT NULL,
    `sender_id` VARCHAR(50) NULL,
    `content` VARCHAR(300) NULL,
    `sent_at` DATETIME NULL,
    `is_read` TINYINT(1) NULL,     -- 안 읽으면 0, 읽으면 1
    PRIMARY KEY (`chat_id`),
    FOREIGN KEY (`utoe_id`) REFERENCES `matching`(`utoe_id`) ON DELETE CASCADE
);

CREATE TABLE `board_category` (
    `category_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `category` VARCHAR(50) NULL,
    `description` VARCHAR(50) NULL,
    PRIMARY KEY (`category_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

CREATE TABLE `board` (
    `board_id` INT NOT NULL AUTO_INCREMENT,
    `category_id` INT NOT NULL,
    `title` VARCHAR(50) NULL,
    `writer` VARCHAR(50) NULL,
    `content` VARCHAR(300) NULL,
    `view_cnt` INT NULL,
    `reg_date` DATETIME NULL,
    PRIMARY KEY (`board_id`),
    FOREIGN KEY (`category_id`) REFERENCES `board_category`(`category_id`) ON DELETE CASCADE
);
ALTER TABLE board
ADD CONSTRAINT fk_board_writer
FOREIGN KEY (writer) REFERENCES user(user_id)
ON DELETE CASCADE;


CREATE TABLE `comment` (
    `comment_id` INT NOT NULL AUTO_INCREMENT,
    `board_id` INT NULL,
    `commenter` VARCHAR(50) NULL,
    `content` VARCHAR(300) NULL,
    `reg_date` DATETIME NULL,
    PRIMARY KEY (`comment_id`),
    FOREIGN KEY (`board_id`) REFERENCES `board`(`board_id`) ON DELETE CASCADE
);
ALTER TABLE comment
ADD CONSTRAINT fk_comment_commneter
FOREIGN KEY (commenter) REFERENCES user(user_id)
ON DELETE CASCADE;

CREATE TABLE `reply` (
    `reply_id` INT NOT NULL AUTO_INCREMENT,
    `comment_id` INT NULL,
    `replier` VARCHAR(50) NULL,
    `content` VARCHAR(300) NULL,
    `reg_date` DATETIME NULL,
    PRIMARY KEY (`reply_id`),
    FOREIGN KEY (`comment_id`) REFERENCES `comment`(`comment_id`) ON DELETE CASCADE
);
ALTER TABLE reply
ADD CONSTRAINT fk_reply_replier
FOREIGN KEY (replier) REFERENCES user(user_id)
ON DELETE CASCADE;

CREATE TABLE `calendar` (
    `calendar_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `year` INT NULL,
    `month` INT NULL,
    PRIMARY KEY (`calendar_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

CREATE TABLE `quest` (
    `quest_id` INT NOT NULL AUTO_INCREMENT,
    `calendar_id` INT NOT NULL,
    `expert_id` INT NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `quest_title` VARCHAR(50) NULL,
    `quest_detail` VARCHAR(100) NULL,
    `date` DATE NULL,              -- DATETIME에서 DATE로 변경
    `completion_status` VARCHAR(50) NULL,
    PRIMARY KEY (`quest_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
);

CREATE TABLE `reservation` (
    `reservation_id` INT NOT NULL AUTO_INCREMENT,
    `calendar_id` INT NOT NULL,
    `user_id` VARCHAR(50) NOT NULL,
    `expert_id` INT NOT NULL,
    `date` DATE NULL,              -- VARCHAR에서 DATE로 변경
    `time` TIME NULL,              -- VARCHAR에서 TIME으로 변경
    `status` VARCHAR(255) NULL,
    PRIMARY KEY (`reservation_id`),
    FOREIGN KEY (`calendar_id`) REFERENCES `calendar`(`calendar_id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);

CREATE TABLE `map` (
    `map_id` INT NOT NULL AUTO_INCREMENT,
    `expert_id` INT NOT NULL,
    `latitude` DOUBLE NULL,
    `longitude` DOUBLE NULL,
    PRIMARY KEY (`map_id`),
    FOREIGN KEY (`expert_id`) REFERENCES `expert`(`expert_id`) ON DELETE CASCADE
);