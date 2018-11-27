package kr.ac.ks.webproject.config;

import javax.servlet.http.HttpSession;

import kr.ac.ks.webproject.dto.ServiceUser;

public class HttpSessionUtils {
	public static final String USER_LOGIN_STATUS = "isUser";
	public static final String USER_SESSION_KEY = "user";

	public static boolean isLoginUser(HttpSession session) {
		Object sessionedUser = session.getAttribute(USER_LOGIN_STATUS);

		if (sessionedUser == null) {
			return false;
		}
		return true;
	}

	public static ServiceUser getUserFromSession(HttpSession session) {
		if (!isLoginUser(session)) {
			return null;
		}
		System.out.println((ServiceUser)session.getAttribute(USER_SESSION_KEY));
		return (ServiceUser)session.getAttribute(USER_SESSION_KEY);
	}
}
