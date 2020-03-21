package egov.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

  SampleDao dao;
  SampleDao dao2;

  @Autowired
  public void setDao(SampleDao defaultJdbcDao) {
    this.dao = defaultJdbcDao;
  }

  //  @Autowired
//  public UserService(@Qualifier("springJdbcDao") SampleDao dao) {
//    this.dao = dao;
//  }

  @Autowired
  public UserService(
        @Qualifier("springJdbcDao") SampleDao dao
      , @Qualifier("defaultJdbcDao") SampleDao dao2) {
    this.dao = dao;
    this.dao2 = dao2;
  }

  public void insert(UserVO userVO) {
    dao.insert(userVO);
  }

  public void delete(UserVO userVO) {
    dao.delete(userVO);
  }

  public void selectOne(String id) {
    System.out.println("dao");
    dao.selectOne(id);
    System.out.println("dao2");
    dao2.selectOne(id);

  }


  @PostConstruct
  public void init() {
    System.out.println("service init call");
  }
}
