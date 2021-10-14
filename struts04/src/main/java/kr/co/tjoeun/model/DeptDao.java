package kr.co.tjoeun.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao {

	DataSource dataSource;
	
	public DeptDao() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://192.168.56.1:3306/xe");
		dataSource.setUser("scott");
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
	    		list.add(new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3)));
	    }
	    return list;
	}
	//deptVo 수정
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			   pstmt.setInt(1, deptno);
			   ResultSet rs=pstmt.executeQuery();
			   if(rs.next())
				   return new DeptVo(rs.getInt(1),rs.getString(2), rs.getString(3));
		}
		return null;
		
	}
	
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getDname());
			pstmt.setString(2, bean.getLoc());
			pstmt.executeUpdate();
		}
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getDname());
			pstmt.setString(2, bean.getLoc());
			pstmt.setInt(3, bean.getDeptno());
			return pstmt.executeUpdate();
		}
	}
	
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			return pstmt.executeUpdate();
		}
	}
	
}
