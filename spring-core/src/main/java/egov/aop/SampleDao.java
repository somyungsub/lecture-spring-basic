package egov.aop;

public interface SampleDao {
  void insert(UserVO userVO);

  void delete(UserVO userVO);

  UserVO selectOne(String id);

  void print();

}
