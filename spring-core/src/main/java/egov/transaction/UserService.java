package egov.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserDao dao;

  public void insert(UserVO userVO){
    dao.insert(userVO);
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

  public UserVO selectOne(String id) {
    return dao.selectOne(id);
  }

  public List<UserVO> selectList() {
    return dao.selectList();
  }

  public void insertUserVoBatch(List<UserVO> list) {
    dao.insertUserVoBatch(list);
  }

  // 트랜잭션 테스트 메서드

  // 1. select 관련
  public UserVO selectOneInsert(String id) {
    // 트랜잭션에서 read-only = "true" 설정이므로 인설트 작업이 있으면 예외 발생
    insert(new UserVO("222", "insertTest", "12314141"));
    return dao.selectOne(id);
  }

  public UserVO selectOneDelete(String id) {
    // 트랜잭션에서 read-only = "true" 설정이므로 delete 작업이 있으면 예외 발생
    delete(id);
    return dao.selectOne(id);
  }

  public UserVO selectOneUpdate(String id) {
    // 트랜잭션에서 read-only = "true" 설정이므로 update 작업이 있으면 예외 발생
    update(new UserVO("10", "이름변경하기", "12314141"));
    return dao.selectOne(id);
  }

  // 2. insert 관련
  public void insertError(UserVO userVO){
    dao.insert(userVO); // 인설트
    if (dao != null) {  // 예외 -> 롤백됨
      throw new RuntimeException("런타임 예외 발생");
    }
  }

  public void insertDaoRequiredNew(UserVO userVO) {
    dao.insertDaoTransaction(userVO); // 인설트
    if (dao != null) {                // 예외 -> insert 롤백? 확인
      throw new RuntimeException("런타임 예외 발생");
    }
  }

  // 3. update
  public void updateCheckException(UserVO userVO) {
    try {
      dao.update(userVO);
      throw new Exception("예외 발생");
    } catch (Exception e) {
      System.out.println("예외 ~");
      e.printStackTrace();
    }
  }

  // 롤백확인 ->
  public void updateCheckRollbackException(UserVO userVO) throws Exception {
    dao.update(userVO);
    throw new Exception("예외 발생 롤백 안됨");
  }

  // 롤백확인 ->
  public void updateCheckRollbackNoSuchException(UserVO userVO) throws Exception {
    dao.update(userVO);
    throw new NoSuchMethodException("예외 발생 롤백 됨");
  }

  // 롤백확인 ->
  public void updateCheckRollbackNoSuchException2(UserVO userVO) {
    try {
      dao.update(userVO);
      throw new NoSuchMethodException("예외 발생 복구 catch는 롤백 안됨. ");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  // 4. delete
  public void deleteAllServiceError() {
    // delete는 트랜잭션 적용이 안되어 있다.
    dao.deleteAll();  // 롤백안되고 삭제됨 (확인)
    if (dao != null){
      throw new RuntimeException("런타임 예외 발생");
    }
  }

}
