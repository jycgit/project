package kr.co.tjoeun.model;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;

import org.junit.Test;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDaoTest {

	//접속
	@Test
	public void testGetConnection() throws Exception {
		DeptDao dao=new DeptDao();
		Connection conn=dao.getConnection();  
		assertNotNull(conn); //null이 아닌지 확인, 
		
		conn.close();
		//null 실패, not null 성공
	}
	
	@Test
	public void testGetList() throws Exception {
		DeptDao dao=new DeptDao();
		List<DeptVo> list=dao.getList();
		assertNotNull(list);
		assertSame(4, list.size()); //더미데이터 갯수
		
	}
	
	@Test
	public void testGetOne() throws Exception {
		DeptDao dao=new DeptDao();
		DeptVo bean=dao.getOne(0);
		System.out.println(bean);
		assertNotNull(bean);
		assertSame(0,bean.getDeptno());
		assertEquals(null, bean.getDname());
		assertEquals(null, bean.getLoc());
//		assertNotNull(bean);
//		assertSame(1,bean.getDeptno());
//	    assertEquals("테스터1", bean.getDname());
//	    assertNotEquals("Null", bean.getLoc());
	}

}
