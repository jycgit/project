package kr.co.tjoeun.sts12.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.tjoeun.sts12.model.entity.DeptDao;
import kr.co.tjoeun.sts12.model.entity.DeptVo;

@Controller
public class DeptController {
	Logger log=LoggerFactory.getLogger(getClass());
   //@Autowired
   DeptDao deptDao;
   @Autowired
   SqlSession sqlSession;
	
	@GetMapping("/main")
	public String index(Model model) throws SQLException {
		log.info("index...");
		model.addAttribute("list", deptDao.selectAll());
		return "index"; 
	}
	
	@GetMapping("/dept/")
	@ResponseBody
	public List<DeptVo> list() throws SQLException {
		return sqlSession.getMapper(DeptDao.class).selectAll();
	}
}
