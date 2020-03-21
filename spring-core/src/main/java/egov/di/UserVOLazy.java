package egov.di;

public class UserVOLazy {

  String id;
  String name;
  String password;

  public UserVOLazy() {
    System.out.println("LazyUser UserVO");
  }

  public UserVOLazy(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
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

  @Override
  public String toString() {
    return super.toString() + "\n" +
        "UserVO{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
