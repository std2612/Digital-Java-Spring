package kr.green.springtest2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest2.pagination.Criteria;
import kr.green.springtest2.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri") Criteria cri);

	BoardVo getBoard(@Param("num") Integer num);

	void insertBoard(@Param("board") BoardVo board);

	void updateBoard(@Param("board") BoardVo board);

	Integer getTotalCount(@Param("cri") Criteria cri);

}
