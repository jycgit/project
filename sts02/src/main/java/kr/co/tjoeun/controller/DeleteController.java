package kr.co.tjoeun.controller;

import javax.naming.ldap.Control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.model.DeptDao;

public class DeleteController implements Controller {
    DeptDao deptDao;
    
    public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		deptDao.deleteOne(Integer.parseInt(request.getParameter("dpetno")));
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
