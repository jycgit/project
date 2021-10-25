package kr.co.tjoeun.dept.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@Transactional
public interface DeptService {
	
	void listMapping(Model model) throws Exception; 
	void objMapping(Model model, int deptno) throws Exception;
	void addData(DeptVo bean) throws Exception;
	void updateData(DeptVo bean) throws Exception;
	void deleteData(int deptno) throws Exception;

}
