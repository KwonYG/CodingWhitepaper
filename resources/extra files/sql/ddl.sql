drop table if exists code;
drop table if exists answer;
drop table if exists service_group_answer;
drop table if exists question;
drop table if exists service_group_question;
drop table if exists service_user;
drop table if exists service_group;
drop table if exists topic;
drop table if exists topic_comment;

/*바꿀 DB*/

-- -----------------------------------------------------
-- Table `service_group`
-- -----------------------------------------------------

CREATE TABLE `service_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `service_user`
-- -----------------------------------------------------

CREATE TABLE `service_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_service_id` varchar(50) NOT NULL,
  `user_service_password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `service_group_id` int(11) DEFAULT '0',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`service_group_id`) REFERENCES `service_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `code`
-- -----------------------------------------------------

CREATE TABLE `code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table `service_group_question`
-- -----------------------------------------------------

CREATE TABLE `service_group_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text,
  `service_group_id` int(11) NOT NULL, 
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`),
  FOREIGN KEY (`service_group_id`) REFERENCES `service_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `answer`
-- -----------------------------------------------------

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  /*`user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,*/
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`) ,
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- -----------------------------------------------------
-- Table `service_group_answer`
-- -----------------------------------------------------

CREATE TABLE `service_group_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `service_group_question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  /*`user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,*/
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `service_user` (`id`) ,
  FOREIGN KEY (`service_group_question_id`) REFERENCES `service_group_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


/*
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `like_count` int(255) NOT NULL DEFAULT '0',
  `dislike_count` int(255) NOT NULL DEFAULT '0',
  `user_name` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topic_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `agree_flag` int(1) NOT NULL DEFAULT '1',
  `topic_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_ibfk_1_idx` (`topic_id`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
