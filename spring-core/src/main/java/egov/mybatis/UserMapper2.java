package egov.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper2 {


  UserVO selectOne(String id);

  @Select("select id,name,password from user2 where id = #{id}")
  UserVO selectOneTest(String id);


  List<UserVO> selectList();

  @Delete("delete from user2")
  void deleteAllUserVO();
}
