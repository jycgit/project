package kr.co.tjoeun.dept.model;

import java.sql.SQLException;
import java.util.List;

import kr.co.tjoeun.dept.model.entity.DeptVo;

public interface DeptDao {
	List<DeptVo> selectAll() throws SQLException;	
	DeptVo selectOne(int deptno)  throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int deptno) throws SQLException;
}
