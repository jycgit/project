package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //Ŭ�������� ���� ����, Ŭ������ bean
public class Ex03Controller {

	@RequestMapping("/ex03.do")
	public ModelAndView page03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Ex03Controller run ...");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("ex01");
		return mav;
	}

}