package kr.co.tjoeun.dept.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Override
	public List<DeptVo> list() throws SQLException {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();	
				){
			DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
			return deptDao.selectAll();
		}
	}

	@Override
	public DeptVo One(int param) throws SQLException {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();	
				){
			DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
			return deptDao.selectOne(param);
		}
	}

	@Override
	public boolean add(DeptVo bean) throws SQLException {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();
				){
			DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
			deptDao.insertOne(bean);
			return true;
		}
	}

	@Override
	public boolean edit(DeptVo bean) throws SQLException {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();	
				){
			DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
			return deptDao.updateOne(bean)>0?true:false;
		}
	}

	@Override
	public boolean remove(int param) throws SQLException {
		try(
			SqlSession sqlSession=sqlSessionFactory.openSession();	
				){
			DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
			return deptDao.deleteOne(param)>0?true:false;
		}
	}

}

