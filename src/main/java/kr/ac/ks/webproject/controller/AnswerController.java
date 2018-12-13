
package kr.ac.ks.webproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.AnswerReply;
import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.AnswerCodeService;
import kr.ac.ks.webproject.service.AnswerReplyService;
import kr.ac.ks.webproject.service.AnswerService;
import kr.ac.ks.webproject.service.QuestionService;
import kr.ac.ks.webproject.service.UserService;
import kr.ac.ks.webproject.utils.HttpSessionUtils;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

@Controller
public class AnswerController {
	@Autowired
	UserService userService;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerService answerService;

	@Autowired
	AnswerCodeService answerCodeService;

	@Autowired
	AnswerReplyService answerReplyService;

	// GET 답변 작성페이지
	@GetMapping(path = "/aregister")
	public String getRegisterForm(@RequestParam(name = "id", required = true) int questionId, Model model,
			HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		// 질문에서 코드 가져오는 로직
		Question q = questionService.getOneQuestion((long) questionId);

		String questionContent = q.getContent();
		Source source = new Source(questionContent);
		List<Element> codes = source.getAllElements("code");
		System.out.println("size : " + codes.size());

		model.addAttribute("codes", codes);
		model.addAttribute("codeCount", codes.size());

		return "answerRegister";
	}

	// 답변 POST
	@PostMapping(path = "/writeanswer")
	public String postAnswer(@RequestParam(name = "id") int questionId, @ModelAttribute Answer answer,
			HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);

		Answer tempAnswer = answerService.addAnswer(answer, (long) questionId, user.getId());

		// 질문 콘텐트에 있는 코드들을 파싱해서 answerCode에 집어넣는다.
		String answerContent = tempAnswer.getContent();
		Source source = new Source(answerContent);
		List<Element> codes = source.getAllElementsByClass("cm-s-default");
		System.out.println("size : " + codes.size());

		for (int i = 0; i < codes.size(); i++) {
			answerCodeService.addAnswerCode(codes.get(i).toString(), tempAnswer.getId());
		}

		System.out.println(tempAnswer.getContent());
		System.out.println(answerContent);
		userService.plusAnswerCount(user.getId());

		return "redirect:question?id=" + questionId;
	}

	@GetMapping(path = "/delete/answer")
	public String deleteQuestion(@RequestParam(name = "id", required = true) Long answerId, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);
		String userServiceId = user.getServiceId();
		Answer answer = answerService.getOneAnswer(answerId);
		String answerUserId = answer.getServiceId();

		if (!userServiceId.equals(answerUserId)) {
			System.out.println("글 작성자만 삭제 가능합니다.");
			return "redirect:/question?id=" + answer.getQuestionId();
		}

		answerService.removeAnswer(answerId);

		return "redirect:/question?id=" + answer.getQuestionId();
	}

	// GET 리뷰 페이지
	@GetMapping(path = "/review")
	public String getReviewPage(@RequestParam(name = "id") Long answerId) {
		return "reviewPage";
	}

	// POST 리뷰 댓글
	@PostMapping(path = "/writeReply")
	public String postReviewReply(@RequestParam(name = "id") long answerId, @ModelAttribute AnswerReply answerReply,
			HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);
		answerReplyService.addAnswerReply(answerReply, answerId, user.getId());

		return "redirect:review?id=" + answerId;
	}
}
