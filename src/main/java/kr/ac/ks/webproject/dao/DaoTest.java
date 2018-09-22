package kr.ac.ks.webproject.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.ac.ks.webproject.config.ApplicationConfig;
import kr.ac.ks.webproject.dto.Answer;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AnswerDao answerDao = ac.getBean(AnswerDao.class);
		QuestionDao questionDao = ac.getBean(QuestionDao.class);
		
		System.out.println(questionDao.selectCount());
		
		/*Answer answer = new Answer();
		
		answer.setUserName("정영훈");
		answer.setUserEmail("yh@naver.com");
		answer.setContent("이렇게 고치세요");
		answer.setQuestionId(4);
		answer.setCreateDate(new Date());
		
		Long id = answerDao.insert(answer);
		System.out.println(id);*/
		
		
		/*List<Answer> list = answerDao.selectAnswers(3);
		
		for(Answer answers : list) {
			System.out.println(answers);
		}*/
		
		
		
		/*List<Question> list = questionDao.selectAll(0, 5);
		
		for(Question question : list) {
			System.out.println(question);
		}*/
		
		/*Question question = questionDao.selectQeustionById(3);
		
		System.out.println(question);	//현재 question dto에 이름에 대한 필드이 존재 x	*/
		
		/*Question question = new Question();
		question.setTitle("나도 답변 달아줘요");
		question.setContent("가르쳐주세요");
		question.setCreateDate(new Date());
		question.setUserId(4);
		Long id = questionDao.insert(question); // 외래키 존재함. 
		System.out.println("id : " + id);
		*/
		/*UserDao userDao = ac.getBean(UserDao.class);
		
		ServiceUser user = new ServiceUser();
		
		user.setName("영근");
		user.setEmail("yg@gmail.com");
		user.setCreateDate(new Date());
		Long id = userDao.insert(user);
		
		System.out.println(id);*/
	}
}
