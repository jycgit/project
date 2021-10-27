package kr.co.tjoeun.sts12.model.entity;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDaoImpl implements DeptDao {
	JdbcTemplate jdbcTemplate;

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		
		return null;
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
