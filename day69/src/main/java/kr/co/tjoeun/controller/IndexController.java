package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import kr.co.tjoeun.framework.Controller;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		return "index";
	}

}
