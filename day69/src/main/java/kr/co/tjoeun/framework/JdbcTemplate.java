package kr.co.tjoeun.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.model.entity.DeptVo;

public abstract class JdbcTemplate {
	private Connection conn;

	public Connection getConnection() throws SQLException {
	      String driver="com.mysql.cj.jdbc.Driver";
	      String url="jdbc:mysql://192.168.56.1:33306/xe";
	      String user="scott";
	      String password="tiger";
	      
	      try {
	         Class.forName(driver);
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      conn=DriverManager.getConnection(url, user, password);
	      return conn;
	   }
     public Object selectOne(String sql Object[] obj) throws SQLException{
    	 return  selectOne(sql).get(0);
     }
     
	 public List selectALL(String sql, Object[] obj) throws SQLException{
	      String sql="select * from dept where deptno=?";
	      if(conn!=null)conn.close();
	    		 	
	      return ;
	   }
	 
	 public abstract void setPstmt(PreparedStatement pstmt) {}
	 
	 public void mapper(ResultSet rs) throws SQLException {
		 DeptVo bean=new DeptVo();
		 bean.setDeptno(rs.getInt("deptno"));
		 bean.setDname(rs.getString("dname"));
		 bean.setLoc(rs.getString("loc"));
		 return bean;
	 }
	 
	 public DeptVo getobject(int param) throws SQLException {
	      String sql="select * from dept where deptno=?";
	      DeptVo bean=new DeptVo();
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      try {
	         conn=getConnection();
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, param);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            bean.setDeptno(rs.getInt("deptno"));
	            bean.setDname(rs.getString("dname"));
	            bean.setLoc(rs.getString("loc"));
	         }
	      }finally{
	         if(rs!=null)rs.close();
	         if(pstmt!=null)pstmt.close();
	         if(conn!=null)conn.close();
	      }
	      return bean;
	   }
	
}
