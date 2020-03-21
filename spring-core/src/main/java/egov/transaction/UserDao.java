package egov.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao {

  @Autowired
  SqlSession sqlSessionTemplate;

  public void insert(UserVO userVO) {
    sqlSessionTemplate.update("egov.transaction.UserDao.insert", userVO);
  }


  public void update(UserVO userVO) {
    sqlSessionTemplate.update("egov.transaction.UserDao.update", userVO);
  }


  public void delete(String id) {
    sqlSessionTemplate.delete("egov.transaction.UserDao.delete", id);
  }


  public void deleteAll() {
    sqlSessionTemplate.delete("egov.transaction.UserDao.deleteAll");
  }


  public UserVO selectOne(String id) {
    return sqlSessionTemplate.selectOne("egov.transaction.UserDao.selectOne",id);
  }


  public List<UserVO> selectList() {
    return sqlSessionTemplate.selectList("egov.transaction.UserDao.selectList");
  }


  public void insertUserVoBatch(List<UserVO> list) {
    if (list == null) {
      throw new NullPointerException("List Null");
    }
    sqlSessionTemplate.insert("egov.transaction.UserDao.batch", list);
  }

  // 트랜잭션 새로 생성
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void insertDaoTransaction(UserVO userVO) {
    sqlSessionTemplate.update("egov.transaction.UserDao.insert", userVO);
  }

}
