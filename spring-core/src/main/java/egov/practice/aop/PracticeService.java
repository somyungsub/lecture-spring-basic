package egov.practice.aop;

import org.springframework.stereotype.Service;

@Service
public class PracticeService {

  public void test() {
    System.out.println("test 입니다.");
  }

  public PracticeVO selectPracticeVO(String id) {
    System.out.println("selectPracticeVO, ID : " + id);
    return new PracticeVO("1", "practiceVO", "pass~word~");
  }

  public void deletePracticeVO(String id) {
    System.out.println("deletePracticeVO, ID : " + id);
    System.out.println("delete 완료");
  }

}
