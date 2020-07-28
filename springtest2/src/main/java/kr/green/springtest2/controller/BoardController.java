package kr.green.springtest2.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest2.service.BoardService;
import kr.green.springtest2.vo.BoardVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService boardService;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView BoardGet(ModelAndView mv) {
		logger.info("URI:/board/list:GET");
		mv.setViewName("/board/list");
		
		ArrayList<BoardVo> list = boardService.getBoardlist();
		System.out.println(list);

		return mv;
	}
}
