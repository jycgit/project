package kr.co.tjoeun.dept.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.tjoeun.dept.model.entity.DeptVo;

public interface DeptService {

	List<DeptVo> list() throws SQLException;
	DeptVo One(int param) throws SQLException;
	boolean add(DeptVo bean) throws SQLException;
	boolean edit(DeptVo bean) throws SQLException;
	boolean remove(int param) throws SQLException;
}
