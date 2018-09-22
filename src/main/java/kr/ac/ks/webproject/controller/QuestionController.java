package kr.ac.ks.webproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.ks.webproject.dto.Question;
import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.QuestionService;
import kr.ac.ks.webproject.service.UserService;

@Controller
public class QuestionController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping(path="/list")
	public String questionList(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model) {
		List<Question> questionList = questionService.getQuestions(start);
		
		int count = questionService.getCount();
		int pageCount = count / questionService.LIMIT;
		
		if(count % QuestionService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i*QuestionService.LIMIT);
		}
		
		model.addAttribute("questionList",questionList);
		model.addAttribute("count",count);
		model.addAttribute("pageStartList",pageStartList);
		
		return "list";
	}
	
	@GetMapping(path="/question")
	public String getOneQuestion(@RequestParam(name = "id", required = true) Long questionId, Model model) {
		
		Question question = questionService.getOneQuestion(questionId);
		model.addAttribute("question",question);
		
		return "qnaPage";
	}
	
	@GetMapping(path="/qregister")
	public String getRegisterForm() {
		return "questionRegister";
	}
	
	@PostMapping(path = "/write")
    public String write(@ModelAttribute Question question, @ModelAttribute ServiceUser user, HttpServletRequest request) {
        /*String clientIp = request.getRemoteAddr();*/ //ip 뽑아오는 코드, 사용여부는 의논 
        //user 서비스에서 생성 로직을 구현해야함, 현재 DB 다시 고민
		
		userService.addUser(user);
		question.setUserId(user.getId());
		questionService.addQuestion(question);
		
        return "redirect:list";
    }


}
