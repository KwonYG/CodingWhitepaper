package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ks.webproject.dao.AnswerCodeDao;
import kr.ac.ks.webproject.dao.AnswerDao;
import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.AnswerCode;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerDao answerDao;

	@Autowired
	AnswerCodeDao answerCodeDao;

	@Override
	public List<Answer> getAnswers(Long questionId) {
		return answerDao.selectAnswers(questionId);
	}

	@Override
	public Answer getOneAnswer(Long answerId) {
		Answer answer = answerDao.selectOneAnswer(answerId);
		List<AnswerCode> codeList = answerCodeDao.selectAnswerCodes(answerId);
		answer.setCodeList(codeList);

		return answer;
	}

	@Override
	@Transactional(readOnly = false)
	public Answer addAnswer(Answer answer, Long questionId, Long userId) {
		answer.setCreateDate(new Date());
		answer.setQuestionId(questionId);
		answer.setUserId(userId);
		Long id = answerDao.insert(answer);
		answer.setId(id);

		return answer;
	}

}
