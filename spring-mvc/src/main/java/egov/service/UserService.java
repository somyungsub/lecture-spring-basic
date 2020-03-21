package egov.service;

import egov.dao.UserDao;
import egov.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserDao dao;

  public void insert(UserVO userVO){
    dao.insert(userVO);
  }


  public void update(UserVO userVO) {
    dao.update(userVO);
  }


  public void delete(String id) {
    dao.delete(id);
  }


  public void deleteAll() {
    dao.deleteAll();
  }


  public UserVO selectOne(String id) {
    return dao.selectOne(id);
  }


  public List<UserVO> selectList() {
    return dao.selectList();
  }

  public void insertUserBatch(List<UserVO> list) {
    dao.insertUserBatch(list);
  }

}
