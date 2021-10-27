package kr.co.tjoeun.dept.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@RestController
public class DeptController {
	@Autowired
	SqlSessionFactory factory;

	@GetMapping("/dept/")
	public List<DeptVo> list(){
		try(
				SqlSession sqlSession=factory.openSession();
				){
		return sqlSession.getMapper(DeptDao.class).selectAll();	
		}
	}
	@GetMapping("/dept/{deptno}")
	public DeptVo detail(@PathVariable int deptno) {
		try(
				SqlSession sqlSession=factory.openSession();
				) {
			return sqlSession.getMapper(DeptDao.class).selectOne(deptno);
		}
	}
	
	@PostMapping("/dept/")
	public ResponseEntity<?> add(DeptVo bean){
		try(
				SqlSession sqlSession=factory.openSession();
				) {
			sqlSession.getMapper(DeptDao.class).insertOne(bean);
		}
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/dept/{deptno}")
	public ResponseEntity<?> remove(@PathVariable("deptno") int deptno){
		try(
				SqlSession sqlSession=factory.openSession();
				) {
			if(sqlSession.getMapper(DeptDao.class).deleteOne(deptno)>0)
                return ResponseEntity.ok(null);			
		}
		return ResponseEntity.badRequest().build();	
	}
	
	@PutMapping("/dept/{deptno}")
	public ResponseEntity<?> edit(@RequestBody DeptVo bean,@PathVariable deptno){
	   try(
			   SqlSession sqlSession=factory.openSession();
			   ) {
		   if(sqlSession.getMapper(DeptDao.class).updateOne(bean)>0)
	          return ResponseEntity.ok(null);
	   }	
	   return ResponseEntity.badRequest().build();
	}
}








