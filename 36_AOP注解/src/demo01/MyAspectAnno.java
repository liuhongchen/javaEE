package demo01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {

    @Pointcut(value="execution(* demo01.OrderDao.save(..))")
    private void pointCutSave(){};
    @Before(value="MyAspectAnno.pointCutSave()")
    public void before(){
        System.out.println("before");
    }

    @AfterReturning(value="execution(* demo01.OrderDao.update(..))",returning = "result")
    public void after(String result){
        System.out.println("after");
        System.out.println(result);
    }

    @Around(value="execution(* demo01.OrderDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前增强");
        Object obj=joinPoint.proceed();//用来执行目标切入点方法
        System.out.println("环绕后增强");
        return obj;
    }

    @AfterThrowing(value="execution(* demo01.OrderDao.find(..))")
    public void afterThrowing(){//只有对应的方法里面出现异常才会执行这个方法
        System.out.println("异常抛出增强");
    }

    @After(value="execution(* demo01.OrderDao.find(..))")
    public void last(){
        System.out.println("最终增强");
    }
}
