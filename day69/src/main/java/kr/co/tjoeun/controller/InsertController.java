package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tjoeun.framework.Controller;
import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		
		DeptVo bean=new DeptVo();
		bean.setDeptno(Integer.parseInt(req.getParameter("dname")));
		bean.setDname(req.getParameter("loc"));
		new DeptDao().insertOne(bean);
		return "redirect:list.do";
	}

}
