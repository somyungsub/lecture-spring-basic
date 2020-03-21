package egov.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExecuteTime implements InvocationHandler {

  UserMapper userMapper; // UserMapper 구현체로 한정!
  public ExecuteTime(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  //  Object userMapper; // 모든타겟 구현체로 한정!
//  public ExecuteTime(Object userMapper) {
//    this.userMapper = userMapper;
//  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long start = System.nanoTime() / 1_000_000;
    final Object result = method.invoke(userMapper, args);
    long end = System.nanoTime() / 1_000_000;
    System.out.println("수행시간 : " + (end - start) + "ms!");
    return result;
  }
}
