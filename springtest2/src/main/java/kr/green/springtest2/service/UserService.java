package kr.green.springtest2.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest2.vo.UserVo;

public interface UserService {

	boolean insertUser(UserVo user);

	UserVo signinUser(UserVo user);

	UserVo getUser(HttpServletRequest req);

}
