package com.apress.prospring5.ch5;

import com.apress.prospring5.ch2.common.Guitar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotatedAdvice {
    @Pointcut("execution(* com.apress.prospring5.ch5..sing*(com.apress.prospring5.ch2.common.Guitar)) && args(value)")
    public void singExecution(Guitar value) {
    }

    @Pointcut("execution(* com.apress.prospring5.ch5..smoke*())")
    public void smokeExecution() {
    }

    @Pointcut("bean(john*)")
    public void isJohn() {
    }

    @Before("singExecution(value) && isJohn()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if (value.getBrand().equals("Gibson")) {
            System.out.println("Executing: " +
                    joinPoint.getSignature().getDeclaringTypeName() + " "
                    + joinPoint.getSignature().getName() + " argument: " + value.getBrand());
        }
    }

    @After("smokeExecution() && isJohn()")
    public void simpleAfterAdvice(JoinPoint joinPoint) {
        System.out.println("After (finally) Executing: " +
                joinPoint.getSignature().getDeclaringTypeName()+ " "
                + joinPoint.getSignature().getName());
    }

    @Around("singExecution(value) && isJohn()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) throws Throwable {
        System.out.println("Before execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName()
                + " argument: " + value.getBrand());

        Object retVal = pjp.proceed();

        System.out.println("After execution: " +
                pjp.getSignature().getDeclaringTypeName() + " "
                + pjp.getSignature().getName()
                + " argument: " + value.getBrand());

        return retVal;
    }
}
