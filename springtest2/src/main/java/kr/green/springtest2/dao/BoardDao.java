package kr.green.springtest2.dao;

import java.util.ArrayList;

import kr.green.springtest2.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();
}
