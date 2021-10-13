package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {

	@Override
    public String execute() throws Exception {
	   System.out.println("run Ex01...");
	   return this.SUCCESS;
//	   return this.ERROR;
//	   return this.INPUT;
//	   return this.LOGIN;
//	   return this.NONE;
  }
}
