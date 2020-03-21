package egov.dao;

import egov.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

  @Autowired
  SqlSession sqlSessionTemplate;

  public void insert(UserVO userVO) {
    sqlSessionTemplate.update("egov.dao.UserDao.insert", userVO);
  }


  public void update(UserVO userVO) {
    sqlSessionTemplate.update("egov.dao.UserDao.update", userVO);
  }


  public void delete(String id) {
    sqlSessionTemplate.delete("egov.dao.UserDao.delete", id);
  }


  public void deleteAll() {
    sqlSessionTemplate.update("egov.dao.UserDao.deleteAll");
  }


  public UserVO selectOne(String id) {
    return sqlSessionTemplate.selectOne("egov.dao.UserDao.selectOne",id);
  }


  public List<UserVO> selectList() {
    return sqlSessionTemplate.selectList("egov.dao.UserDao.selectList");
  }


  public void insertUserBatch(List<UserVO> list) {

    sqlSessionTemplate.insert("egov.dao.UserDao.insertUserBatch", list);
  }

}
