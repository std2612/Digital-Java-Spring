package kr.green.springtest2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest2.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(@Param("num") Integer num);
}
