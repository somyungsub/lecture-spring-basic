package egov.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  SpringJdbcDao dao;

  public void insert(UserVO userVO){
    dao.insert(userVO);
    throw new RuntimeException("비검사 예외발생!!~!");
//    try {
//      throw new Exception("검사예외발생");
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }

  public void delete(UserVO userVO) {
    dao.delete(userVO);
  }

  public UserVO selectOne(String id) {
    long start = System.nanoTime() / 1_000_000;
    dao.selectOne(id);
    long end = System.nanoTime() / 1_000_000;
    System.out.println("처리시간 : " + (end - start) + "ms");
    return null;
  }

  public void print() {
    System.out.println("print!!!");
  }
}
