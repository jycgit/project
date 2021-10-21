package kr.co.tjoeun.dept.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.dept.model.entity.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@Controller
public class DeptController {
    @Autowired
	DeptDao deptDao;

   //싱클톤 ,해당클래스로 하나의 객체 지정, 타입정보     
	@RequestMapping("/list")
	public String list(Model model) throws SQLException  {
		model.addAttribute("list", deptDao.selectAll());
		return "list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String add(String dname,String loc) throws SQLException  {
		deptDao.insertOne(new DeptVo(0,dname,loc));
		return "redirect:list";
	}

	@RequestMapping(value = "/detail")
	public String detail(int deptno,Model model) throws SQLException {
		model.addAttribute("bean", deptDao.selectOne(deptno));
		return "detail";
	}

	
	@RequestMapping(value = "/edit",method=RequestMethod.GET)
	public String edit(int deptno,Model model) throws SQLException {
		model.addAttribute("bean", deptDao.selectOne(deptno));
		return "edit";
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public String edit(DeptVo bean) throws SQLException{
		deptDao.updateOne(bean);
		return "redirect:detail?deptno="+bean.getDeptno();
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int deptno) throws SQLException {
		deptDao.deleteOne(deptno);
		return "redirect:list";
	}
		
}
