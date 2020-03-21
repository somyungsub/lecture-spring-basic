package egov.jdbc;


import egov.jdbc.spring.UserService;
import egov.jdbc.spring.UserVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/jdbc/egov_spring_jdbc.xml")
public class SpringJdbcTest {

  @Autowired
  UserService userService;

  List<UserVO> list;

  @Before
  public void setup() {
    list = Arrays.asList(
        new UserVO("10", "name10", "pass10")
        , new UserVO("11", "name11", "pass11")
        , new UserVO("12", "name12", "pass12")
    );
  }

  @Test
  public void testSelectOne() {
    testDeleteAll();
    testInsert();
    System.out.println(userService.selectOne("10"));
  }

  @Test
  public void testSelectList() {
    userService.selectList().forEach(System.out::println);
  }

  @Test
  public void testDelete() {
    testBatch();
    System.out.println(" ======== 삭제 전 ======== ");
    userService.selectList().forEach(System.out::println);
    userService.delete("10");
    System.out.println(" ======== 삭제 후 ======== ");
    userService.selectList().forEach(System.out::println);
  }

  @Test
  public void testUpdate() {
    testInsert();
    final UserVO userVO = userService.selectOne("10");
    System.out.println("userVO = " + userVO);
    assertThat(userVO, notNullValue());
    userVO.setName("update name !");
    userService.update(userVO);
    System.out.println("변경 후 " + userService.selectOne(userVO.getId()));
  }

  @Test
  public void testInsert() {
    userService.deleteAll();
    userService.insert(list.get(0));
    final UserVO userVO = userService.selectOne(list.get(0).getId());
    assertThat(userVO, notNullValue());

  }

  @Test
  public void testBatch() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    userService.selectList().forEach(System.out::println);
  }

  @Test
  public void testDeleteAll() {
    userService.deleteAll();
    assertThat(userService.selectList().size(), is(0));
  }

}
