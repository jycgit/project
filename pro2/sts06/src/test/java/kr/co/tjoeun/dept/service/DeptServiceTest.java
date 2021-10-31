package kr.co.tjoeun.dept.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class DeptServiceTest {
	@Autowired
	DeptService deptService;
	Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model=new ExtendedModelMap();
	}
	
	@Test
	public void getService() {
		assertNotNull(deptService);
	}

	@Test
	public void testGetList() throws Exception {
		
		deptService.getList(model);
		Map<String, Object> map = model.asMap();
		Set<Entry<String, Object>> entrys = map.entrySet();
		for(Entry<String, Object> entry : entrys)
			System.out.println(entry);
		
	}

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() throws Exception {
		deptService.update(new DeptVo(1,"aopaaaaaaaaaaaaaaaaaa","test"));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
