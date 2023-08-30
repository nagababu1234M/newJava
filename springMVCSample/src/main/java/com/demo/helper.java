package com.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class helper {
	
    @Before("execution(public ModelAndView void add())")
	public void helperMethod() {
		System.out.println("loading aspect");
	}
}
