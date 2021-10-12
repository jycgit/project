package kr.co.tjoeun.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.co.tjoeun.framework.JdbcTemplate;
import kr.co.tjoeun.framework.RowMapper;
import kr.co.tjoeun.model.entity.DeptVo;

public class DeptDao {

	public void insertOne(DeptVo bean) throws SQLException {
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		String sql="insert into dept (dname,loc) values (?,?)";
		template.queryUpdate(sql, bean.getDname(),bean.getLoc());
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		return template.queryUpdate(sql, bean.getDname(),bean.getLoc(),bean.getDeptno());
	}
	
	public int deleteOne(int deptno) throws SQLException {
		String sql="delete from dept where deptno=?";
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		return template.queryUpdate(sql, deptno);
	}
	
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept";
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		RowMapper<DeptVo> mapper=new RowMapper<DeptVo>(){
			
			@Override
			public DeptVo row(ResultSet rs) throws SQLException {
				DeptVo bean=new DeptVo();
				bean.setDeptno(rs.getInt("deptno"));
				bean.setLoc(rs.getString("loc"));
				bean.setDname(rs.getString("dname"));
				return bean;
			}
		};
		return template.queryForList(sql,mapper);
	}
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql="select * from dept where deptno=?";
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		return (DeptVo) template.queryForObject(sql,new RowMapper(
				) {
			
			@Override
			public DeptVo row(ResultSet rs) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
		}, deptno);
	}
}

