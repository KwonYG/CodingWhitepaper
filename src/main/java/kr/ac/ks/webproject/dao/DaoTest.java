package kr.ac.ks.webproject.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.AnswerCode;
import kr.ac.ks.webproject.dto.AnswerReply;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		UserDao userDao = ac.getBean(UserDao.class);	
		
		System.out.println(userDao.selectCountUserByServiceId("jkljkl"));
		
/*
		ServiceUser user = new ServiceUser((long) 1, "jkljkl1", "1234", "사람 1", "abc@gmail.com", 321,424, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 2, "jkljkl2", "1234", "사람 1", "abc@gmail.com", 23,4, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 3, "jkljkl3", "1234", "사람 2", "abc@gmail.com", 2212,44, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 4, "jkljkl4", "1234", "사람 3", "abc@gmail.com", 64,43, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 5, "jkljkl5", "1234", "사람 4", "abc@gmail.com", 34,1, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 6, "jkljkl6", "1234", "사람 5", "abc@gmail.com", 31,4534, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 7, "jkljkl7", "1234", "사람 6", "abc@gmail.com", 2,44, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 8, "jkljkl8", "1234", "사람 7", "abc@gmail.com", 71,324, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 9, "jkljkl9", "1234", "사람 8", "abc@gmail.com", 31,824, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 10, "jkljkl10", "1234", "사람 9", "abc@gmail.com", 11,54, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 11, "jkljkl11", "1234", "사람 10", "abc@gmail.com", 32,4, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 12, "jkljkl12", "1234", "사람 11", "abc@gmail.com", 77,46, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 13, "jkljkl13", "1234", "사람 12", "abc@gmail.com", 96,44, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 14, "jkljkl14", "1234", "사람 13", "abc@gmail.com", 21,62, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 15, "jkljkl15", "1234", "사람 14", "abc@gmail.com", 1151,324, new Date());
		userDao.insert(user);
		user = new ServiceUser((long) 16, "jkljkl16", "1234", "사람 15", "abc@gmail.com", 61,174, new Date());
		userDao.insert(user);*/
		
	}
}
