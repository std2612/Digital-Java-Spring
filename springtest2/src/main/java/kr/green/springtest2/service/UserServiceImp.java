package kr.green.springtest2.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest2.dao.UserDao;
import kr.green.springtest2.vo.UserVo;

@Service
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
		// 비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);

		userDao.insertUser(user);
		return true;
	}

	@Override
	public UserVo signinUser(UserVo user) {
		UserVo signinUser = userDao.getUser(user.getId());
		if (signinUser != null && passwordEncoder.matches(user.getPw(), signinUser.getPw())) {
			return signinUser;
		} else {
			return null;
		}
	}

	@Override
	public UserVo getUser(HttpServletRequest req) {
		return (UserVo)req.getSession().getAttribute("user");
	}

}
