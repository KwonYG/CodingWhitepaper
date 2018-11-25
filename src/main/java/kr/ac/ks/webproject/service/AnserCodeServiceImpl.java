package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.ks.webproject.dao.AnswerCodeDao;
import kr.ac.ks.webproject.dao.AnswerDao;
import kr.ac.ks.webproject.dto.AnswerCode;

public class AnserCodeServiceImpl implements AnswerCodeService {

	@Autowired
	AnswerDao answerDao;
	
	@Autowired
	AnswerCodeDao answerCodeDao;
	
	@Override
	public List<AnswerCode> getAnswerCodes(Long answerId) {
		List<AnswerCode> codeList = answerCodeDao.selectAnswerCodes(answerId);
		
		return codeList;
	}

	//여기까지함
	@Override
	public AnswerCode addAnswerCode(AnswerCode answerCode, Long answerId) {
		
		answerCode.setAnswerId(answerId);
		Long id = answerCodeDao.insert(answerCode);
		answerCode.setId(id);

		return answerCode;
		
	}

}
