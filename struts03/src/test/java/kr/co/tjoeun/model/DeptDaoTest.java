package kr.co.tjoeun.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DeptDaoTest {

	@Test
	public void testDeptDao() throws SQLException {
		DeptDao dao=new DeptDao();
		assertNotNull(dao.dataSource);
		assertNotNull(dao.dataSource.getConnection());	
	}
    
	@Test
	public void testSelectAll() throws SQLException{
		DeptDao dao=new DeptDao();
		assertNotNull(dao.selectAll());
		
	}
	
}
