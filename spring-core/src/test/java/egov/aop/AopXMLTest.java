package egov.aop;


import egov.aop.pointcut.Bean;
import egov.aop.pointcut.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/aop/egov_aop.xml")
public class AopXMLTest {

  @Autowired
  UserService service;

  @Test
  public void testSelect() {
    final UserVO userVO = service.selectOne("1");
    System.out.println("userVO = " + userVO);
  }

  @Test
  public void testDelete() {
    service.delete(null);
  }

  @Test
  public void testThrow(){
    service.insert(null);
  }

  @Test
  public void testAdvisor() {
    service.print();
  }

}
