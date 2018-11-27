package kr.ac.ks.webproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.ks.webproject.config.HttpSessionUtils;
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
	public String login(String serviceId, String password, HttpSession session, RedirectAttributes redirectAttr) {
		ServiceUser user = userService.getOneUser(serviceId);

		if (user == null) {
			redirectAttr.addFlashAttribute("failMessage", "아이가 존재하지 않습니다.");
			System.out.println("존재하지 않는 아이디");
			return "redirect:/loginForm";
		}

		if (!user.isMatchPassword(password)) {
			redirectAttr.addFlashAttribute("failMessage", "암호가 틀렸습니다.");
			System.out.println("비밀번호 틀림");
			return "redirect:/loginForm";
		}

		System.out.println("로그인 성공!");

		session.setAttribute(HttpSessionUtils.USER_LOGIN_STATUS, "true");
		//여기에 setAttribute로 유저 정보 저장해보기
		session.setAttribute(HttpSessionUtils.USER_SESSION_KEY,user);

		return "redirect:/list";
	}

	@GetMapping("/logOut")
	public String logout(HttpSession session) {
		session.removeAttribute(HttpSessionUtils.USER_LOGIN_STATUS);
		session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
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
