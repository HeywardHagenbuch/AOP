package com.spring.aop.springaop.aspect;


//AOP Configuration

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    //Check if the user has the right access before he can access the method in an entire layer
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Define the method calls that we want to intercept
    //"execution(* packageName.*.*(..))"
    //"execution(* packageName..*.*(..))" // Any calls will get intercepted

    @Before("com.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        logger.info("Check for user access");
        logger.info("Intercepted Method Calls {}", joinPoint);

    }
}
