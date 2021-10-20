package kr.co.tjoeun.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import kr.co.tjoeun.dept.model.entity.DeptVo;

public class DeptDao1Impl extends JdbcDaoSupport implements DeptDao {
	PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		final String sql="select * from dept";
		PreparedStatementCreator psc=null;
	    psc=new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			    PreparedStatement pstmt=getConnection().prepareStatement(sql);	
				return pstmt;
			}
		};
			
		RowMapper<DeptVo> rowMapper;
		rowMapper=new RowMapper<DeptVo>()  {
		
			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		};
		return getJdbcTemplate().query(sql, rowMapper);
	}



	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept (dname,loc) values ('test','test')";
		getJdbcTemplate().update(sql);

	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=?, where deptno=(select * from (select max(deptno) from dept) as a)";
		return getJdbcTemplate().update(sql, bean.getDname(),bean.getLoc());
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		
		return 0;
	}
	
   @Override
       public int insertAndUpdate(final DeptVo bean) throws SQLException {
	    TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
	   try {
		   PreparedStatementCreator psc=null;
			psc=new PreparedStatementCreator()  {
		
		@Override
		public  PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
			System.out.println(conn);
			String sql="insert into dept (dname,loc) values ('test','test')";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			// ? - setter
			return pstmt;

		}
	};
	   getJdbcTemplate().update(psc);
	   psc=new PreparedStatementCreator() {
		   
		   @Override
		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
			   String sql="update dept set dname=?,loc=?, where deptno=(select * from (select max(deptno) from dept) as a)";
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, bean.getDname());
			   pstmt.setString(2, bean.getLoc());
		       return pstmt;   
	   }
};
    int result= getJdbcTemplate().update(psc);
    transactionManager.commit(status);
    //같은 커넥션이어야 작동, transactionManager는 커넥션 관리
    return result;
   } catch(Exception e) {
	   transactionManager.rollback(status);
   }finally {
   }
   return 0;
    }
 }
