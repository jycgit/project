package kr.co.tjoeun.sts12.model.entity;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface DeptDao {
	
    @Select("select * from dept order by deptno desc")
	List<DeptVo> selectAll() throws SQLException;
	DeptVo selectOne(int deptno) throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int deptno) throws SQLException;
}
