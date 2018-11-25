package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ks.webproject.dao.AnswerDao;
import kr.ac.ks.webproject.dao.QuestionDao;
import kr.ac.ks.webproject.dto.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;

	@Autowired
	AnswerDao answerDao;

	@Override
	@Transactional
	public List<Question> getQuestions(Integer start) {
		List<Question> questionList = questionDao.selectAll(start, QuestionService.LIMIT);
		return questionList;
	}

	//여기 메소드를 참고해서 답변별 코드 내용 출력 작성
	@Override
	@Transactional
	public Question getOneQuestion(Long questionId) {
		Question question = questionDao.selectQeustionById(questionId);
		question.setAnswerList(answerDao.selectAnswers(questionId));

		return question;
	}

	@Override
	@Transactional
	public Question addQuestion(Question question, Long userId) {
		question.setCreateDate(new Date());
		question.setUserId(userId);
		Long id = questionDao.insert(question);
		question.setId(id);

		return question;
	}
	
	@Override
	public int getCount() {
		return questionDao.selectCount();
	}

}
