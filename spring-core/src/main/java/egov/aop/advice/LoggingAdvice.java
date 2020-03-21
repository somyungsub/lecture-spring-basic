package egov.aop.advice;

import org.aspectj.lang.JoinPoint;

import java.util.Optional;

public class LoggingAdvice {

  // Before Advice
  public void methodInfo(JoinPoint joinPoint) {
    System.out.println("============== Before Advice ==============");
    System.out.println(" Method Call =>  " + joinPoint.getSignature().toShortString());

    final Object[] args = joinPoint.getArgs();
    final Optional<Object> optional = Optional.ofNullable(args)
        .flatMap(objects -> Optional.ofNullable(objects[0]));
    System.out.print("Parameter Args => ");
    System.out.println(optional.orElseGet(() -> "NoData"));
  }

  // After Advice
  public void afterMethod(JoinPoint joinPoint) {
    System.out.println("============== After Advice ==============");
    System.out.println(joinPoint.getSignature().toLongString());
  }

  // After Returning
  public Object afterReturning(JoinPoint joinPoint, Object returnVal) {
    System.out.println("============== AfterReturning Advice ==============");
    System.out.println("매개변수 returnVal은 바인딩변수");
    System.out.println("리턴 값 : " + returnVal);
    return returnVal;
  }

  // After Throwing
  public void afterThrowing(JoinPoint joinPoint, Exception ex) {
    System.out.println("============== AfterThrowing Advice ==============");
    System.out.println("매개변수 ex는 바인딩변수");
    System.out.println("예외발생 : " + ex.getMessage());
  }

}
