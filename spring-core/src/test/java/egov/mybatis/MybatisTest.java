package egov.mybatis;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/mybatis/egov_mybatis.xml")
public class MybatisTest {

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


  @Test
  public void testSelectOne() {
    testInsert();
    System.out.println(userService.selectOne("10"));
  }

  @Test
  public void testSelectList() {
    final List<UserVO> list = userService.selectList();
    assertNotNull(list);
    list.forEach(System.out::println);
  }

  @Test
  public void testDelete() {
    userService.deleteAll();
    testInsert();
    userService.delete(list.get(0).getId());
  }


  @Test
  public void testDeleteAll() {
    userService.deleteAll();
  }

  @Test
  public void testInsert() {
    userService.deleteAll();
    userService.insert(list.get(0));
  }

  @Test
  public void testUpdate() {
    userService.deleteAll();
    userService.insert(list.get(0));
    final UserVO userVO = userService.selectOne("10");
    assertThat(userVO.getName(), is(list.get(0).getName()));

    String updateName = "nameUpdate";
    userVO.setName(updateName);
    userService.update(userVO);

    final UserVO userVO2 = userService.selectOne("10");
    assertThat(userVO.getName(), is(updateName));

    System.out.println("userVO2 = " + userVO2);


  }
  @Test
  public void testBatch() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
  }

  @Test
  public void testCount() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    System.out.println("userService.count() = " + userService.count());
  }

  @Test
  public void testCount절반() {
    userService.deleteAll();
    userService.insertUserVoBatch(list);
    System.out.println("userService.countAvg절반() = " + userService.countAvg절반());
  }

  // JDK 동적 Proxy 구현 - 수행시간 (ExecuteTime 적용 - AOP 개념 기반)
  @Test
  public void testProxy() {
    UserMapper proxy = (UserMapper) Proxy.newProxyInstance(
        getClass().getClassLoader(),
        new Class[]{UserMapper.class},        // 생성할 타겟 인터페이스
        new ExecuteTime(new UserMapperDao())  // 실제 실행될 서브클래스, ExecuteTime은 Proxy가 생성될 때, 실행될 클래스
    );

    System.out.println(proxy.selectOne("10"));
    System.out.println("proxy.selectList() = " + proxy.selectList());

    proxy.deleteAllUserVO();
  }


  @Test
  public void testDynamic() {
    userService.deleteAll();
    userService.insertUserVoBatch(list2);
    System.out.println(userService.selectDynamic(list2.get(0)));
    System.out.println(userService.selectDynamic(list2.get(1)));
    System.out.println(userService.selectDynamic(list2.get(2)));

  }

  @Test
  public void testWhen() {
    userService.deleteAll();
    userService.insertUserVoBatch(list2);
    userService.selectWhen(list2.get(0)).forEach(System.out::println);
    System.out.println("================");
    userService.selectWhen(list2.get(1)).forEach(System.out::println);
  }

//  Mapper Interface
  @Test
  public void testUserMapperSelectOne(){
    testDeleteAll();
    testBatch();
    System.out.println(userService.selectOneUserMapper("10"));
  }

  @Test
  public void testUserMapperSelectOneTest() {
    testDeleteAll();
    testBatch();
    System.out.println(userService.selectOneTestUserMapper("10"));
  }

  @Test
  public void testUserMapperSelectList() {
    testDeleteAll();
    testBatch();
    userService.selectListUserMapper().forEach(System.out::println);
  }

  @Test
  public void testUserMapperSelectOne2() {
    testDeleteAll();
    testBatch();
    System.out.println(userService.selectOneUserMapper2("10"));
  }

  @Test
  public void testUserMapperSelectList2() {
    testDeleteAll();
    testBatch();
    userService.selectListUserMapper2().forEach(System.out::println);
  }
}
