package kr.co.tjoeun.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
//@RequestMapping("/")
public class Ex06Controller {
	
	// void는 url을 기준으로 한다
	@RequestMapping("/ex09.do")
	public String ex09() {
	   System.out.println("Ex06-func1");
	   return "ex01";
	}
	
	@RequestMapping("/ex10.do")
	public String ex10() {
	   System.out.println("Ex06-func1");
	   return "ex01";
	}

}
