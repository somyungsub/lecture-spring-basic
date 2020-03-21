package egov.jdbc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements SampleService {

  @Autowired
  SampleDao dao;

  @Override
  public void insert(UserVO userVO){
    dao.insert(userVO);
  }

  @Override
  public void update(UserVO userVO) {
    dao.update(userVO);
  }

  @Override
  public void delete(String id) {
    dao.delete(id);
  }

  @Override
  public void deleteAll() {
    dao.deleteAll();
  }

  @Override
  public UserVO selectOne(String id) {
    return dao.selectOne(id);
  }

  @Override
  public List<UserVO> selectList() {
    return dao.selectList();
  }

  public void insertUserVoBatch(List<UserVO> list) {
    dao.insertUserVoBatch(list);
  }
}
