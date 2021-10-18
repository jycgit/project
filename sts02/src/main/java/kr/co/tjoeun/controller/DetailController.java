package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.model.DeptDao1;

public class DetailController implements Controller {
	DeptDao1 dao;
	
	public void setDao(DeptDao1 dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("bean", dao.selectOne(
				Integer.parseInt(request.getParameter("deptno"))));
		
		mav.setViewName("detail");
		return null;
	}

}
