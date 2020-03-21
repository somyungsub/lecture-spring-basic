package egov.practice.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracticeDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void deleteAll() {
    jdbcTemplate.update("DELETE FROM user");
  }

  public void insert(PracticeVO practiceVO) {
    jdbcTemplate.update("INSERT INTO user VALUES (?,?,?)",
        new Object[]{practiceVO.getId(), practiceVO.getName(), practiceVO.getPassword()});
  }

  public PracticeVO selectOne(String id) {

    return jdbcTemplate.queryForObject(
        "SELECT * FROM user WHERE id = ?",
        new Object[]{id},
        (rs, rowNum) -> {
          PracticeVO vo = new PracticeVO();
          return vo;
        }
    );
  }

  public void batch(List<PracticeVO> list) {
    jdbcTemplate.batchUpdate(
        "INSERT INTO user VALUES (?,?,?)",
        list,
        list.size(),
        (ps, argument) -> {
          ps.setString(1, argument.getId());
          ps.setString(2, argument.getName());
          ps.setString(3,argument.getName());
        });
  }


}
