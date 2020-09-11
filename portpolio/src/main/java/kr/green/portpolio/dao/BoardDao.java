package kr.green.portpolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.portpolio.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(@Param("num") Integer num);

}
