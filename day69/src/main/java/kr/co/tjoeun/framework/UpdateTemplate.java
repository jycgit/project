package kr.co.tjoeun.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class UpdateTemplate {
   private Connection conn;
   PreparedStatement pstmt;
   
   public  throws SQLException {
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

   public int update(String sql, Object[] obj) throws SQLException {
      try {
         conn=getConnection();
         pstmt=conn.prepareStatement(sql);
         for(int i=0; i<obj.length; i++) {
        	 pstmt.setObject(i+1, obj[i]);
         }
         return pstmt.executeUpdate();
      }finally{
         if(pstmt!=null)pstmt.close();
         if(conn!=null)conn.close();
      }
   }

}

