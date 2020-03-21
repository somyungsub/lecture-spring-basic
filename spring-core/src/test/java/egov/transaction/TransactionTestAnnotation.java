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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/transaction/egov_transaction.xml")
public class TransactionTestAnnotation {

  @Autowired
  UserTransactionService userService;

  List<UserVO> list;

  @Before
  public void setup() {
    list = Arrays.asList(
        new UserVO("10", "name10", "pass10")
        , new UserVO("11", "name11", "pass11")
        , new UserVO("12", "name12", "pass12")
    );
  }

  // 2. Annotation 기반
  @Test
  public void testSelectOne() {
    System.out.println(userService.selectOne("10"));
  }

  @Test
  public void testDelete() {
    userService.delete("200");
  }

  @Test
  public void testBatch(){
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);
  }

  // select
  @Test
  public void testSelectInsertReadOnly(){
    // 예외발생 확인
    testBatch();
    System.out.println(userService.selectOneInsert("10"));
  }

  // insert
  @Test
  public void testInsertTimeOut(){
    userService.deleteAll();
    userService.insertTimeOut(new UserVO("200", "insert Error", "1234"));
    System.out.println("완료");
  }

  @Test
  public void testInsertTimeOut2(){
    userService.deleteAll();
    userService.insertTimeOut2(new UserVO("200", "insert Error", "1234"));
    System.out.println("완료");
  }

}
