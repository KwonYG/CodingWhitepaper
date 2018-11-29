package kr.ac.ks.webproject.service;

import java.util.Date;

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
		user.setCreateDate(new Date());
		Long id = userDao.insert(user);
		user.setId(id);

		return user;
	}

	@Override
	@Transactional
	public int removeUser(Long userId) {
		int deleteCount = userDao.deleteById(userId);
		return deleteCount;
	}

	@Override
	public ServiceUser getOneUserByUserId(Long userId) {
		return userDao.selectOneUserByUserId(userId);
	}

	@Override
	public ServiceUser getOneUserByServiceId(String serviceId) {
		return userDao.selectOneUserByServiceId(serviceId);
	}

	@Override
	@Transactional
	public int plusQuestionCount(ServiceUser user) {
		int questionCount = user.getQuestionCount();
		user.setQuestionCount(questionCount + 1);
		userDao.deleteById(user.getId());
		userDao.insert(user);
		return 1;
	}

	@Override
	public int plusAnswerCount(ServiceUser user) {
		int answerCount = user.getAnswerCount();
		user.setAnswerCount(answerCount + 1);
		userDao.deleteById(user.getId());
		userDao.insert(user);
		return 1;
	}

}
