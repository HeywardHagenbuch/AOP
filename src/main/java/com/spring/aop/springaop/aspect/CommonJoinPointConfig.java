package com.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.spring.aop.springaop.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.spring.aop.springaop.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("execution(* com.spring.aop.springaop..*.*(..))")
    public void allLayerExecution(){}

    @Pointcut("bean(*dao*)")
    public void beanContainingDao(){}

    @Pointcut("within(com.spring.aop.springaop.data..*)")
    public void dataLayerExecutionWithin(){}

    @Pointcut("@annotation(com.spring.aop.springaop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
}
