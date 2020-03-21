package egov.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("service")
public class ProxyTimeCheck implements SampleService {

  @Autowired
  SampleService userService;  // 타겟

  @Override
  public void insert(UserVO userVO) {
    long start = System.nanoTime() / 1_000_000;
    userService.insert(userVO);
    long end = System.nanoTime() / 1_000_000;
    System.out.println("처리시간 : " + (end-start) + "ms");
  }

  @Override
  public void delete(UserVO userVO) {
    long start = System.nanoTime() / 1_000_000;
    userService.delete(userVO);
    long end = System.nanoTime() / 1_000_000;
    System.out.println("처리시간 : " + (end-start) + "ms");
  }

  @Override
  public UserVO selectOne(String id) {
    long start = System.nanoTime() / 1_000_000;
    userService.selectOne(id);
    long end = System.nanoTime() / 1_000_000;
    System.out.println("처리시간 : " + (end-start) + "ms");
    return null;
  }

  @Override
  public void print() {

  }
}
