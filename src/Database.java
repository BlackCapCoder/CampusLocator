import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
  Connection con;

  Database () throws Exception {
    Class.forName("org.sqlite.JDBC");
    String url = "jdbc:sqlite:../data/database";
    con = DriverManager.getConnection(url);
  }

}
