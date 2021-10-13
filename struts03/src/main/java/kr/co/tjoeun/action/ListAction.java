package kr.co.tjoeun.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class ListAction implements Action {

	private List<DeptVo> list;
	
	public List<DeptVo> getList() {
		return list;
	}
	

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		list=dao.selectAll();
		System.out.println(list);
		return SUCCESS;
	}

}
