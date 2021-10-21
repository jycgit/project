package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller //Ŭ�������� ���� ����, Ŭ������ bean
public class Ex01Controller implements Controller {

	@RequestMapping("/ex01.do")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Ex01Controller run ...");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("ex01");
		return mav;
	}

}
//�������̽� ��ӹ޾� ����Ÿ���� ������