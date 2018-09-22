package kr.ac.ks.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.service.AnswerService;

@Controller
public class AnswerController {
	@Autowired
	AnswerService answerService;

	@GetMapping(path = "/aregister")
	public String getRegisterForm(@RequestParam(name = "id", required = true) int questionId) {
		return "answerRegister";
	}

	@PostMapping(path = "/writeanswer")
	public String postAnswer(@RequestParam(name = "id") int questionId, @ModelAttribute Answer answer) {
		answerService.addAnswer(answer, (long) questionId);
		return "redirect:question?id=" + questionId;
	}
}
