package kr.co.tjoeun.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public JdbcTemplate() {
		String driver="org.h2.Driver";
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	public abstract Object mapper(ResultSet rs2) throws SQLException;
	
	public List<T> queryForList(String sql,RowMapper mapper) throws SQLException{
		return queryForList(sql,mapper,new Object[] {});
	}
	
	public Object queryForObject(String sql,RowMapper mapper, Object obj) throws SQLException {
		return queryForList(sql,mapper,new Object[] {obj}).get(0);
	}
	
	public List<T> queryForList(String sql,RowMapper<T> mapper,Object ... objs) throws SQLException{
		List<T> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++)
				pstmt.setObject(i+1, objs[i]);
			rs=pstmt.executeQuery();
			while(rs.next()) list.add(mapper.row(rs));
		}finally {
			close();
		}
		return list;
	}

	public int queryUpdate(String sql,Object ... objs) throws SQLException {
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		}finally {
			close();
		}
	}

	private void close() throws SQLException {
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
}

