package kr.co.tjoeun.dept.model.entity;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {
	List<DeptVo> selectAll() throws SQLException;
	DeptVo selectOne(int deptno) throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int deptno) throws SQLException;

}
