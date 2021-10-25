package kr.co.tjoeun.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.dept.model.entity.DeptVo;
import kr.co.tjoeun.dept.service.DeptService;
//4.3 var
@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	@GetMapping(value = "/")
	public String list(Model model) throws Exception {
		deptService.listMapping(model);
		return "dept/list";
	}

	@PostMapping("/")
	public String add(DeptVo bean) throws Exception {
		deptService.addData(bean);
		return "redirect:./";
	}
	
	@GetMapping("/{deptno}")
	public String detail(@PathVariable("deptno") int deptno,Model model) {
		try {
			deptService.objMapping(model,deptno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json";
	}
	
	@PutMapping("/{deptno}")
	public String edit(@PathVariable int deptno, DeptVo bean) throws Exception {
	 deptService.updateData(bean);
	 return "redirect:./";
	
	}
	@PutMapping("/{deptno}")
	public String edit(@PathVariable int deptno) throws Exception {
	  System.out.println("delete:"+deptno);
	  deptService.deleteData(deptno);
	  return "redirect:./";
	
	}
	
}
