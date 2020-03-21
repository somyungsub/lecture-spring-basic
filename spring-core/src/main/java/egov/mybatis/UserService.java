package egov.mybatis;

import org.apache.ibatis.annotations.Select;
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

  public void insertUserVoBatch(List<UserVO> list) {
    dao.insertUserVoBatch(list);
  }

  public int count(){
    return dao.count();
  }

  public double countAvg절반(){
    return dao.countAvg절반();
  }

  public List<UserVO> selectDynamic(UserVO userVO) {
    return dao.selectDynamin(userVO);
  }

  public List<UserVO> selectWhen(UserVO userVO) {
    return dao.selectWhen(userVO);
  }



  // MapperInterface - UserMapper 방식
  @Autowired
  UserMapper userMapper;

  public UserVO selectOneUserMapper(String id) {
    return userMapper.selectOne(id);
  }

  public UserVO selectOneTestUserMapper(String id) {
    return userMapper.selectOneTest(id);
  }

  public List<UserVO> selectListUserMapper() {
    return userMapper.selectList();
  }

  //

  @Autowired
  UserMapper2 userMapper2;
  public UserVO selectOneUserMapper2(String id) {
    return userMapper2.selectOne(id);
  }

  public List<UserVO> selectListUserMapper2() {
    return userMapper2.selectList();
  }
}
