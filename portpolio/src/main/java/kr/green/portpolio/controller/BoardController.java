package kr.green.portpolio.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.portpolio.service.BoardService;
import kr.green.portpolio.vo.BoardVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		logger.info("URI:/board/list:GET");
		mv.setViewName("/board/list");
		ArrayList<BoardVo> list;
		list = boardService.getBoardList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDeteilGet(ModelAndView mv, Integer num) {
		logger.info("URI:/board/detail:GET");
		mv.setViewName("/board/detail");
		BoardVo board = null;
		if (num != null) {
			board = boardService.getBoard(num);
		}

		return mv;
	}
	
	@RequestMapping(value = "/board/register ", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		logger.info("URI:/board/register:GET");
		mv.setViewName("/board/register");

		return mv;
	}

}
