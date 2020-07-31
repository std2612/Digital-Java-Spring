package kr.green.springtest2.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest2.dao.BoardDao;
import kr.green.springtest2.pagination.Criteria;
import kr.green.springtest2.pagination.PageMaker;
import kr.green.springtest2.vo.BoardVo;
import kr.green.springtest2.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoardlist(Criteria cri) {
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {
		return boardDao.getBoard(num);
	}

	@Override
	public void insertBoard(BoardVo board, HttpServletRequest req) {
		HttpSession ses = req.getSession();
		UserVo user = (UserVo) ses.getAttribute("user");
		if (user == null) {
			return;
		}
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVo board, UserVo user) {
		board.setWriter(user.getId());
		board.setIsDel('N');
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVo board, UserVo user) {
		if (board.getWriter().equals(user.getId())) {
			board.setIsDel('Y');
			board.setDelDate(new Date());
			boardDao.updateBoard(board);
		}
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		PageMaker pm = new PageMaker();
		Integer totalCount = boardDao.getTotalCount(cri);
		pm.setCri(cri);
		pm.setTotalCount(totalCount);
		return pm;
	}

	@Override
	public void increaseViews(BoardVo board) {
		board.setViews(board.getViews() + 1);
		boardDao.updateBoard(board);
	}

}
