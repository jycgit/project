package kr.co.tjoeun.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao2 implements DeptDao {
	DataSource dataSource;

	public DeptDao2() {}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public List<DeptVo> selectAll() throws SQLException{
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
	
	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setString(1, bean.getDname());
			pstmt.setString(2, bean.getLoc());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		try(
				Connection conn=dataSource.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, deptno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3)); 
		}
		return null;
	}
	
	@Override
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
	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?, loc=? where deptno=?";
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
}

