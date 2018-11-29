package kr.ac.ks.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.UserService;

@Controller
public class RankingController {
	@Autowired
	UserService userService;

	@GetMapping(path = "/rank")
	public String getRanking(ModelMap model) {

		// 1위
		ServiceUser winner = userService.getUserByAnswerCount(0, 1).get(0);

		// 2~3위
		List<ServiceUser> secondToThird = userService.getUserByAnswerCount(1, 2);

		// 3~10위
		List<ServiceUser> restRankers = userService.getUserByAnswerCount(3, 7);

		model.addAttribute("winner", winner);
		model.addAttribute("secondToThird", secondToThird);
		model.addAttribute("restRankers", restRankers);

		return "rankingPage";
	}
}
