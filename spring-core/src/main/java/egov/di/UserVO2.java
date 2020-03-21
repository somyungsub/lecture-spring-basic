package egov.di;

public class UserVO2 {

  String id;
  String name;
  String password;
  int age;

  UserVO user;
  UserVO2 user2;


  public UserVO2() {
    System.out.println("기본생성자 UserVO");
  }

//  public UserVO(String id, String name, String password) {
//    this.id = id;
//    this.name = name;
//    this.password = password;
//  }
////
//  public UserVO(String id, String name, String password, UserVO user) {
//    this.id = id;
//    this.name = name;
//    this.password = password;
//    this.user = user;
//  }

  public UserVO2(String id) {

  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserVO getUser() {
    return user;
  }

  public void setUser(UserVO user) {
    this.user = user;
  }

  public UserVO2 getUser2() {
    return user2;
  }

  public void setUser2(UserVO2 user2) {
    this.user2 = user2;
  }

  @Override
  public String toString() {
    return super.toString() +
        "UserVO{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", age=" + age +
        ", user=" + user +
        '}';
  }

  public void init() {
    System.out.println("Init Call...");
  }

  public void destroy() {
    System.out.println("destroy Call...");
  }
}
