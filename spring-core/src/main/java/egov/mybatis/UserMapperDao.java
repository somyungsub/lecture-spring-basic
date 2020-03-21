package egov.mybatis;

import java.util.List;

public class UserMapperDao implements UserMapper {


  @Override
  public UserVO selectOne(String id) {
    System.out.println("id = " + id);
    return null;
  }

  @Override
  public UserVO selectOneTest(String id) {
    System.out.println("id test = " + id);
    return null;
  }

  @Override
  public List<UserVO> selectList() {
    System.out.println("list");
    return null;
  }

  @Override
  public void deleteAllUserVO() {
    System.out.println("deleteAll");
  }
}
