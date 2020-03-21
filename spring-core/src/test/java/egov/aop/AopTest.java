package egov.aop;


import egov.aop.proxy.ProxyTestService;
import egov.aop.proxy.ProxyTimeCheck;
import egov.aop.proxy.SuperService;
import org.junit.Before;
import org.junit.Test;

public class AopTest {

  SuperService service;

  @Before
  public void setup() {
    service = new ProxyTestService();
//    service = new ProxyTimeCheck();
  }

  @Test
  public void testTimeCheck() {
    final UserVO userVO = service.selectOne("1");
    System.out.println("userVO = " + userVO);
  }

  @Test
  public void testTimeCheckProxy() {
    service.delete(null);
  }

  @Test
  public void testThrow(){
    service.insert(null);
  }

}
