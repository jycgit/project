package kr.co.tjoeun.dept.model.entity;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class DeptDaoTest {
	private DeptDao deptDao;
	static ApplicationContext context;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String path="/src/main/webapp/WEB-INF/spring/root-context.xml";
//		String path="/src/main/resources/log4j.xml";
//		new FileSystemXmlApplicationContext(path); 
		
//		string path="/log4j.xml"; 클래스기준
//		new ClassPathXmlApplicationContext(path);
		context=new FileSystemXmlApplicationContext(path); 
		//file은 root기준
	}

	@Before
	public void setUp() throws Exception {
		deptDao=context.getBean(DeptDao.class);
	}

	@Test
	public void testGetDatasource() {
		assertNotNull(context.getBean(DataSource.class));
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(deptDao.selectAll());
		assertFalse(deptDao.selectAll().size()==0);
	}


	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
