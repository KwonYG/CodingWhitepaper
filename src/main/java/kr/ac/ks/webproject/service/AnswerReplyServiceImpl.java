package kr.ac.ks.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.ks.webproject.dao.AnswerReplyDao;
import kr.ac.ks.webproject.dto.AnswerReply;

@Service
public class AnswerReplyServiceImpl implements AnswerReplyService {
	@Autowired
	AnswerReplyDao answerReplyDao;

	@Override
	public List<AnswerReply> getAllAnswerReplies() {
		return answerReplyDao.selectAllReplies();
	}

	@Override
	public Long addAnswerReply(AnswerReply answerReply) {
		return answerReplyDao.insert(answerReply);
	}

}
