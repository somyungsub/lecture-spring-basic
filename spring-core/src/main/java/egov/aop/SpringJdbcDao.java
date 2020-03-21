package egov.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbcDao {

  @Value("#{systemProperties['file.separator']}")
  private String s;

  public void setS(String s) {
    this.s = s;
  }

  public void insert(UserVO userVO) {
    try {
      Thread.sleep(1500);
      System.out.println("SpringJdbcDao : Insert User");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public void delete(UserVO userVO) {
    try {
      Thread.sleep(500);
      System.out.println("SpringJdbcDao : Delete User");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public UserVO selectOne(String id) {
    try {
      Thread.sleep(1000);
      System.out.println("SpringJdbcDao : Select User");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    final UserVO userVO = new UserVO();
    userVO.setAge(32);
    userVO.setId(id);
    userVO.setName("테스트");
    return userVO;
  }

  public void print() {
    System.out.println("file 구분자 : " + s);
  }

  public void aopThrowTest() throws Exception {
    throw new Exception();
  }
}
