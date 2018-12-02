package kr.ac.ks.webproject.service;

import java.util.List;

import kr.ac.ks.webproject.dto.AnswerReply;

public interface AnswerReplyService {
	public List<AnswerReply> getAllAnswerReplies(Long answerId);
	public AnswerReply addAnswerReply(AnswerReply answerReply,Long answerId ,Long userId);
}
