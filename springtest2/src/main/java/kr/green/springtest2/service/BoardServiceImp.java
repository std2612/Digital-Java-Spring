package kr.green.springtest2.service;

import java.util.ArrayList;

import kr.green.springtest2.dao.BoardDao;
import kr.green.springtest2.vo.BoardVo;

public class BoardServiceImp implements BoardService {
	
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardlist() {
		return boardDao.getBoardList();
	}
}
