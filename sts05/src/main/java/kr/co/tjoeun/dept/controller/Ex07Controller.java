package kr.co.tjoeun.dept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex07Controller {
	
	@RequestMapping("ex12.do")
	public String ex01() {
		System.out.println("ex12");
		return "ex01";
	}
}
