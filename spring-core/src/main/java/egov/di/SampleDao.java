package egov.di;

public interface SampleDao {
  void insert(UserVO userVO);

  void delete(UserVO userVO);

  UserVO selectOne(String id);

  public void print();

}
