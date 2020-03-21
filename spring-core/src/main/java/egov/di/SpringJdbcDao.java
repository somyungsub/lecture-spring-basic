package egov.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcDao implements SampleDao {

  @Value("#{systemProperties['file.separator']}")
  private String s;

  public void setS(String s) {
    this.s = s;
  }

  @Override
  public void insert(UserVO userVO) {
    System.out.println("SpringJdbcDao : Insert User");
  }

  @Override
  public void delete(UserVO userVO) {
    System.out.println("SpringJdbcDao : Delete User");
  }

  @Override
  public UserVO selectOne(String id) {
    System.out.println("SpringJdbcDao : Select User");
    return null;
  }

  @Override
  public void print() {
    System.out.println(s);
  }
}
