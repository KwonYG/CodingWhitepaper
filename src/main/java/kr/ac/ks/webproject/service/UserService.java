package kr.ac.ks.webproject.service;

import kr.ac.ks.webproject.dto.ServiceUser;

public interface UserService {
	public ServiceUser addUser(ServiceUser user);
	public ServiceUser getOneUser(String serviceId);
}
