package kr.co.tjoeun.model;

import java.sql.SQLException;
import java.util.List;

import kr.co.tjoeun.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll() throws SQLException;

	void insertOne(DeptVo bean) throws SQLException;

	DeptVo selectOne(int deptno) throws SQLException;

	int deleteOne(int deptno) throws SQLException;
	
	int updateOne(DeptVo bean) throws SQLException;


}
