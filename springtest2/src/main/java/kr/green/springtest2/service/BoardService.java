package kr.green.springtest2.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest2.pagination.Criteria;
import kr.green.springtest2.pagination.PageMaker;
import kr.green.springtest2.vo.BoardVo;
import kr.green.springtest2.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardlist(Criteria cri);

	BoardVo getBoard(Integer num);

	void insertBoard(BoardVo board, HttpServletRequest req);

	void updateBoard(BoardVo board, UserVo userVo);

	void deleteBoard(BoardVo board, UserVo userVo);

	PageMaker getPageMaker(Criteria cri);

	void increaseViews(BoardVo board);
	
}
