package kr.green.portpolio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) {
		logger.info("URI:/list");
		mv.setViewName("/board/list");

		return mv;
	}

}
