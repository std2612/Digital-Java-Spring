package kr.green.springtest2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.green.springtest2.dao.UserDao;
import kr.green.springtest2.vo.UserVo;

public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean insertUser(UserVo user) {
		if (user == null || userDao.getUser(user.getId()) != null || user.getId().length() == 0 || user.getPw() == null
				|| user.getPw().length() == 0 || user.getEmail() == null || user.getEmail().length() == 0
				|| !user.getEmail().contains("@") || user.getGender() == null || user.getGender().length() == 0) {
			return false;
		}
		user.setAuth("USER");
		user.setIsDel("N");
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);

		userDao.insertUser(user);
		return true;
	}

}
