package kr.co.tjoeun.action;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import kr.co.tjoeun.model.DeptDao;
import kr.co.tjoeun.model.entity.DeptVo;

public class InsertAction extends ActionSupport 
     implements ModelDriven<DeptVo>,Preparable {

	int num=1111;
	DeptVo bean;
	
	public int getNum() {
		return num;
	}
	
	@Override
	public DeptVo getModel() {		
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		if(hasFieldErrors())
		new DeptDao().insertOne(bean);
		return super.SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		bean=new DeptVo();
		
	}
	
	@Override
	public void validate() {
		if(bean.getDname().isEmpty())
			addFieldError("dname", "입력하세요");
		if(bean.getLoc().isEmpty())
			addFieldError("loc", "입력하세요");
	}
	
	
}

