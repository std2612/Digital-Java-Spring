package kr.green.springtest2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest2.dao.BoardDao;
import kr.green.springtest2.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardlist() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getBoard(Integer num) {
		return boardDao.getBoard(num);
	}
}
