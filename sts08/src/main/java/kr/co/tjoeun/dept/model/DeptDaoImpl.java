package kr.co.tjoeun.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		return sqlMapClientTemplate.queryForList("selectAll");
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		return (DeptVo) sqlMapClientTemplate.queryForObject("selectOne",deptno);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		sqlMapClientTemplate.insert("insertOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		return sqlMapClientTemplate.update("updateOne",bean);
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		return sqlMapClientTemplate.delete("deleteOne",deptno);
	}

}
