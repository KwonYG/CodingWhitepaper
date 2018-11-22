package kr.ac.ks.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Answer;
import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.service.AnswerService;
import kr.ac.ks.webproject.service.QuestionService;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

@Controller
public class AnswerController {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;

	@GetMapping(path = "/aregister")
	public String getRegisterForm(@RequestParam(name = "id", required = true) int questionId, Model model) {
		
		Question q = questionService.getOneQuestion((long) questionId);

		String questionContent = q.getContent();
		Source source = new Source(questionContent);
		List<Element> codes = source.getAllElements("code");
		System.out.println("size : " + codes.size());
		
		model.addAttribute("codes", codes);
		model.addAttribute("codeCount", codes.size());
	
		return "answerRegister";
	}

	@PostMapping(path = "/writeanswer")
	public String postAnswer(@RequestParam(name = "id") int questionId, @ModelAttribute Answer answer) {
		answerService.addAnswer(answer, (long) questionId);
		return "redirect:question?id=" + questionId;
	}
}
