package kr.co.tjoeun.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.Action;

import kr.co.tjoeun.model.DeptDao;

public class InsertAction implements Action {

	String dname,loc;
	
	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		try {
		dao.insertOne(dname, loc);
		} catch(SQLException e) {
			return INPUT;
		}
		return SUCCESS;
	}
   
   
}
