package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {
    String msg;
    int su;
    
    
	
	public void setMsg(String msg) {
		this.msg = msg;
	}



	public void setSu(int su) {
		this.su = su;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("msg"+msg);
		System.out.println("su:"+su);
		return SUCCESS;
	}

}
