package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.AnswerReply;
import kr.ac.ks.webproject.dto.ServiceUser;

public class ServiceTest {
	public static void main(String[] args) {
		// http://swlock.blogspot.com/2017/01/jericho-htmlparser.html
		/*ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		QuestionService questionService = ac.getBean(QuestionService.class);
		Question q = questionService.getOneQuestion((long) 26);

		String s = q.getContent();
		Source source = new Source(s);
		List<Element> els = source.getAllElements("code");
		System.out.println("size : " + els.size());
		
		for (int i = 0; i < els.size(); i++) {
			Element el = els.get(i);
			System.out.println(el.getName() + " class:" + el.getAttributeValue("class") + " content:" + el.getContent());
			System.out.println("====================================================");
		}*/
		// System.out.println(s);
		
/*		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		QuestionService questionService = ac.getBean(QuestionService.class);
		Question q = questionService.getOneQuestion((long) 18);
		
		System.out.println(q.getAnswerList());
		*/
		/*AnswerService answerService = ac.getBean(AnswerService.class);
		List<Answer> answerList = answerService.getAnswers((long)30);
		
		for(Answer answer : answerList) {
			System.out.print(answer.getContent());
			System.out.println("end!!!");
			System.out.println("============================================================");
		}*/
		/*
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AnswerService answerService = ac.getBean(AnswerService.class);
		
		Answer answer = answerService.getOneAnswer((long)109);
		
		String answerContent = answer.getContent();
		Source source = new Source(answerContent);
		List<Element> codes = source.getAllElementsByClass("cm-s-default");
		System.out.println("size : " + codes.size());
		
		for(int i = 0; i < codes.size(); i++) {
			System.out.print(codes.get(i).getContent().toString());
			System.out.println("end!!!");
			System.out.println("============================================================");
		}*/
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AnswerReplyService answerReplyService = ac.getBean(AnswerReplyService.class);
		
		AnswerReply answerReply = new AnswerReply();
		answerReply.setContent("되라");
		answerReply.setCreateDate(new Date());
	}
}
