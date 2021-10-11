package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tjoeun.framework.Controller;
import kr.co.tjoeun.model.DeptDao;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		req.setAttribute("list", new DeptDao().getList());
		return "list";
	}

}
