package egov.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

  @Autowired
  SqlSession sqlSessionTemplate;

  public void insert(UserVO userVO) {
    sqlSessionTemplate.update("egov.mybatis.UserMapper.insert", userVO);
  }

  
  public void update(UserVO userVO) {
    sqlSessionTemplate.update("egov.mybatis.UserMapper.update", userVO);
  }

  
  public void delete(String id) {
    sqlSessionTemplate.delete("egov.mybatis.UserMapper.delete", id);
  }

  
  public void deleteAll() {
    sqlSessionTemplate.delete("egov.mybatis.UserMapper.deleteAll");
  }

  
  public UserVO selectOne(String id) {
    return sqlSessionTemplate.selectOne("egov.mybatis.UserMapper.selectOne",id);
  }

  public List<UserVO> selectList() {
    return sqlSessionTemplate.selectList("egov.mybatis.UserMapper.selectList");
  }

  
  public void insertUserVoBatch(List<UserVO> list) {
    sqlSessionTemplate.insert("egov.mybatis.UserMapper.batch", list);
  }

  public int count() {
    return sqlSessionTemplate.selectOne("egov.mybatis.UserMapper.count");
  }

  public double countAvg절반() {
    return  sqlSessionTemplate.selectOne("egov.mybatis.UserMapper.countAvg절반");
  }

  public List<UserVO> selectDynamin(UserVO userVO) {
    return sqlSessionTemplate.selectList("egov.mybatis.UserMapper.if", userVO);
  }

  public List<UserVO> selectWhen(UserVO userVO) {
    return sqlSessionTemplate.selectList("egov.mybatis.UserMapper.when", userVO);
  }


}
