package kr.co.tjoeun.dept.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={
		"classpath:/applicationContext.xml"
//		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		})
@Transactional //전부다 트랜잭션 상황
public class DeptDaoTest {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	DeptDao<DeptVo> deptDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	DeptVo target;
	
	@Before
	public void setUp() throws Exception {
		target=new DeptVo(1,"aop","test");
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(deptDao.selectAll());
		assertSame(7,deptDao.selectAll().size());
	}

	@Test
	public void testSelectOne() throws SQLException {
		assertEquals(target, deptDao.selectOne(target.getDeptno()));
	}

	@Transactional
	@Test
	public void testInsertOne() throws SQLException {
		deptDao.insertOne(target);
	}

	@Test
	public void testUpdateOne() throws SQLException {
		assertSame(1,deptDao.updateOne(target));
	}

	@Test
	public void testDeleteOne() throws SQLException {
		assertSame(1,deptDao.deleteOne(target.getDeptno()));
	}
}

