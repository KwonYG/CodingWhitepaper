drop table if exists answer_code;
drop table if exists answer;
drop table if exists code;
drop table if exists service_group_answer;
drop table if exists question;
drop table if exists service_group_question;
drop table if exists service_group;
drop table if exists service_user;
drop table if exists topic_comment;
drop table if exists topic;
  
-- -----------------------------------------------------
-- Table `service_user`
-- -----------------------------------------------------

CREATE TABLE `service_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `question_count` int(11) DEFAULT '0',
  `answer_count` int(11) DEFAULT '0',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `question`
-- -----------------------------------------------------

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` longtext,
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `answer`
-- -----------------------------------------------------

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` longtext  NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `answer_code`
-- -----------------------------------------------------

CREATE TABLE `answer_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext NOT NULL,
  `answer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;