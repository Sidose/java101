package lessons.hw4.util;

import lessons.hw4.exception.DataProcessingException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class to manage connection.
 */
public final class ConnectionUtil {
  private static final String DB_URL = "jdbc:mysql://localhost:3308/users_storage";
  private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
  private static final Properties DB_PROPERTIES = new Properties();

  private ConnectionUtil() { }

  static {
    DB_PROPERTIES.put("user", "user");
    DB_PROPERTIES.put("password", "password");

    try {
      Class.forName(DRIVER_CLASS_NAME);
    } catch (ClassNotFoundException e) {
      throw new DataProcessingException("Can't load JDBC driver", e);
    }
  }

  /**
   * Gets connection.
   *
   * @return connection.
   */
  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
    } catch (SQLException e) {
      throw new DataProcessingException("Unable get connection to DB", e);
    }
  }
}
