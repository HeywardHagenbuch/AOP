package com.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Define the method calls that we want to intercept
    //"execution(* packageName.*.*(..))"
    //"execution(* packageName..*.*(..))" // Any calls will get intercepted

    @Around(value = "com.spring.aop.springaop.aspect.CommonJoinPointConfig.allLayerExecution()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //StartTime  = x
        long startTime  = System.currentTimeMillis();
        // allow execution of method
        proceedingJoinPoint.proceed();
        //End time  = y
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {}", proceedingJoinPoint, timeTaken);
    }

}
