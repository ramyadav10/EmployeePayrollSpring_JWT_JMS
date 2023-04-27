package com.example.demo.aspectservice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectjService {

	@Before(value = "execution(* com.example.demo.service.EmployeeService.*(..))")  
	public void Before(JoinPoint joinPoint) {
		System.out.println("Before: "+joinPoint.getSignature().getName());
		
	}
	
	@After(value = "execution(* com.example.demo.service.EmployeeService.*(..))") 
	public void After(JoinPoint joinPoint) {
		System.out.println("After: "+Arrays.toString(joinPoint.getArgs()));
	}
	
	
	
}
