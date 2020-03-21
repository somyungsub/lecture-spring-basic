package egov.jdbc;

import egov.jdbc.template.CaffeineBeverage;
import egov.jdbc.template.Coffee;
import egov.jdbc.template.Tea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Enumeration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:etc.egov/jdbc/egov_jdbc.xml")
public class JdbcTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  DataSource dataSource2;

  @Test
  public void testTemplateMethod() {

    // Coffee
    System.out.println("============= Coffee =============");
    CaffeineBeverage caffeineBeverage = new Coffee();
    caffeineBeverage.prepareRecipe();

    // Tea
    System.out.println("============= Tea =============");
    caffeineBeverage = new Tea();
    caffeineBeverage.prepareRecipe();
  }

  @Test
  public void testJDBC() {

    Enumeration<Driver> drivers = DriverManager.getDrivers();
    for (; drivers.hasMoreElements(); ) {
      System.out.println("drivers.nextElement() = " + drivers.nextElement());
    }

    String url = "jdbc:mysql://localhost:3306/egov";
    String user = "root";
    String password = "";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = DriverManager.getConnection(url, user, password);
      preparedStatement = connection.prepareStatement("select * from user ");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        StringBuilder sb = new StringBuilder();
        sb.append(resultSet.getString("id")).append(" ");
        sb.append(resultSet.getString("name")).append(" ");
        sb.append(resultSet.getString("password")).append(" ");
        System.out.println(sb.toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 리소스 반환 필수 !!
      // 커넥션 자체를 소멸시키고 생성하는 것이 아닌 pool 개념으로 접근하기 때문에
      // 반드시 적절한 리소스 반환 작업이 필요하다. 그러지 않을 경우,예외가 발생하게 된다.
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }


  @Test
  public void testDriverManagerDataSource() throws SQLException {
    // DriverManagerDataSource -> 매번 생성
    System.out.println(dataSource);
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
  }

  @Test
  public void testBasicDataSource() throws SQLException {
    // BasicDataSource -> pool
    System.out.println(dataSource2);
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
    System.out.println("dataSource2.getConnection() = " + dataSource2.getConnection());
  }

  @Test
  public void testBasicDataSource2() throws SQLException {
    // 8개 생성
    System.out.println(dataSource2);
    // 8개 생성
    Connection[] connection = {
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection(),
        dataSource2.getConnection()
    };

    // 생성 확인
    for (Connection connection1 : connection) {
      System.out.println(connection1);
    }

    // Connection 객체 소멸(리소스 close)
    for (Connection connection1 : connection) {
      connection1.close();
    }
    System.out.println("============== 반환 후 재 생성 ==============");
    System.out.println(dataSource2.getConnection());
    System.out.println(dataSource2.getConnection());
    System.out.println(dataSource2.getConnection());
  }
}
