package egov.aop;


import egov.aop.pointcut.Bean;
import egov.aop.pointcut.Target;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointCutTest {


  @Test
  public void pointcut() throws Exception {
    targetClassPointcutMatches("execution(* *(..))", true, true, true, true, true, true);
    targetClassPointcutMatches("execution(* hello(..))", true, true, false, false, false, false);
    targetClassPointcutMatches("execution(* hello())", true, false, false, false, false, false);
    targetClassPointcutMatches("execution(* hello(String))", false, true, false, false, false, false);
    targetClassPointcutMatches("execution(* meth*(..))", false, false, false, false, true, true);
    targetClassPointcutMatches("execution(* *(int,int))", false, false, true, true, false, false);
    targetClassPointcutMatches("execution(* *())", true, false, false, false, true, true);
    targetClassPointcutMatches("execution(* *.*.*.Target.*(..))", true, true, true, true, true, false);
    targetClassPointcutMatches("execution(* egov.aop.pointcut.Target.*(..))", true, true, true, true, true, false);
    targetClassPointcutMatches("execution(* egov..*.*(..))", true, true, true, true, true, true);
    targetClassPointcutMatches("execution(* *..Target.*(..))", true, true, true, true, true, false);
    targetClassPointcutMatches("execution(* *..Tar*.*(..))", true, true, true, true, true, false);
    targetClassPointcutMatches("execution(* *..*get.*(..))", true, true, true, true, true, false);
    targetClassPointcutMatches("execution(* *..B*.*(..))", false, false, false, false, false, true);
    targetClassPointcutMatches("execution(* *..TargetInterface.*(..))", true, true, true, true, false, false);
    targetClassPointcutMatches("execution(* *(..) throws Runtime*)", false, false, false, true, false, true);
    targetClassPointcutMatches("execution(int *(..))", false, false, true, true, false, false);
    targetClassPointcutMatches("execution(void *(..))", true, true, false, false, true, true);
  }


  private void targetClassPointcutMatches(String expression, boolean... expected) throws Exception{
    pointcutMatches(expression, expected[0], Target.class, "hello");
    pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
    pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
    pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
    pointcutMatches(expression, expected[4], Target.class, "method");
    pointcutMatches(expression, expected[5], Bean.class, "method");

  }

  private void pointcutMatches(String expression, Boolean expected, Class<?> clazz, String methodName, Class<?>... args) throws Exception {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression(expression);

    // 포인트컷 클래스필터, 메서드매처 확인
    assertThat(pointcut.getClassFilter().matches(clazz)
            && pointcut.getMethodMatcher().matches(clazz.getMethod(methodName, args), null)
        , is(expected));
  }

}
