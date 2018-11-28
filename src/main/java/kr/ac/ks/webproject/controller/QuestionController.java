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

import kr.ac.ks.webproject.config.HttpSessionUtils;
import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.AnswerCode;
import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.AnswerCodeService;
import kr.ac.ks.webproject.service.AnswerService;
import kr.ac.ks.webproject.service.QuestionService;
import kr.ac.ks.webproject.service.UserService;

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

	@GetMapping(path = "/question")
	public String getOneQuestion(@RequestParam(name = "id", required = true) Long questionId, ModelMap model) {

		Question question = questionService.getOneQuestion(questionId);
		List<Answer> answerList = answerService.getAnswers(questionId);
		
		//answer ID를 가져올 방안 모색
		//List<AnswerCode> codeList = answerCodeService.getAnswerCodes()

		model.addAttribute("question", question);
		model.addAttribute("answerList", answerList);

		return "qnaPage2";
	}

	@GetMapping(path = "/qregister")
	public String getRegisterForm(HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}

		return "questionRegister";
	}

	@PostMapping(path = "/writequestion")
	public String postQuestion(@ModelAttribute Question question, HttpSession session) {
		/* String clientIp = request.getRemoteAddr(); */
		// ip 뽑아오는 코드, 사용여부는 의논
		// user 부분 현재 DB 다시 고민
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "loginForm";
		}
		
		ServiceUser user = HttpSessionUtils.getUserFromSession(session);

		questionService.addQuestion(question, user.getId());

		return "redirect:list";
	}

	@GetMapping(path = "/update") // 수정기능, 미완
	public String getUpdateEditor(@RequestParam(name = "id", required = true) Long questionId, ModelMap model) {
		Question question = questionService.getOneQuestion(questionId);
		model.addAttribute("question", question);

		return "questionUpdate";
	}

}
