package kr.co.tjoeun.dept.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@RestController
@RequestMapping(value="/dept")
public class DeptController {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	DeptDao deptDao;


    @GetMapping("/")
	public List<DeptVo> list() throws SQLException {
		return deptDao.selectAll();
	}
    
    @PostMapping
    public ResponseEntity<String> add(DeptVo bean) {
    	try {
			deptDao.insertOne(bean);
		} catch (SQLException e) {
			return ResponseEntity.badRequest().build();
		}
    	return ResponseEntity.ok(null);
    }
    
    @GetMapping("/{deptno}")
    public DeptVo detail(@PathVariable int deptno) throws SQLException {
    	return deptDao.selectOne(deptno);
    }
    
    
    @PostMapping("/{deptno}")
    public ResponseEntity<String> edit(@RequestBody DeptVo bean){
    	try {
    	deptDao.updateOne(bean);
    	} catch (SQLException e) {
    		return ResponseEntity.badRequest().build();
    	}
    	return ResponseEntity.ok(null);   	
    }   
    
    @DeleteMapping("/{deptno}")
    public ResponseEntity<String> delete(@PathVariable int deptno) {
    	try {
        	deptDao.deleteOne(deptno);
        	} catch (SQLException e) {
        		return ResponseEntity.badRequest().build();
        	}
        	return ResponseEntity.ok(null);   
    }
}


