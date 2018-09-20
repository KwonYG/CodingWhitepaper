package kr.ac.ks.webproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.service.QuestionService;

@Controller
public class QuestionContorller {
	@Autowired
	QuestionService questionService;
	
	@GetMapping(path="/list")
	public String quetionList(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model) {
		List<Question> questionList = questionService.getQuestions(start);
		
		model.addAttribute("questionList",questionList);
		
		return "mainpage";
	}

}
