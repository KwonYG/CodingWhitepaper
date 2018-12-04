package kr.ac.ks.webproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.ks.webproject.config.HttpSessionUtils;
import kr.ac.ks.webproject.dto.AnswerCode;
import kr.ac.ks.webproject.dto.AnswerReply;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.AnswerCodeService;
import kr.ac.ks.webproject.service.AnswerReplyService;

@RestController
@RequestMapping(path = "/api/answer")
public class AnswerApiController {

	@Autowired
	private AnswerCodeService AnswerCodeService;

	@Autowired
	AnswerReplyService answerReplyService;

	// 코드 리뷰 데이터
	@GetMapping("/reviewCodes/{answerId}")
	public Map<String, Object> getAnswerCodes(@PathVariable(name = "answerId") Long answerId) {
		List<AnswerCode> reviewCodeList = AnswerCodeService.getAnswerCodes(answerId);

		Map<String, Object> map = new HashMap<>();
		map.put("reviewCodes", reviewCodeList);

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
	
	// POST 데이터
	@RequestMapping(value="/writeReply", method = {RequestMethod.GET, RequestMethod.POST})
	public String postReply(@RequestParam(name = "id") long answerId, @ModelAttribute AnswerReply answerReply, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}
		
		ServiceUser user = HttpSessionUtils.getUserFromSession(session);
		answerReplyService.addAnswerReply(answerReply,answerId,user.getId());
		
		return null;
		//return "redirect:review?id=" + answerId;
	}
}
