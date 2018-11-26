package kr.ac.ks.webproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/joinForm")
	public String getJoinForm() {
		return "joinForm";
	}
	
	@PostMapping("/login")
	public String login(String serviceId, String password, HttpSession session) {
		ServiceUser user = userService.getOneUser(serviceId);
		
		if(user == null) {
			System.out.println("존재하지 않는 아이디");
			return "redirect:/loginForm";
		}
		
		if(!password.equals(user.getPassword())) {
			System.out.println("비밀번호 틀림");
			return "redirect:/loginForm";
		}
		
		System.out.println("로그인 성공!");
		
		session.setAttribute("isUser", "true");
		
		return "redirect:/list";
	}
	
	@GetMapping("/logOut")
	public String logout(HttpSession session) {
		session.removeAttribute("isUser");
		return "redirect:/list";
	}
	
	@GetMapping("/loginForm")
	public String getLoginForm() {
		return "loginForm"; 
	}
	
	@PostMapping("/join")
	public String postJoin(@ModelAttribute ServiceUser user) {
		userService.addUser(user);
		return "redirect:/list";
	}
	
}
