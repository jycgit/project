package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.model.DeptDao1;
import kr.co.tjoeun.model.entity.DeptVo;

public class AddController implements Controller {
	DeptDao1 dao;
	
	public void setDao(DeptDao1 dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("uft-8");
		dao.insertOne(new DeptVo(0,request.getParameter("dname"),
				request.getParameter("loc")));
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
