package egov.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;

public class ExecuteTimeAdvice implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("============ Advisor ============");
    System.out.println("invocation.getMethod().getName() = " + invocation.getMethod().getName());
    return null;
  }

  // Around Advice
  public Object executeTime(ProceedingJoinPoint joinPoint) {
    Object result = null;
    try {
      final String targetName = joinPoint.getTarget().getClass().getSimpleName();
      final String methodName = joinPoint.getSignature().toLongString();
      System.out.println("============== Around Advice(전) ==============");
      System.out.println(targetName + " Call!");
      System.out.println(methodName + " 실행 중..");
      long start = System.nanoTime() / 1_000_000;
      result = joinPoint.proceed();
      System.out.println("============== Around Advice(후) ==============");
      long end = System.nanoTime() / 1_000_000;
      System.out.println(methodName + " 실행 완료 시간 : " + (end - start) + "ms");
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return result;
  }
}
