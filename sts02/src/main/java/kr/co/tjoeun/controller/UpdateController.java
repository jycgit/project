package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class UpdateController implements Controller {
	DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		DeptVo bean=new DeptVo(
				Integer.parseInt(request.getParameter("deptno"))
				,request.getParameter("dname"),request.getParameter("loc")
				);
		deptDao.updateOne(bean);
		mav.setViewName("redirect:detail.do?deptno="+bean.getDeptno());
		return mav;

	}

}
