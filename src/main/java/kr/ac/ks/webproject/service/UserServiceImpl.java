package kr.ac.ks.webproject.service;

import java.util.Date;
import java.util.List;

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
	public int plusQuestionCount(long userId) {
		int questionCount = userDao.selectOneUserByUserId(userId).getQuestionCount();
		userDao.updateQuestionCountById(userId, questionCount + 1);

		return 1;
	}

	@Override
	@Transactional
	public int plusAnswerCount(long userId) {
		int answerCount = userDao.selectOneUserByUserId(userId).getAnswerCount();
		userDao.updateAnswerCountById(userId, answerCount + 1);

		return 1;
	}

	@Override
	public List<ServiceUser> getUserByQuestionCount(int start, int limit) {
		return userDao.selectAllByQuestionCount(start, limit);
	}

	@Override
	public List<ServiceUser> getUserByAnswerCount(int start, int limit) {
		return userDao.selectAllByAnswerCount(start, limit);
	}

}
