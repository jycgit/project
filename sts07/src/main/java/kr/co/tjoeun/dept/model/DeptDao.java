package kr.co.tjoeun.dept.model;

import java.sql.SQLException;
import java.util.List;

import kr.co.tjoeun.dept.model.entity.DeptVo;

public interface DeptDao<T> {
	
	List<T> selectAll() throws SQLException;
	T selectOne(int key) throws SQLException;
	void insertOne(T t) throws SQLException;
	int updateOne(T t) throws SQLException;
	int deleteOne(int key) throws SQLException;

}
