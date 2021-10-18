package kr.co.tjoeun.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao3 extends JdbcDaoSupport implements DeptDao {

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno desc";
		RowMapper rowMapper=new RowMapper<DeptVo>() {
			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(
				rs.getInt(1),rs.getString(2),rs.getString(3)
			 );
			}
		};
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept (dname,loc) values(?,?)";
		getJdbcTemplate().update(sql,bean.getDname(),bean.getLoc());

	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {
			
			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
			}
		};
		return getJdbcTemplate().queryForObject(sql, rowMapper, deptno);
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		return getJdbcTemplate().update(sql,deptno);
		
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?, loc=? where deptno=?";
		return 0;
	}

}
