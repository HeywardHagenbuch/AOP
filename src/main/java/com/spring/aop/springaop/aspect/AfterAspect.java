package com.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Define the method calls that we want to intercept
    //"execution(* packageName.*.*(..))"
    //"execution(* packageName..*.*(..))" // Any calls will get intercepted

    @AfterReturning(
            value = "com.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution( * com.spring.aop.springaop..*.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("{} returned with value {}", joinPoint, exception);
    }

    @After(value = "execution( * com.spring.aop.springaop..*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("{} returned with value", joinPoint);
    }
}
