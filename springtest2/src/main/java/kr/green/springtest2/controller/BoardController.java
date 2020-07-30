package kr.green.springtest2.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest2.service.BoardService;
import kr.green.springtest2.vo.BoardVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView BoardGet(ModelAndView mv) {
		logger.info("URI:/board/list:GET");
		mv.setViewName("/board/list");

		ArrayList<BoardVo> list = boardService.getBoardlist();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detailGet(ModelAndView mv, Integer num) {
		logger.info("URI:/board/detail:GET");
		mv.setViewName("/board/detail");

		BoardVo board = boardService.getBoard(num);
		mv.addObject("board", board);

		return mv;
	}
}
