package project_conten_02.prokhnov.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllersAspect {
    private final String ARR = " >>> ";

    @Before("execution(public * project_conten_02.prokhnov.controller.*.save* (..))")
    public void logBeforeSave(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.update* (..))")
    public void logBeforeUpdate(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.delete* (..))")
    public void logBeforeDelete(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.add* (..))")
    public void logBeforeAdd(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.getAll* (..))")
    public void logBeforeGetAll(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.create* (..))")
    public void logBeforeCreate(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.upload* (..))")
    public void logBeforeUpload(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public * project_conten_02.prokhnov.controller.*.download* (..))")
    public void logBeforeDownload(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }
}
