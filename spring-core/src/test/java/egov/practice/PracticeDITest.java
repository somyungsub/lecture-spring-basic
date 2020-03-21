package egov.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/practice/practice_di.xml")
public class PracticeDITest {

  /*
    egov.practice.di 패키지의 class정보를 먼저 확인 해주시기 바랍니다.
   */

  ApplicationContext context;
  @Before
  public void setup() {
    // TODO 1_1. XML 기반의 애플리케이션을 생성하여 Test를 진행합니다.

  }

  @Test
  public void testDL() {

    /*
      TODO 1_2 : bean 설정하여 호출해보기
       1. XML(practice_di.xml)에 PracticeVO를 bean을 등록합니다. (egov.practice.di 패키지 참고)
       2. id 값을 적당한 값으로 설정합니다.
       3. 설정한 bean을 IoC컨테이너로 부터 반환 받아서 사용해봅니다.
     */
  }

  @Test
  public void testDL2() {

    /*
      TODO 1_3 : scope를 prototype 설정해보기
       1. XML(practice_di.xml)에 PracticeVO를 bean을 등록합니다. (egov.practice.di 패키지 참고)
       2. id 값을 적당한 값으로 설정합니다. scope를 prototype으로 설정하여 여러번 호출해서 값을 확인합니다.
     */
  }

  @Test
  public void testSetterDI() {
    /*
      TODO 1_4 : <bean> 하위  property 값 설정을 통해 Setter DI 해보기
       1. XML(practice_di.xml)에 PracticeVO를 bean을 등록합니다. (egov.practice.di 패키지 참고)
       2. id 값을 적당한 값으로 설정합니다.
       3. property의 name 및 value를 설정하여 요청 및 반환하여 Test를 진행합니다.
     */
  }

  @Test
  public void testConstructorArg() {
    /*
      TODO 1_5 : <bean> 하위  constructor-arg 값 설정을 통해 생성자 DI 해보기
       1. XML(practice_di.xml)에 PracticeVO를 bean을 등록합니다. (egov.practice.di 패키지 참고)
       2. id 값을 적당한 값으로 설정합니다.
       3. constructor-age의 name 및 value를 설정하여 요청 및 반환하여 Test를 진행합니다.
     */
  }

}
