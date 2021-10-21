package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //Ŭ�������� ���� ����, Ŭ������ bean
public class Ex04Controller {

	@RequestMapping("/ex04.do")
	public String page04(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Ex04Controller run ...");
		return "ex01";
	}
}
