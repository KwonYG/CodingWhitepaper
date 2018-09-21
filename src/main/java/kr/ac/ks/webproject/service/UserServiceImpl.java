package kr.ac.ks.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ks.webproject.dao.UserDao;
import kr.ac.ks.webproject.dto.ServiceUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional(readOnly = false)
	public ServiceUser addUser(ServiceUser user) {
		Long id = userDao.insert(user);
		user.setId(id);
		
		return user;
	}

}
