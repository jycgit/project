package kr.co.tjoeun.model; 
import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao1 implements DeptDao {
	DataSource dataSource;

	public DeptDao1() {
		MysqlDataSource dataSource=new MysqlDataSource();
		//setDriver com.mysql.cj.jdbc.Driver
		dataSource.setUrl("jdbc:mysql://192.168.56.1:33306/xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		this.dataSource=dataSource;
	}
	
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
	
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from where deptno";
	try(
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			){
		pstmt.setInt(1, deptno);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return new DeptVo(rs.getInt(1), rs.getString(2),rs.getString(3));
	}
	return null;
	}
	@Override
	public int deleteOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
