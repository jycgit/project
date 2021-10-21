package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex05Controller  {
//��Ʈ�ѷ� ����� ���� ������ �����Ӱ� ��������
	@RequestMapping("/ex05.do")
	public String page05() {
	    System.out.println("Ex05Controller page05 run ...");
		return "ex01";
	}
	
	@RequestMapping("/ex06.do")
	public String page06() {
		System.out.println("Ex05Controller page06 run...");
		return "ex02";
	}
	
	@RequestMapping(value= "/ex07.do")
	public String page07(HttpServletRequest req) {
		System.out.println("page07 param msg="+req.getParameter("msg"));
		return "ex01";
	}
	
	@RequestMapping(value = "/ex08.do", method= RequestMethod.GET)
	public String page08(HttpServletRequest req) {
		System.out.println("page08 GET msg="+req.getParameter("msg"));
		return "ex01";
	}
	//��Ŀ� ���� ��ø���� 
	@RequestMapping(value = "/ex08.do", method= RequestMethod.POST)
	public String page09(HttpServletRequest req) {
		System.out.println("page08 POST  msg="+req.getParameter("msg"));
		return "ex01";
	
	}
}
