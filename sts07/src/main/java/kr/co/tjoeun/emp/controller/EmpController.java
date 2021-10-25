package kr.co.tjoeun.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@RestController
public class EmpController {
//@ResponseBody ������ .jsp ���(ã�� ���� ����)

	@GetMapping(value="/emp/", produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> test1() {
//		List<DeptVo> list=new ArrayList<>();
//	    list add=(new DeptVo(1,"test1","test2"));
//	    list add=(new DeptVo(2,"test2","test2"));
//	    list add=(new DeptVo(3,"test3","test2"));
//	    list add=(new DeptVo(4,"test4","test2"));
//	    return "list";
		
		return new ResponseEntity("body�κ�",HttpStatus.OK);
	}
	
	@GetMapping(value="/emp/test")
	public void test2(@RequestBody String msg) {
	     System.out.println("param:"+msg);
	}
}
