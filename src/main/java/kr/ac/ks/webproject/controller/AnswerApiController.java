package kr.ac.ks.webproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.ks.webproject.config.HttpSessionUtils;
import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.AnswerCode;
import kr.ac.ks.webproject.dto.AnswerReply;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.AnswerCodeService;
import kr.ac.ks.webproject.service.AnswerReplyService;
import kr.ac.ks.webproject.service.AnswerService;

@RestController
@RequestMapping(path = "/api/answer")
public class AnswerApiController {
	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerCodeService AnswerCodeService;

	@Autowired
	AnswerReplyService answerReplyService;

	// 코드 리뷰 데이터
	@GetMapping("/reviewCodes/{answerId}")
	public Map<String, Object> getAnswerCodes(@PathVariable(name = "answerId") Long answerId) {
		List<AnswerCode> reviewCodeList = AnswerCodeService.getAnswerCodes(answerId);
		Answer answer = answerService.getOneAnswer(answerId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("reviewCodes", reviewCodeList);
		map.put("answer", answer);

		return map;
	}

	// 댓글 데이터
	@GetMapping("/replies/{answerId}")
	public Map<String, Object> getAnswerReplies(@PathVariable(name = "answerId") Long answerId) {
		List<AnswerReply> answerReplyList = answerReplyService.getAllAnswerReplies(answerId);

		Map<String, Object> map = new HashMap<>();
		map.put("answerReplies", answerReplyList);
		map.put("answerId", answerId);

		return map;
	}
	
	// POST 댓글 데이터
	@PostMapping(path = "/writeReply")
	public AnswerReply postReviewReply(@RequestParam(name = "id") long answerId, @ModelAttribute AnswerReply answerReply,
			HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return null;
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);
		return answerReplyService.addAnswerReply(answerReply, answerId, user.getId());
	}
}
