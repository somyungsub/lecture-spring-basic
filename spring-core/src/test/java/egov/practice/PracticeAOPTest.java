package egov.practice;

import egov.practice.aop.PracticeService;
import egov.practice.aop.PracticeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/practice/practice_aop.xml")
public class PracticeAOPTest {

  /*
    - egov.practice.aop 패키지의 class정보를 먼저 확인 해주시기 바랍니다.

    TODO 초기작업
    1. PracticeAdvice 에서 각 JoinPoint에 대한 Advice 내용을 작성합니다.
    2. XML 설정정보를 작성합니다.
       Test 코드에서 설정 후 Test 진행
   */

  @Autowired
  PracticeService practiceService;


  @Test
  public void testBeforeAdvice() {

    /*
      TODO 2_1 : XML에 Before Advice 설정 후 사용하기
       1. XML(practice_aop.xml)에 aop:before 설정
       2. PracticeService.test 메서드를 pointcut으로 설정
     */
  }

  @Test
  public void testAfterAdvice() {
    /*
      TODO 2_2 : XML에 After Advice 설정 후 사용하기
       1. XML(practice_aop.xml)에 aop:after 설정
       2. PracticeService.delete* 메서드를 pointcut으로 설정
     */

  }

  @Test
  public void testAroundAdvice() {
    /*
      TODO 2_3 : XML에 Around Advice 설정 후 사용하기
       1. XML(practice_aop.xml)에 aop:around 설정
       2. PracticeService.select* 메서드를 pointcut으로 설정
     */
  }

  @Test
  public void testAfterReturningAdvice() {
    /*
      TODO 2_4 : XML에 AfterReturning Advice 설정 후 사용하기
       1. XML(practice_aop.xml)에 aop:after-returning 설정
       2. PracticeService.select* 메서드를 pointcut으로 설정
     */
  }

}
