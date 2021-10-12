package kr.co.tjoeun.framework;

import javax.servlet.http.HttpServletRequest;

public interface Controller {

	String execute(HttpServletRequest req) throws Exception;
	
}
