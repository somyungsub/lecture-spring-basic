package egov.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
public class UserVO {

  String id;
  String name;
  String password;
  int age;

  UserVO user;
  UserVO user2;

  List list;
  Set<String> set;
  Map<String, Integer> map;
  Properties properties;


  public UserVO() {
    System.out.println("기본생성자 UserVO");
  }

  public UserVO(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public UserVO(String id, String name, String password, UserVO user) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.user = user;
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

  public UserVO getUser2() {
    return user2;
  }

  public void setUser2(UserVO user2) {
    this.user2 = user2;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }

  public Set<String> getSet() {
    return set;
  }

  public void setSet(Set<String> set) {
    this.set = set;
  }

  public Map<String, Integer> getMap() {
    return map;
  }

  public void setMap(Map<String, Integer> map) {
    this.map = map;
  }

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
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
        ", user2=" + user2 +
        ", list=" + list +
        ", set=" + set +
        ", map=" + map +
        ", properties=" + properties +
        '}';
  }

  public void init() {
    System.out.println("Init Call...");
  }

  public void destroy() {
    System.out.println("destroy Call...");
  }
}
