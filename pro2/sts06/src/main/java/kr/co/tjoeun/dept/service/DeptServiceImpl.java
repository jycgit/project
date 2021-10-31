package kr.co.tjoeun.dept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.co.tjoeun.dept.model.DeptDao;
import kr.co.tjoeun.dept.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao deptDao;

	@Override
	public void getList(Model model) throws Exception {
		//model.addAttribute("total", deptDao.getTotal());
		model.addAttribute("list", deptDao.selectAll());
	}

	@Override
	public void getOne(Model model, int key) throws Exception {
		model.addAttribute("bean", deptDao.selectOne(key));
	}

	@Transactional
	@Override
	public void insert(DeptVo target) throws Exception {
		deptDao.insertOne(target);
	}

	@Override
	public boolean update(DeptVo target) throws Exception {
		return deptDao.updateOne(target)>0?true:false;
	}

	@Override
	public boolean delete(int key) throws Exception {
		return deptDao.deleteOne(key)>0?true:false;
	}

}
