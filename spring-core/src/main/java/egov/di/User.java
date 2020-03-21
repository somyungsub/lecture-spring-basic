package egov.di;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class User {

  private String name;



  public User() {
    System.out.println("생성자 호출");
  }

  public void setName(String name) {
    this.name = name;
  }

  @PostConstruct
  public void init() {
    System.out.println("init 실행");
  }
}
