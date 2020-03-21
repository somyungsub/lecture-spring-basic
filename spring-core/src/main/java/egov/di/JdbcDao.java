package egov.di;

import org.springframework.stereotype.Component;



//@Component
//@Qualifier("defaultJdbcDao")


@Component("defaultJdbcDao")
public class JdbcDao implements SampleDao {

  @Override
  public void insert(UserVO userVO) {
    System.out.println("JdbcDao : Insert User");
  }

  @Override
  public void delete(UserVO userVO) {
    System.out.println("JdbcDao : Delete User");
  }

  @Override
  public UserVO selectOne(String id) {
    System.out.println("JdbcDao : Select User");
    return null;
  }

  @Override
  public void print() {
    System.out.println("JdbcDao : print");
  }
}
