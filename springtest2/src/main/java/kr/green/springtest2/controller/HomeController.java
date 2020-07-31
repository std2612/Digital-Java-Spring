package kr.green.springtest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest2.service.UserService;
import kr.green.springtest2.vo.UserVo;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		logger.info("URI:/");
		mv.setViewName("/main/home");

		return mv;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		logger.info("URI:/signin:GET");
		mv.setViewName("/main/signin");

		return mv;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, UserVo user) {
		logger.info("URI:/signin:POST");

		UserVo signinUser = userService.signinUser(user);
		if (signinUser != null) {
			mv.setViewName("/main/home");
			mv.addObject("user", signinUser);
		} else {
			mv.setViewName("redirect:/signin");
		}

		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		logger.info("URI:/signup:GET");
		mv.setViewName("/main/signup");

		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, UserVo user) {
		logger.info("URI:/signup:POST");

		if (userService.insertUser(user)) {
			mv.setViewName("redirect:/");
		} else {
			mv.setViewName("redirect:/signup");
		}

		return mv;
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest req) {
		logger.info("URI:/signout:GET");
		mv.setViewName("redirect:/");

		req.getSession().removeAttribute("user");

		return mv;
	}

}
