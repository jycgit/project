package kr.co.tjoeun.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@Repository
public class DeptDaoImpl implements DeptDao<DeptVo> {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3));
		}
	};
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo selectOne(int key) throws SQLException {
		String sql="select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,key);
	}

	@Override
	public void insertOne(DeptVo t) throws SQLException {
		String sql="insert into dept (dname,loc) values (?,?)";
		jdbcTemplate.update(sql,t.getDname(),t.getLoc());
	}

	@Override
	public int updateOne(DeptVo t) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		return jdbcTemplate.update(sql,t.getDname(),t.getLoc(),t.getDeptno());
	}

	@Override
	public int deleteOne(int key) throws SQLException {
		String sql="delete from dept where deptno=?";
		return jdbcTemplate.update(sql,key);
	}

}

