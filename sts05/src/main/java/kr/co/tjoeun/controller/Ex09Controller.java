package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@Controller
public class Ex09Controller {

	@RequestMapping("/ex15.do")
	public String ex15(HttpServletRequest req) {
		req.setAttribute("msg", "abcd");
		return "ex15";
	}
		
	@RequestMapping("/ex16.do")
	public ModelAndView ex16(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView("ex15");
		req.setAttribute("msg", "bbbb");
		return mav;
	}
	
	@RequestMapping("/ex17.do")
	public String ex17(Model model) {
		model.addAttribute("msg","cccc");
		return "ex15";
	}
	//�Ķ���Ͱ��� ������ ��������, 
	@RequestMapping("/ex18.do")
	public String ex18(@RequestParam String msg
			, @RequestParam int su, Model model) {
		
		model.addAttribute("msg",msg+2);
		model.addAttribute("su",su+2);
		return "ex15";
	}
	
	@RequestMapping("/ex19.do")
	public String ex19( String msg, int su, Model model) {
		
		model.addAttribute("msg",msg+2);
		model.addAttribute("su",su+2);
		return "ex15";
	}
	
	@RequestMapping("/ex20.do")
	public String ex20(@ModelAttribute("bean") DeptVo bean) {
		System.out.println("before"+bean);
//		bean=new DeptVo(3, "test4", "test5");
//      bean=dao.selectOne(bean.getDeptno()); �����Ұ�		
//      �����Է�, �Ѿ�� �Ķ���� bean�� �־���, views�� ����, 
//      Model ������ ������ ����, view�� ���޸���
		bean.setDeptno(3);
		bean.setDname("test4");
		bean.setLoc("test5");
		System.out.println("after"+bean);
		return "ex16";
		
	}
}


