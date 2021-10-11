package kr.co.tjoeun.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.framework.JdbcTemplate;
import kr.co.tjoeun.framework.UpdateTemplate;
import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao {
   private Connection conn;

   public DeptDao() throws Exception {
      String driver="com.mysql.cj.jdbc.Driver";
      String url="jdbc:mysql://192.168.56.1:33306/xe";
      String user="scott";
      String password="tiger";
      
      Class.forName(driver);
      conn=DriverManager.getConnection(url, user, password);
   }
   
   public Connection getConnection() {
      return conn;
   }
   
   public List<DeptVo> getList() throws SQLException{
      String sql="select * from dept";
      List<DeptVo> list=new ArrayList<>();
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      try {
         conn=getConnection();
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         while(rs.next()) {
            DeptVo bean=new DeptVo();
            bean.setDeptno(rs.getInt("deptno"));
            bean.setDname(rs.getString("dname"));
            bean.setLoc(rs.getString("loc"));
            list.add(bean);
         }
      }finally{
         if(rs!=null)rs.close();
         if(pstmt!=null)pstmt.close();
         if(conn!=null)conn.close();
      }
      return list;
   }
   
   public DeptVo getOne(int param) throws SQLException {
      String sql="select * from dept where deptno=?";
      JdbcTemplate template=new JdbcTemplate();{
    	  
      }
    
   }
   
   public void insertOne(final DeptVo bean) throws SQLException {
      String sql="insert into dept (dname,loc) values (?,?)";
      UpdateTemplate template=new UpdateTemplate() {
         @Override
         public void setPstmt(PreparedStatement pstmt) throws SQLException {
            pstmt.setString(1, bean.getDname());
            pstmt.setString(2, bean.getLoc());
         }
      };
      template.update(sql);
   }
   
   public int deleteOne(final int param) throws SQLException {
      String sql="delete from dept where deptno=?";
      UpdateTemplate template=new UpdateTemplate() {
      template.update(sql,new object[] {bean.getDname,bean.getLoc()})
         @Override
         public void setPstmt(PreparedStatement pstmt) throws SQLException {
            pstmt.setInt(1, param);
         }
      };
      return template.update(sql);
   }
   
   public int updateOne(DeptVo bean) throws SQLException {
      String sql="update dept set dname=?,loc=? where deptno=?";
      Connection conn=null;
     
   }
}

