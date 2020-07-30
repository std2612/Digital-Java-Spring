package kr.green.springtest2.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.green.springtest2.dao.UserDao;
import kr.green.springtest2.vo.UserVo;

public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean insertUser(UserVo user) {
		userDao.insertUser(user);
		
		return true;
	}

}
