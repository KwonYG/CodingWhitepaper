package kr.ac.ks.webproject.service;

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

	@Override
	public Question getOneQuestion(Integer questionId) {
		Question question = questionDao.selectQeustionById(questionId);
		question.setAnswerList(answerDao.selectAnswers(questionId));
		
		return question;
	}

}
