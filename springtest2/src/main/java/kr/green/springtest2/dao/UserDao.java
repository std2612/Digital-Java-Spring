package kr.green.springtest2.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest2.vo.UserVo;

public interface UserDao {

	void insertUser(@Param("user") UserVo user);

	UserVo getUser(@Param("id") String id);

}
