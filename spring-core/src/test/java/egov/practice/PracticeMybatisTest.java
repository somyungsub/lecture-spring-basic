package egov.practice;

import egov.practice.mybatis.PracticeDao;
import egov.practice.mybatis.PracticeVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/practice/practice_mybatis.xml")
public class PracticeMybatisTest {


  @Autowired
  PracticeDao dao;

  List<PracticeVO> list;

  @Before
  public void setup(){
    list = Arrays.asList(
        new PracticeVO("10", "name10", "pass10")
        , new PracticeVO("11", "name11", "agjsajdka")
        , new PracticeVO("12", "name12", "kqokewqokeoq")
        , new PracticeVO("13", "name12", "gpaasdasio")
        , new PracticeVO("14", "name12", "asda")
        , new PracticeVO("15", "name12", "aadd")
        , new PracticeVO("16", "name12", "gggqqweq")
        , new PracticeVO("17", "name12", "akasoksoakdao")
        , new PracticeVO("18", "name12", "1123")
        , new PracticeVO("19", "name12", "ggq")
        , new PracticeVO("20", "name12", "aasd")
    );
    dao.deleteAll();
    dao.batch(list);
  }

  @Test
  public void testSelectOne(){
    // TODO : Select 해보기
  }

  @Test
  public void testInsert(){
    // TODO : Insert 해보기
  }

  @Test
  public void testDelete(){
    // TODO : Delete 해보기
  }

  @Test
  public void testUpdate(){
    // TODO : Update 해보기
  }

  @Test
  public void testDynamicIf(){
    // TODO : if 문 작성 해보기
  }

  @Test
  public void testDynamicChoose(){
    // TODO : choose 문 작성 해보기
  }



}
