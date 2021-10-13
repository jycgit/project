package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class DetailAction implements Action {

	int deptno;
	String title="상세";
	String readonly="readonly";
	String disabled="disabled";
	String url="edit.action";
	private DeptVo bean;
	
	public String getString() {
		return title;
	}
	
	public String getReadonly() {
		return readonly;
	}
	
	public String getDisabled() {
		return disabled;
	}
	
	public void setDaptno(int deptno) {
		this.deptno=deptno;

	}
	
	public DeptVo getBean() {
		return bean;
	}
	@Override
	public String execute() throws Exception {
		bean=new DeptDao().selectOne(deptno);
		return SUCCESS;
	}

}
