package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ks.webproject.dao.AnswerDao;
import kr.ac.ks.webproject.dto.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerDao answerDao;

	@Override
	public List<Answer> getAnswers(Long questionId) {
		return answerDao.selectAnswers(questionId);
	}

	@Override
	@Transactional(readOnly = false)
	public Answer addAnswer(Answer answer, Long questionId) {
		answer.setCreateDate(new Date());
		answer.setQuestionId(questionId);
		Long id = answerDao.insert(answer);
		answer.setId(id);

		return answer;
	}

}
