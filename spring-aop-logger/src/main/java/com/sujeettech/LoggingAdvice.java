package com.sujeettech;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

	//@Before("execution(* com.sujeettech.*.*.*(..))")
	@Before("execution(* com.sujeettech.*.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getClass().getName() + " : " + joinPoint.getSignature().getName() + "()" );
	}
	
	@AfterReturning(value = "execution(* com.sujeettech.*.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		System.out.print(joinPoint.getTarget().getClass().getName() + " ");
		System.out.println("Result for method " + joinPoint.getSignature().getName());
		System.out.println("Result " + result);
	}
	
	@Before("execution(* com.sujeettech.*.*.*.*(..))")
	public void beforeImpl(JoinPoint joinPoint) {
		System.out.println(joinPoint.getClass().getName() + " : " + joinPoint.getSignature().getName() + "()" );
	}
	
	@AfterReturning(value = "execution(* com.sujeettech.*.*.*.*(..))", returning = "result")
	public void afterReturningImpl(JoinPoint joinPoint, Object result) {
		System.out.print(joinPoint.getTarget().getClass().getName() + " ");
		System.out.println("Result for method " + joinPoint.getSignature().getName());
		System.out.println("Result " + result);
	}
}
