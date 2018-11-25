drop table if exists answer_code;
drop table if exists answer;
drop table if exists service_group_answer;
drop table if exists question;
drop table if exists service_group_question;
drop table if exists service_user;
drop table if exists service_group;
drop table if exists topic;
drop table if exists topic_comment;



-- -----------------------------------------------------
-- Table `service_user`
-- -----------------------------------------------------

CREATE TABLE `service_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `question`
-- -----------------------------------------------------

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text,
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `answer`
-- -----------------------------------------------------

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `question_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- -----------------------------------------------------
-- Table `answer_code`
-- -----------------------------------------------------

CREATE TABLE `answer_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `answer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;