package egov.practice;

import egov.practice.jdbc.PracticeDao;
import egov.practice.jdbc.PracticeVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/practice/practice_jdbc.xml")
public class PracticeJdbcTest {


  /*
    TODO : etc.egov/practice/practice_jdbc.xml 설정 완성 하기
     - 현재 아래 테스트코드는 설정이 미완성인 관계로 에러가 발생 합니다.
     - 설정을 하여 테스트코드가 정상 작동할 수 있도록 합니다.
   */

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
    // TODO : Select 성공시키기
    System.out.println(dao.selectOne("10"));
  }

  @Test
  public void testInsert(){
    // TODO : Insert 성공시키기
    dao.insert(new PracticeVO("100", "insert100", "asdaas"));
    System.out.println(dao.selectOne("100"));
  }


}
