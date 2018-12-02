package kr.ac.ks.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ks.webproject.dao.AnswerCodeDao;
import kr.ac.ks.webproject.dao.AnswerDao;
import kr.ac.ks.webproject.dto.AnswerCode;

@Service
public class AnswerCodeServiceImpl implements AnswerCodeService {

	@Autowired
	AnswerDao answerDao;

	@Autowired
	AnswerCodeDao answerCodeDao;

	@Override
	public List<AnswerCode> getAnswerCodes(Long answerId) {
		List<AnswerCode> codeList = answerCodeDao.selectAnswerCodes(answerId);

		return codeList;
	}

	// 여기까지함
	@Override
	@Transactional
	public AnswerCode addAnswerCode(String answerCodeContent, Long answerId) {
		AnswerCode answerCode = new AnswerCode();
		answerCode.setAnswerId(answerId);
		answerCode.setContent(answerCodeContent);
		Long id = answerCodeDao.insert(answerCode);
		answerCode.setId(id);

		return answerCode;
	}

}
