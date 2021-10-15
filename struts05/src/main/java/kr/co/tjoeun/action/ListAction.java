package kr.co.tjoeun.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class ListAction implements ModelDriven<DeptVo> {
	private DeptVo bean=new DeptVo();
	private List<DeptVo> list;
	
	public List<DeptVo> getList() {
		return list;
	}
	
	public DeptVo getBean() {
		return bean;
	}
	
	public String update() throws SQLException {
		new DeptDao().updateOne(bean);
		return Action.SUCCESS;
	}
	
	public String delete( ) throws SQLException {
		new DeptDao().deleteOne(bean.getDeptno());
		return Action.SUCCESS;
	}

	public String listOne() throws Exception {
		new DeptDao().selectOne(bean.getDeptno());
		return Action.SUCCESS;
	}
	public String add() throws Exception {
		new DeptDao().insertOne(bean);
		return Action.SUCCESS;
	}
	
	public String list() throws Exception {
		list=new DeptDao().selectAll(); 
		return Action.SUCCESS;
	}

	@Override
	public DeptVo getModel() {
		return null;
	}
}
