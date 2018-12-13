package kr.ac.ks.webproject.service;

import java.util.List;

import kr.ac.ks.webproject.dto.AnswerCode;

public interface AnswerCodeService {
	public List<AnswerCode> getAnswerCodes(Long answerId);
	public AnswerCode addAnswerCode(String answerCodeContent, Long answerId);
}
