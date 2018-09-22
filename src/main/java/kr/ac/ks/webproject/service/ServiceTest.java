package kr.ac.ks.webproject.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.Answer;

public class ServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		QuestionService questionService = ac.getBean(QuestionService.class);
		AnswerService answerService = ac.getBean(AnswerService.class);
		
		List<Answer> list = answerService.getAnswers((long)3);
		
		for(Answer answer : list) {
			System.out.println(answer);
		}
		/*Question question = new Question();
		question.setTitle("헬프미");
		question.setContent("아 이거 구현 안되요 ㅡㅡ");
		question.setCreateDate(new Date());
		question.setUserId((long)2);
		
		Question result = questionService.addQuestion(question);
		System.out.println(result);*/
	}
}
