package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

public class Ex02Action implements Action {
    String msg;
    
    public void setMsg(String msg) {
		this.msg = msg;
	}
    
    public String getMsg() {
		return msg;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("run Ex02...");
		System.out.println("msg:"+msg);
		return SUCCESS;
	}

}
