package kr.co.tjoeun.dept.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;
import kr.co.tjoeun.dept.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;

	@RequestMapping(value="/dept/",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		deptService.getList(model);
		return "dept/list";
	}
	
	@RequestMapping("/dept/add")
	public String add(Model model) {
		model.addAttribute("title", "insert");
		model.addAttribute("disabled", "");
		model.addAttribute("url", "./");
		return "dept/form";
	}
	
	@RequestMapping(value = "/dept/",method=RequestMethod.POST)
	public String add(DeptVo bean) throws Exception {
		deptService.insert(bean);
		return "redirect:/dept/";
	}
	
	@RequestMapping(value = "/dept/{deptno}",method=RequestMethod.GET)
	public String detail(@PathVariable("deptno") int deptno,Model model) throws Exception {
		deptService.getOne(model, deptno);
		model.addAttribute("title", "detail");
		model.addAttribute("disabled", "disabled");
		model.addAttribute("url", "edit");
		return "dept/form";
	}
	@RequestMapping(value = "/dept/edit",method=RequestMethod.POST)
	public String edit(int deptno,Model model) throws Exception {
		deptService.getOne(model, deptno);
		model.addAttribute("title", "update");
		model.addAttribute("disabled", "");
		model.addAttribute("url", "./"+deptno);
		return "dept/form";
	}
	
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.PUT)
	public String edit(int deptno, DeptVo bean,Model model) throws Exception {
		if(deptService.update(bean))
			return "redirect:./"+deptno;
		return edit(deptno,model);
	}
	

	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.DELETE)
	public String delete(int deptno) throws Exception {
		deptService.delete(deptno);
		return "redirect:./";
	}
}










