package kr.co.tjoeun.dept.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/applicationContext.xml"
})
@Transactional
public class DeptServiceTest {
    @Autowired
    DeptService deptService;
    DeptVo target;
    Model model;
	
	@Before
	public void setUp() throws Exception {
		target=new DeptVo(1,"aop", "test");
		model=new ExtendedModelMap();
	}

	@Test
	public void testListMapping() throws Exception {
	   deptService.listMapping(model);
	   Map<String,Object> map=model.asMap();
	   assertNotNull(map.get("list"));
	}

	@Test
	public void testObjMapping() throws Exception {
		deptService.objMapping(model, target.getDeptno());
		Map<String,Object> map=model.asMap();
		assertEquals(target, map.get("bean"));
	}

	@Test
	public void testAddData() throws Exception {
		deptService.addData(target);
	}

	@Test
	public void testUpdateData() throws Exception {
		deptService.updateData(target);
	}

	@Test
	public void testDeleteData() throws Exception {
		deptService.deleteData(target.getDeptno());
	}

}
