package kr.co.tjoeun.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AopObject {

//	@Before(value = "execution(* kr.co.tjoeun.dept.service.DeptServiceImpl.*(..))")
	public void beforeMethod(JoinPoint thisJoinPoint) {
		System.out.println("������.....");
	}
	
//	@After(value = "execution(* kr.co.tjoeun.dept.service.DeptServiceImpl.*(..))")
	public void afterMethod(JoinPoint thisJoinPoint) {
		System.out.println("�������׻�...");
	}
	
//	@AfterReturning(returning = "obj",value = "execution(* kr.co.tjoeun.dept.service.DeptServiceImpl.*(..))")
	public void afterReturnMethod(JoinPoint thisJoinPoint, Object obj) {
		System.out.println("�����ļ�����������..."+obj);
	}
	
//	@AfterThrowing(value = "execution(* kr.co.tjoeun.dept.service.DeptServiceImpl.*(..))")
	public void afterThrowsMethod(JoinPoint thisJoinPoint,Exception ex) {
		System.out.println("������exception�� �߻���������...");
	}
	
//	@Around(value = "execution(* kr.co.tjoeun.dept.service.DeptServiceImpl.*(..))")
	public Object aroundMethod(ProceedingJoinPoint thisJoinPoint)throws Throwable {
		System.out.println("before");
		Object obj=null;
		try {
			obj=thisJoinPoint.proceed();
			System.out.println("afterReturn");
		}catch (Exception e) {
			System.out.println("afterThrows");
		}
		System.out.println("after");
		return obj;
	}
}










