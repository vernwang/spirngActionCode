package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	@Pointcut("execution(* concert.Performance.perform(..) &&  within(concert.*) and bean('hello') and !bean(\"man\"))")
	public void perform() {}
	
	@Before("perform()")
	public void  silenceCellPhone() {
	}
	
	@After("execution(* concert.Performance.perform(..))")
	public void takeSeats() {
	}
	
	@Around("perform()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("je");
			jp.proceed();
			System.out.println("jel");
			
			
		} catch (Throwable e) {
			// TODO: handle exception
		}
		
	}
	
	
	
}
