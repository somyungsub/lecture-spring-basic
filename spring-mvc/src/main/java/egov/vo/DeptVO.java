package egov.vo;

public class DeptVO {
  private String id;
  private String name;
  private String deptNo;
  private String deptName;

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

  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  @Override
  public String toString() {
    return "DeptVO{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", deptNo='" + deptNo + '\'' +
        ", deptName='" + deptName + '\'' +
        '}';
  }
}
