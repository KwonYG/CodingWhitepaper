package kr.ac.ks.webproject.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;

public class ServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		QuestionService questionService = ac.getBean(QuestionService.class);
		
		System.out.println(questionService.getCount());
		
		/*Question question = new Question();
		question.setTitle("헬프미");
		question.setContent("아 이거 구현 안되요 ㅡㅡ");
		question.setCreateDate(new Date());
		question.setUserId((long)2);
		
		Question result = questionService.addQuestion(question);
		System.out.println(result);*/
	}
}
