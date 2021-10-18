package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.model.DeptDao1;

public class ListController implements Controller {
	DeptDao1 dao;
	
	public void setDao(DeptDao1 dao) {
		this.dao = dao;
	}
//dao를 컨트롤러 갯수만큼 받을 필요가 없다.
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("list", dao.selectAll());
		
		mav.setViewName("list");
		return mav;
	}

}
