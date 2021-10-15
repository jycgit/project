package kr.co.tjoeun.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao {
	SqlMapClient sqlMapClient;
	
	public DeptDao() {
		//DeptMapConfig을 읽기위해 inputStream
		InputStream is;
		try {
			is = Resources.getResourceAsStream("/SqlMapConfig.xml");
			sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<DeptVo> selectAll() throws SQLException{
       return sqlMapClient.queryForList("selectAll");
	}
	public void insertOne(DeptVo bean) throws SQLException {
		sqlMapClient.insert("insertOne", bean);
		
	}

	public DeptVo selectOne(int deptno) throws SQLException{
		return (DeptVo) sqlMapClient.queryForObject("selectOne",deptno);
	
}
  public int updateOne(DeptVo bean) throws SQLException {
	  return sqlMapClient.update("updateOne", bean);
  }
  
  public int deleteOne(int deptno) throws SQLException {
	  return sqlMapClient.delete("deleteOne", deptno);
  }
}