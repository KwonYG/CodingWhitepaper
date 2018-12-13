package kr.ac.ks.webproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.AnswerCodeService;
import kr.ac.ks.webproject.service.AnswerService;
import kr.ac.ks.webproject.service.QuestionService;
import kr.ac.ks.webproject.service.UserService;
import kr.ac.ks.webproject.utils.HttpSessionUtils;

@Controller
public class QuestionController {

	@Autowired
	UserService userService;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerService answerService;

	@Autowired
	AnswerCodeService answerCodeService;

	// GET 질문 리스트
	@GetMapping(path = "/list")
	public String questionList(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
			ModelMap model) {
		List<Question> questionList = questionService.getQuestions(start);

		int count = questionService.getCount();
		int pageCount = count / questionService.LIMIT;

		if (count % QuestionService.LIMIT > 0)
			pageCount++;

		List<Integer> pageStartList = new ArrayList<>();

		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * QuestionService.LIMIT);
		}

		model.addAttribute("questionList", questionList);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);

		return "list";
	}

	// GET 질문 게시글
	@GetMapping(path = "/question")
	public String getOneQuestion(@RequestParam(name = "id", required = true) Long questionId, ModelMap model) {

		Question question = questionService.getOneQuestion(questionId);
		List<Answer> answerList = answerService.getAnswers(questionId);

		model.addAttribute("question", question);
		model.addAttribute("answerList", answerList);

		return "qnaPage";
	}

	// 질문 Form
	@GetMapping(path = "/qregister")
	public String getRegisterForm(HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		return "questionRegister";
	}

	//질문 POST
	@PostMapping(path = "/writequestion")
	public String postQuestion(@ModelAttribute Question question, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);

		questionService.addQuestion(question, user.getId());

		return "redirect:list";
	}

	//질문 삭제
	@GetMapping(path = "/delete/question")
	public String deleteQuestion(@RequestParam(name = "id", required = true) Long questionId, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		ServiceUser user = HttpSessionUtils.getUserFromSession(session);
		String userServiceId = user.getServiceId();
		Question question = questionService.getOneQuestion(questionId);
		String questionUserId = question.getUserServiceId();

		if (!userServiceId.equals(questionUserId)) {
			System.out.println("글 작성자만 삭제 가능합니다.");
			return "redirect:/question?id=" + questionId;
		}

		questionService.removeQuestion(questionId);

		return "redirect:/list";
	}

	// 질문 수정
	@GetMapping(path = "/update")
	public String getUpdateEditor(@RequestParam(name = "id", required = true) Long questionId, ModelMap model) {
		Question question = questionService.getOneQuestion(questionId);
		model.addAttribute("question", question);

		return "questionUpdate";
	}
	
	@PostMapping(path = "/postUpdate")
	public String postUpdate(@RequestParam(name = "id", required = true) Long questionId, @ModelAttribute Question question) {

		questionService.editQuestionContent(questionId, question.getTitle() ,question.getContent());

		return "redirect:/question?id=" + questionId;
	}

}
