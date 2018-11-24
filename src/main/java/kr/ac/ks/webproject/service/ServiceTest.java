package kr.ac.ks.webproject.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.Question;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

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
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		/*QuestionService questionService = ac.getBean(QuestionService.class);
		Question q = questionService.getOneQuestion((long) 6);
		
		System.out.println(q);*/
		
		AnswerService answerService = ac.getBean(AnswerService.class);
		List<Answer> answerList = answerService.getAnswers((long)30);
		
		for(Answer answer : answerList) {
			System.out.print(answer.getContent());
			System.out.println("end!!!");
			System.out.println("============================================================");
		}
	}
}
