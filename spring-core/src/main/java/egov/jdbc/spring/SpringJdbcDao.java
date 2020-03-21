package egov.jdbc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpringJdbcDao implements SampleDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  private RowMapper<UserVO> getUserMapper(){
    return (resultSet, i) -> {
      UserVO user = new UserVO();
      user.setId(resultSet.getString("id"));
      user.setName(resultSet.getString("name"));
      user.setPassword(resultSet.getString("password"));
      return user;
    };
  }

  @Override
  public void insert(UserVO userVO) {
    jdbcTemplate.update(
        "INSERT INTO user(id,name,password)  VALUES (?,?,?)"
        , new Object[]{userVO.getId(), userVO.getName(), userVO.getPassword()});
  }

  @Override
  public void update(UserVO userVO) {
    jdbcTemplate.update(
        "UPDATE user SET id = ?, name = ?, password = ? WHERE id = ?"
        , new Object[]{userVO.getId(), userVO.getName(), userVO.getPassword(), userVO.getId()});
  }

  @Override
  public void delete(String id) {
    jdbcTemplate.update(
        "DELETE FROM user WHERE id = ?"
        , new Object[]{id}
    );
  }

  @Override
  public void deleteAll() {
    jdbcTemplate.update("delete from user");
  }

  @Override
  public UserVO selectOne(String id) {

    return jdbcTemplate.queryForObject(
        "SELECT id,name,password FROM user WHERE id = ?"
        , new Object[]{id}
        , getUserMapper());
  }

  @Override
  public List<UserVO> selectList() {
    return jdbcTemplate.query(
        "SELECT id, name, password FROM user"
        , getUserMapper());
  }

  @Override
  public void insertUserVoBatch(List<UserVO> list) {
    final int[][] ints = jdbcTemplate.batchUpdate(
        "INSERT INTO user(id,name,password) VALUES (?,?,?)"
        , list        // batch 대상
        , list.size() // batch 실행 단위
        , (ps, argument) -> { // 파라미터 세팅 (setValue 메서드 구현내용)
          ps.setString(1, argument.getId());
          ps.setString(2, argument.getName());
          ps.setString(3, argument.getPassword());
        }
    );
  }
}
