package kr.co.tjoeun.dept.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.dept.model.entity.DeptVo;
import kr.co.tjoeun.dept.service.DeptService;

@RestController
public class DeptController {
	Logger log=LoggerFactory.getLogger(DeptController.class);
	@Autowired
	DeptService deptService;

	@GetMapping("/dept/")
	public List<DeptVo> listPage() throws SQLException{
		return deptService.list();
	}
	
	@GetMapping("/dept/{deptno}")
	public DeptVo detailPage(@PathVariable int deptno) throws SQLException {
		return deptService.One(deptno);
	}
	
	@PostMapping("/dept/")
	public ResponseEntity<String> addPage(DeptVo bean){
		try {
			if(deptService.add(bean))
				return ResponseEntity.ok(null);
		} catch (SQLException e) {
			log.error("post method");
		}
		return ResponseEntity.badRequest().build();
	} 
	
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<String> editPage(
			@RequestBody DeptVo bean
			,@PathVariable int deptno){
		try {
			if(deptService.edit(bean))
				return ResponseEntity.ok(null);
		} catch (SQLException e) {
			log.error("put method");
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<String> deletePage(@PathVariable int deptno){
		try {
			if(deptService.remove(deptno))
				return ResponseEntity.ok(null);
		} catch (SQLException e) {
			log.error("delete method");
		}
		return ResponseEntity.badRequest().build();
	}
}

