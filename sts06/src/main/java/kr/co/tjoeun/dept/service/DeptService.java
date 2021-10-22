package kr.co.tjoeun.dept.service;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.entity.DeptVo;

public interface DeptService {
	void getList(Model model) throws Exception;
	void getOne(Model model,int key) throws Exception;
	void insert(DeptVo target) throws Exception;
	boolean update(DeptVo target) throws Exception;
	boolean delete(int key) throws Exception;
}
