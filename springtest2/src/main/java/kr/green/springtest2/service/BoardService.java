package kr.green.springtest2.service;

import java.util.ArrayList;

import kr.green.springtest2.pagination.Criteria;
import kr.green.springtest2.pagination.PageMaker;
import kr.green.springtest2.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardlist(Criteria cri);

	BoardVo getBoard(Integer num);

	void insertBoard(BoardVo board);

	void updateBoard(BoardVo board);

	void deleteBoard(BoardVo board);

	PageMaker getPageMaker(Criteria cri);

	void increaseViews(BoardVo board);
	
}
