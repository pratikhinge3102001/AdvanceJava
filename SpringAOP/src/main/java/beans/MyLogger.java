package beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyLogger {

	@Pointcut("execution(* beans.Student.*(..))")
	public void selectAll() {}
	
	@Pointcut("execution(String beans.Student.getName())")
	public void selectGetName() {}
	
	
	@Before("selectAll()")
	public void createLog()
	{
		System.out.println("some extra task before the business logic");
	}
	
	@After("selectGetName()")
	public void afterLogic()
	{
		System.out.println("some extra task after business logic");
	}
	
	
}
