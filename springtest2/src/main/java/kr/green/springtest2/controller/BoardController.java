package kr.green.springtest2.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest2.pagination.Criteria;
import kr.green.springtest2.pagination.PageMaker;
import kr.green.springtest2.service.BoardService;
import kr.green.springtest2.service.UserService;
import kr.green.springtest2.vo.BoardVo;
import kr.green.springtest2.vo.UserVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView BoardGet(ModelAndView mv, Criteria cri) {
		logger.info("URI:/board/list:GET");
		mv.setViewName("/board/list");

		ArrayList<BoardVo> list = boardService.getBoardlist(cri);
		PageMaker pm = boardService.getPageMaker(cri);

		mv.addObject("list", list);
		mv.addObject("pm", pm);

		return mv;
	}

	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
		logger.info("URI:/board/detail:GET");
		mv.setViewName("/board/detail");

		BoardVo board = boardService.getBoard(num);

		boardService.increaseViews(board);
		mv.addObject("board", board);

		return mv;
	}

	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {
		logger.info("URI:/board/register:GET");
		mv.setViewName("/board/register");

		return mv;
	}

	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVo board, HttpServletRequest req) {
		logger.info("URI:/board/register:GET");
		mv.setViewName("redirect:/board/list");

		boardService.insertBoard(board, req);

		return mv;
	}

	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer num, HttpServletRequest req) {
		logger.info("URI:/board/modify:GET");
		mv.setViewName("/board/modify");

		BoardVo board = boardService.getBoard(num);
		UserVo user = userService.getUser(req);
		
		if (user == null || !board.getWriter().equals(user.getId())) {
			mv.setViewName("redirect:/board/list");
		}
		
		mv.addObject("board", board);

		return mv;
	}

	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVo board, HttpServletRequest req) {
		logger.info("URI:/board/modify:POST");
		mv.setViewName("redirect:/board/list");

		boardService.updateBoard(board, userService.getUser(req));

		return mv;
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView deleteGet(ModelAndView mv, Integer num) {
		logger.info("URI:/board/delete:GET");
		mv.setViewName("/board/delete");

		BoardVo board = boardService.getBoard(num);
		mv.addObject("board", board);

		return mv;
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(ModelAndView mv, BoardVo board, HttpServletRequest req) {
		logger.info("URI:/board/modify:POST");
		mv.setViewName("redirect:/board/list");

		boardService.deleteBoard(board, userService.getUser(req));

		return mv;
	}
}
