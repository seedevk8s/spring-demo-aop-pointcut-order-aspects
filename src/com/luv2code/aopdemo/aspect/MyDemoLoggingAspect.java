package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
		// this is where we add all of our related advices for logging
	
		// let's start with an @Before advice
	
	
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		private void forDaoPackage() {
			
		}
	
		// create pointcut for getter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		private void getter() {}
		
		
		// create pointcut for setter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		private void setter() {}
		
		// create pointcut : include package ... exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		private void forDaoPackateNoGetterSetter() {}
		
		
		@Before("forDaoPackateNoGetterSetter()")
		public void beforeAddAccountAdvice() {
		
			System.out.println("\n=======================>>> Executing @Before advice on method");
		
		}
		
		@Before("forDaoPackateNoGetterSetter()")
		public void performApiAnalytics() {
			System.out.println("\n=======================>>> performing API analytics");
		}
		
		@Before("forDaoPackateNoGetterSetter()")
		public void logToCloudAsync() {
			System.out.println("\n=======================>>> Logging to Cloud in async fashion");
		}		

}































