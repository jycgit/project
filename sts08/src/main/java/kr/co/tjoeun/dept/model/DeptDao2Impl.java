package kr.co.tjoeun.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.dept.model.entity.DeptVo;

@Repository
public class DeptDao2Impl implements DeptDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		return sqlSession.selectList("dept.selectAll");
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		return sqlSession.selectOne("dept.selectOne",deptno);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		sqlSession.insert("dept.insertOne", bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		return sqlSession.update("dept.updateOne",bean);
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		return sqlSession.delete("dept.deleteOne", deptno);
	}

}
