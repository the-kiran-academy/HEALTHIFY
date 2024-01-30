package com.healthify.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {
	Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

	//pointcut
	@Around("@annotation(com.healthify.api.aop.TrackExecutionTime)")
	public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Method Name = " + pjp.getSignature() + "time taken to execute " + (endTime - startTime) +" ms");
		return obj;

	}

}
