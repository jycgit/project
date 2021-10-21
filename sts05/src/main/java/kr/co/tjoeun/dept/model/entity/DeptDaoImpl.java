package kr.co.tjoeun.dept.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class DeptDaoImpl implements DeptDao {
    JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept";
		return jdbcTemplate.query(sql,new RowMapper<DeptVo>() {
			
			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {				
				return new DeptVo(rs.getInt(1),rs.getString(2), rs.getString(3));
			}
			
		});
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		    
		},deptno);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
        jdbcTemplate.update(sql,bean.getDname(),bean.getLoc());
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?, loc=? where deptno=?";
		return jdbcTemplate.update(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,deptno);
	}

}
