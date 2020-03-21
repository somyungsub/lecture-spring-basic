package egov.transaction;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/transaction/egov_transaction.xml")
public class TransactionTestXML {

  @Autowired
  UserService userService;

  List<UserVO> list;
  List<UserVO> list2;

  @Before
  public void setup() {
    list = Arrays.asList(
        new UserVO("10", "name10", "pass10")
        , new UserVO("11", "name11", "pass11")
        , new UserVO("12", "name12", "pass12")
    );

    list2 = Arrays.asList(
        new UserVO("20", "name20", "pas")
        , new UserVO("21", "name21", "pass11")
        , new UserVO("22", "name22", "pass")
    );
  }

  // 1. XML 기반
  @Test
  public void testSelectOne() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    System.out.println(userService.selectOne("10"));
  }

  // select
  @Test
  public void testSelectInsert(){
    System.out.println(userService.selectOneInsert("10"));
  }
  @Test
  public void testSelectDelete(){
    System.out.println(userService.selectOneDelete("10"));
  }
  @Test
  public void testSelectUpdate(){
    userService.selectList().forEach(System.out::println);
    System.out.println(userService.selectOneUpdate("10"));
  }

  // insert
  @Test
  public void testInsertError(){
	userService.deleteAll();
	userService.insertUserVoBatch(list);
    userService.insertError(new UserVO("200", "insert Error", "1234"));
    System.out.println("완료");
  }

  @Test
  public void testInsertDaoRequiredNew(){
	userService.deleteAll();
	userService.insertUserVoBatch(list);
    userService.insertDaoRequiredNew(new UserVO("201", "insert Error", "1234"));
    System.out.println("완료");
  }

  // update
  @Test
  public void testUpdateCheckException() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);

    UserVO userVO = new UserVO("10", "10 rename ", "1234"); // 변경 확인
    userService.updateCheckException(userVO);
    System.out.println("완료");
  }

  @Test
  public void testUpdateRollback() throws Exception {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);

    UserVO userVO = new UserVO("10", "10 rename2 ", "1234"); // 변경 확인
    userService.updateCheckRollbackException(userVO);
    System.out.println("완료");
  }

  @Test
  public void testUpdateRollback2() throws Exception {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);

    UserVO userVO = new UserVO("10", "10 rename2 ", "1234"); // 변경 확인
    userService.updateCheckRollbackNoSuchException(userVO);
    System.out.println("완료");
  }

  @Test
  public void testUpdateRollback3() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);

    UserVO userVO = new UserVO("10", "10 rename2 ", "1234"); // 변경 확인
    userService.updateCheckRollbackNoSuchException2(userVO);
    System.out.println("완료");
  }

  // delete => 트랜잭션이 적용 되어 있지 않음
  @Test
  public void testDeleteErrorTransaction() {
    userService.deleteAll();              // 전부 삭제
    userService.insertUserVoBatch(list2); // list2 배치 처리
    
    // 에러 발생! ->  deleteAll 이 내부 수행 (전체삭제 확인, delete는 트랜잭션 정의를 안함)
    userService.deleteAllServiceError();  
    System.out.println("완료");
  }

}
