package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //Ŭ�������� ���� ����, Ŭ������ bean
public class Ex02Controller {

	@RequestMapping("/ex02.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Ex02Controller run ...");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("ex01");
		return mav;
	}

}
