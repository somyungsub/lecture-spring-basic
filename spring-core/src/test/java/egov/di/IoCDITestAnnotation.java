package egov.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/di/egov_annotation.xml")
public class IoCDITestAnnotation {

  @Autowired
  SampleDao defaultJdbcDao; // 필드명 == Component 값

  @Autowired
  SampleDao springJdbcDao;  // 필드명 == 클래스명

  /*
  * 필드명이 클래스명가 불일치
  * -> Qualifier 활용(Class명 or @Component value 값)
  * */
  @Autowired
  @Qualifier("defaultJdbcDao")
  SampleDao dao;

  @Autowired
  @Qualifier("springJdbcDao")
  SampleDao dao2;

  @Test
  public void testAutowired() {
    System.out.println(defaultJdbcDao);
    System.out.println(springJdbcDao);
    System.out.println(dao);
    System.out.println(dao2);
  }

  @Autowired
  UserService userService;

  @Test
  public void testSetterAutowire() {
    userService.selectOne("1");
  }

  @Test
  public void testQualifier() {
    userService.selectOne("1");
  }
}
