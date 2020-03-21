package egov.di;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/di/egov_di.xml")
public class IoCDITestXML {

  ApplicationContext context;

  @Before
  public void setup() {
    context = new GenericXmlApplicationContext("etc.egov/di/egov_di.xml");
  }

  @Test
  public void testId() {
    final UserVO userVO = context.getBean("userVO", UserVO.class);
    System.out.println(userVO);
  }

  @Test
  public void testName() {
    final UserVO anotherUser = context.getBean("anotherUser", UserVO.class);
    System.out.println(anotherUser);
  }

  @Test
  public void testNameAlias() {
    final UserVO anotherUser = context.getBean("anotherUser", UserVO.class);
    final UserVO anotherUser2 = context.getBean("anotherUser2", UserVO.class);
    final UserVO anotherUser3 = context.getBean("anotherUser3", UserVO.class);
    System.out.println(anotherUser);
    System.out.println(anotherUser2);
    System.out.println(anotherUser3);
  }

  @Test
  public void testLazy() {
    final UserVOLazy lazyUserVO = context.getBean("lazyUserVO", UserVOLazy.class);
    System.out.println(lazyUserVO);
  }

  @Test
  public void testSingle() {
    final UserVO userVOSingle = context.getBean("userVOSingle", UserVO.class);
    final UserVO userVOSingle2 = context.getBean("userVOSingle", UserVO.class);
    final UserVO userVOSingle3 = context.getBean("userVOSingle", UserVO.class);
    System.out.println(userVOSingle);
    System.out.println(userVOSingle2);
    System.out.println(userVOSingle3);
  }

  @Test
  public void testPrototype() {
    final UserVO userVOSingle = context.getBean("userVOPrototype", UserVO.class);
    final UserVO userVOSingle2 = context.getBean("userVOPrototype", UserVO.class);
    final UserVO userVOSingle3 = context.getBean("userVOPrototype", UserVO.class);
    System.out.println(userVOSingle);
    System.out.println(userVOSingle2);
    System.out.println(userVOSingle3);
  }

  @Test
  public void testInitDestroy() {
    UserVO userInitDestroyMethod = context.getBean("userInitDestroyMethod", UserVO.class);
    System.out.println(userInitDestroyMethod);
  }

  @Test
  public void testSetterInjection() {
    final UserVO userSetter = context.getBean("userSetter", UserVO.class);
    System.out.println("userSetter = " + userSetter);
  }

  @Test
  public void testConstructorInjection() {

    final UserVO userSetter = context.getBean("userConstructor", UserVO.class);
    System.out.println("userConstructor = " + userSetter);
  }
  
  @Test
  public void testInnerBean() {
    final UserVO userInnerBean = context.getBean("userInnerBean", UserVO.class);
    final UserVO userInnerBean2 = context.getBean("userInnerBean", UserVO.class);
    System.out.println("userInnerBean = " + userInnerBean);
    System.out.println("userInnerBean2 = " + userInnerBean2);
  }

  @Test
  public void testCollection() {
    final UserVO userCollection = context.getBean("userCollection", UserVO.class);
    System.out.println(userCollection);
  }

  /*
  * <bean id="springJdbcDao2 ... />  또는
  * <bean name="springJdbcDao2 ... /> 주입
  * */
//  @Resource(name = "springJdbcDao2")
//  private SampleDao springJdbcDao5;

  /*
  * 1개인 경우 , <bean class="*..SpringJdbcDao"/> 타입
  * 여러개 인 경우, 필드명 == id값 or 필드명 == name값 매핑되는 <bean> 주입
  * */
  @Resource(name = "springJdbcDao")
  private SampleDao springJdbcDao;

  @Test
  public void testResource() {
//    springJdbcDao5.print();
//    System.out.println(springJdbcDao5);

    springJdbcDao.print();
    System.out.println(springJdbcDao);
  }

  @Resource
  Dept dept;

  @Test
  public void testDept() {
    System.out.println(dept);
    System.out.println(context.getBean("dept"));
  }


  @After
  public void close() {
    ((GenericXmlApplicationContext) context).destroy();
  }
}
