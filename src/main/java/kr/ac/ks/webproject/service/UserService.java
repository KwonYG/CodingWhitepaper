package kr.ac.ks.webproject.service;

import kr.ac.ks.webproject.dto.ServiceUser;

public interface UserService {
	public ServiceUser addUser(ServiceUser user);
	public int removeUser(Long userId);
	public ServiceUser getOneUserByUserId(Long userId);
	public ServiceUser getOneUserByServiceId(String serviceId);
	public int plusQuestionCount(long userId);
	public int plusAnswerCount(long userId);
}
