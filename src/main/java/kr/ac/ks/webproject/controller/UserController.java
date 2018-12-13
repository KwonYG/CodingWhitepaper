package kr.ac.ks.webproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.ks.webproject.dto.ServiceUser;
import kr.ac.ks.webproject.service.UserService;
import kr.ac.ks.webproject.utils.HttpSessionUtils;
import kr.ac.ks.webproject.utils.SecurityUtils;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	// 회원가입 Form
	@GetMapping("/joinForm")
	public String getJoinForm() {
		return "joinForm";
	}
	
	// POST 회원
	@PostMapping("/join")
	public String postJoin(@ModelAttribute ServiceUser user, RedirectAttributes redirectAttr) {
		if (userService.getOneUserByServiceId(user.getServiceId()) != null) {
			redirectAttr.addFlashAttribute("failMessage", "이미 존재하는 아이디 입니다.");
			return "redirect:/loginForm";
		}

		String pw = user.getPassword();
		user.setPassword(SecurityUtils.encryptSHA256(pw));
		userService.addUser(user);
		return "redirect:/list";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(path = "/idCheck", method = RequestMethod.POST)
	public int postIdCheck(@RequestParam(name = "serviceid", required = true) String serviceId, ModelMap model){
		int result = 0; // 중복 O, 사용 불가

		if (userService.getOneUserByServiceId(serviceId) != null) {
			result = 1; // 1이면 중복 x, 사용가능
		}

		return result;
	}

	// 로그인 POST
	@PostMapping("/login")
	public String login(String serviceId, String password, HttpSession session, RedirectAttributes redirectAttr) {
		ServiceUser user = userService.getOneUserByServiceId(serviceId);

		if (user == null) {
			redirectAttr.addFlashAttribute("failMessage", "아이디가 존재하지 않습니다.");
			return "redirect:/loginForm";
		}

		if (!user.isMatchPassword(SecurityUtils.encryptSHA256(password))) {
			redirectAttr.addFlashAttribute("failMessage", "암호가 틀렸습니다.");
			return "redirect:/loginForm";
		}

		session.setAttribute(HttpSessionUtils.USER_LOGIN_STATUS, "true");
		session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
		session.setAttribute(HttpSessionUtils.USER_SESSION_ID_KEY, user.getServiceId());

		return "redirect:/list";
	}

	@GetMapping("/logOut")
	public String logout(HttpSession session) {
		session.removeAttribute(HttpSessionUtils.USER_LOGIN_STATUS);
		session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
		session.removeAttribute(HttpSessionUtils.USER_SESSION_ID_KEY);

		return "redirect:/list";
	}

	@GetMapping("/loginForm")
	public String getLoginForm() {
		return "loginForm";
	}

}
