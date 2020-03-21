package egov.aop.proxy;

import egov.aop.UserVO;

public class ProxyTestService implements SuperService{

  @Override
  public void insert(UserVO userVO) {
    try {
      Thread.sleep(1500);
      System.out.println(" ProxyTestService insert !");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void delete(UserVO userVO) {
    try {
      Thread.sleep(500);
      System.out.println(" ProxyTestService delete !");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  @Override
  public UserVO selectOne(String id) {
    try {
      Thread.sleep(1000);
      System.out.println(" ProxyTestService selectOne !");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
