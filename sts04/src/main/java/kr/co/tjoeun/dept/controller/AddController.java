package kr.co.tjoeun.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

public class AddController extends AbstractCommandController {
	Logger log=Logger.getLogger(this.getClass());
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
//나에게 클래스를 던진다.
@Override
protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
		BindException errors) throws Exception {
	log.debug(command);
	deptDao.insertAndUpdate((DeptVo)command);
	ModelAndView mav=new ModelAndView("redirect:list.do");
	return mav;

}

}
