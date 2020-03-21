package egov.jdbc.spring;

import java.util.List;

public interface SampleDao {
  void insert(UserVO userVO);

  void update(UserVO userVO);

  void delete(String id);

  void deleteAll();

  UserVO selectOne(String id);

  List<UserVO> selectList();

  void insertUserVoBatch(List<UserVO> list);


}
