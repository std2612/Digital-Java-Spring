package kr.green.portpolio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getMain(ModelAndView mv) {
		logger.info("URI:/");
		mv.setViewName("/main/home");

		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView getSignin(ModelAndView mv) {
		logger.info("URI:/signin");
		mv.setViewName("/main/signin");

		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignup(ModelAndView mv) {
		logger.info("URI:/signup");
		mv.setViewName("/main/signup");

		return mv;
	}

}
