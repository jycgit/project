package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

public class AddAction implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println(this.hashCode());
		return SUCCESS;
	}

}
