package kr.ac.ks.webproject.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.Question;

public class ServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		QuestionService questionService = ac.getBean(QuestionService.class);
		
		/*Question question = questionService.getOneQuestion(3);
		
		System.out.println(question);*/
		
		List<Question> list = questionService.getQuestions(0);
		
		for(Question question : list) {
			System.out.println(question);
		}
	}
}
