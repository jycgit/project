package kr.co.tjoeun.action;

import com.opensymphony.xwork2.Action;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class EditAction implements Action {

	int deptno;
	String title="수정";
	String url="update.action";
	private DeptVo bean;
	
	public String getUrl() {
		return url;
	}
	
	public String getString() {
		return title;
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
