package kr.co.tjoeun.action;

import com.opensymphony.xwork2.*;

import kr.co.tjoeun.model.entity.DeptVo;

public class Ex02Action implements Validateable, Action, ModelDriven<DeptVo>, Preparable {
       DeptVo bean;
       boolean boo;
 //    DeptVo bean=new DeptVo();
       //입력시 기존값 표시
       public DeptVo getBean() {
    	   return bean;
       }
       
       ValidationAwareSupport ValidationAware=new ValidationAwareSupport();
       public ValidationAwareSupport getValidationAware() {
		   return ValidationAware;
	}
       
     @Override
    public void prepare() throws Exception {
//    	 System.out.println("1.prepare");
    	 bean=new DeptVo();
    }
     
     @Override
    public DeptVo getModel() {
//    	 System.out.println("2.getModel");
    	return bean;
    }
     
     @Override
    public void validate() {
//    	System.out.println("3.validate");
    	if(bean.getDeptno()==0)ValidationAware.addFieldError("deptno", "부서번호가 비었음");
        if(bean.getDname().isEmpty())ValidationAware.addFieldError("err", "이름이 비었음");
        if(bean.getLoc().isEmpty())ValidationAware.addFieldError("loc", "지역명이 비었음");   
     }
     
     
	@Override
	public String execute() throws Exception {
		if(ValidationAware.hasFieldErrors()) return INPUT;
	    System.out.println(bean);
	 	return SUCCESS;
	}

}
