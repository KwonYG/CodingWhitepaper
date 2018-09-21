package kr.ac.ks.webproject.service;

import java.util.List;

import kr.ac.ks.webproject.dto.Question;

public interface QuestionService {
	public static final Integer LIMIT = 5;
	public List<Question> getQuestions(Integer start);
	public Question getOneQuestion(Integer questionId);
	public Question addQuestion(Question question);
}
