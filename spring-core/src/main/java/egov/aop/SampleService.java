package egov.aop;

public interface SampleService {
  void insert(UserVO userVO);

  void delete(UserVO userVO);

  UserVO selectOne(String id);

  public void print();

}
