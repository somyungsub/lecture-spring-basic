package egov.practice.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracticeDao {

  @Autowired
  SqlSession sqlSession;

  public void deleteAll() {
    sqlSession.delete("egov.practice.mybatis.PracticeDao.deleteAll");
  }

  public void batch(List<PracticeVO> list) {
    sqlSession.insert("egov.practice.mybatis.PracticeDao.batch", list);
  }

  // TODO : Mapper XML에 ID를 등록하여 select SQL 작성하기
  public PracticeVO selectOne(String id) {
    return sqlSession.selectOne("", id);
  }

  // TODO : delete, update, insert 도 작성해보기

  // TODO : 다이나믹 쿼리(if, choose) 작성해보기


}
