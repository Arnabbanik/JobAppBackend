package com.arnabapp.JobApp.Logging;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type fully-qualified-class-name.method-name(arg)
    @Before("execution(* com.arnabapp.JobApp.service.JobService.updateJob(..)) || execution(* com.arnabapp.JobApp.service.JobService.addJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.arnabapp.JobApp.service.JobService.updateJob(..)) || execution(* com.arnabapp.JobApp.service.JobService.addJob(..))")
    public void logMethodCallAfter(JoinPoint jp){
        LOGGER.info("Method Called After " + jp.getSignature().getName());
    }
}
