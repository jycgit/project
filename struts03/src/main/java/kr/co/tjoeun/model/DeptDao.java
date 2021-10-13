package kr.co.tjoeun.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao {
	DataSource dataSource;

	public DeptDao() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource=null;
		dataSource=new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		this.dataSource=dataSource;
	}
	
	public List<DeptVo> selectAll() throws SQLException {
		  String sql="select * from dept";
	      List<DeptVo> list=new ArrayList<>();
	      try(
	         Connection conn=dataSource.getConnection();
	         PreparedStatement pstmt=conn.prepareStatement(sql);   
	         ResultSet rs=pstmt.executeQuery();
	      ){
	         while(rs.next()) 
	            list.add(new DeptVo(
	                  rs.getInt("deptno")
	                  ,rs.getString("dname")
	                  ,rs.getString("loc")
	                  ));
	      }
	      return list;
	}
	
	public void insertOne(String dname, String loc) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
		try(
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		){
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		}
	}
	
	public DeptVo selectOne(int deptno) throws SQLException{
		String sql="select * from dept where deptno=?";
		try (
			  Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
			){
			  pstmt.setInt(1, deptno);
			  ResultSet rs=pstmt.executeQuery();
			  if(rs.next())
				  return new DeptVo(
						  rs.getInt("deptno")
						  ,rs.getString("dname")
						  ,rs.getString("loc")
						  );
		}
		return null;
	
	} 
}

