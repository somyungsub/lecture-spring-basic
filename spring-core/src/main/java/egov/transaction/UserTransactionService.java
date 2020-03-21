package egov.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(
    propagation = Propagation.REQUIRED,
    readOnly = false,
    timeout = -1,
    isolation = Isolation.DEFAULT
)
public class UserTransactionService {

  @Autowired
  UserDao dao;

  public void insert(UserVO userVO){
    dao.insert(userVO);
  }

  public UserVO selectOne(String id) {
    return dao.selectOne(id);
  }

  public List<UserVO> selectList() {
    return dao.selectList();
  }

  public void update(UserVO userVO) {
    dao.update(userVO);
  }

  public void delete(String id) {
    dao.delete(id);
  }

  public void deleteAll() {
    dao.deleteAll();
  }

  public void insertUserVoBatch(List<UserVO> list) {
    dao.insertUserVoBatch(list);
  }

  @Transactional(readOnly = true)
  public UserVO selectOneInsert(String id) {
    // 트랜잭션에서 readOnly = true 설정이므로 insert 작업이 있으면 예외 발생
    insert(new UserVO("222", "insertTest", "12314141"));
    return dao.selectOne(id);
  }

  @Transactional(timeout = 2)
  public void insertTimeOut(UserVO userVO){
    // 해당 메서드가 작업하는데 2초 이상 소유 되면 롤백된다. (조회는 제외)
    try {
      System.out.println("3초 전 insert 전 = " + dao.selectOne(userVO.getId()));
      dao.insert(userVO); // Insert 확인
      System.out.println("3초 전 insert 후  = " + dao.selectOne(userVO.getId()));

      Thread.sleep(3000);
      System.out.println("3초 후 select = " + dao.selectOne(userVO.getId()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Transactional(timeout = 2)
  public void insertTimeOut2(UserVO userVO){
    // 해당 메서드가 작업하는데 2초 이상 소유 되면 롤백된다.
    try {
      System.out.println("3초 전 insert 전 = " + dao.selectOne(userVO.getId()));
      dao.insert(userVO); // Insert 확인
      System.out.println("3초 전 insert 후  = " + dao.selectOne(userVO.getId()));

      Thread.sleep(3000);
      dao.insert(new UserVO("201", "insert Error 2", "1234")); // Insert 확인
//      dao.delete(userVO.getId());
      System.out.println("3초 후 select = " + dao.selectOne(userVO.getId()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
