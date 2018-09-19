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
		
		Answer answer = new Answer();
		
		answer.setUserName("정영훈");
		answer.setUserEmail("yh@gmail.com");
		answer.setContent("그거 이렇게 하면 됩니다.");
		answer.setQuestionId(3);
		answer.setCreateDate(new Date());
		
		Long id = answerDao.insert(answer);
		System.out.println(id);
		
		/*QuestionDao questionDao = ac.getBean(QuestionDao.class);
		
		List<Question> list = questionDao.selectAll(0, 5);
		
		for(Question question : list) {
			System.out.println(question);
		}*/
		
		/*Question question = questionDao.selectQeustionById(3);
		
		System.out.println(question);	//현재 question dto에 이름에 대한 필드이 존재 x	*/
		
		/*Question question = new Question();
		question.setTitle("이거 어떻게 해결하죠");
		question.setContent("가르쳐주세요");
		question.setCreateDate(new Date());
		question.setUserId(2);
		Long id = questionDao.insert(question); // 외래키 존재함. 
		System.out.println("id : " + id);*/
		
		/*UserDao userDao = ac.getBean(UserDao.class);
		
		ServiceUser user = new ServiceUser();
		
		user.setName("선혜");
		user.setEmail("sh@naver.com");
		user.setCreateDate(new Date());
		Long id = userDao.insert(user);
		
		System.out.println(id);*/
	}
}
