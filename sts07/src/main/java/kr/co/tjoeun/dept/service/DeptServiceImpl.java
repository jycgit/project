package kr.co.tjoeun.dept.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao<DeptVo> deptDao;

	@Override
	public void listMapping(Model model) throws Exception {
		model.addAttribute("list", deptDao.selectAll());

	}

	@Override
	public void objMapping(Model model, int deptno) throws Exception {
		model.addAttribute("bean", deptDao.selectOne(deptno));

	}
    
	@Transactional
	@Override
	public void addData(DeptVo bean) throws Exception {
		deptDao.insertOne(bean);

	}

	@Transactional
	@Override
	public void updateData(DeptVo bean) throws Exception {
		if(0==deptDao.updateOne(bean))
            throw new SQLException("수정실패");
	}

	@Transactional
	@Override
	public void deleteData(int deptno) throws Exception {
		if(0==deptDao.deleteOne(deptno))
			throw new SQLException("삭제 실패");
	}

}
