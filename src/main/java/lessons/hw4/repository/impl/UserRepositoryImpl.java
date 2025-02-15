package lessons.hw4.repository.impl;

import lessons.hw4.exception.DataProcessingException;
import lessons.hw4.model.User;
import lessons.hw4.repository.UserRepository;
import lessons.hw4.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 * Class for user repository implementation.
 */
public class UserRepositoryImpl implements UserRepository {
  private static final int MIN_AFFECTED_ROWS_COUNT = 1;
  private static final String ID = "id";
  private static final String EMAIL = "email";
  private static final String PHONE_NUMBER = "phone_number";
  private static final String PASSWORD = "password";

  @Override
  public Optional<User> findById(Long id) {
    String sqlRequest = "SELECT id, email, phone_number, password FROM users WHERE id = ?";

    try (Connection connection = ConnectionUtil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        return Optional.of(parseUser(resultSet));
      }
    } catch (SQLException e) {
      throw new DataProcessingException("Can't find car by id. ID=" + id, e);
    }
    return Optional.empty();
  }

  private User parseUser(ResultSet requestResult) {
    try {
      Long id = requestResult.getObject(ID, Long.class);
      String email = requestResult.getString(EMAIL);
      String password = requestResult.getString(PASSWORD);
      String phoneNumber = requestResult.getString(PHONE_NUMBER);

      return new User(id, email, phoneNumber, password);
    } catch (SQLException e) {
      throw new DataProcessingException("Can't parse user "
        + "data from resultSet", e);
    }
  }

  @Override
  public User save(User user) {
    String sqlRequest = "INSERT INTO users (email, phone_number, password) VALUES (?, ?, ?)";

    try (Connection connection = ConnectionUtil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest,
           Statement.RETURN_GENERATED_KEYS)) {
      preparedStatement.setString(1, user.getEmail());
      preparedStatement.setString(2, user.getPhoneNumber());
      preparedStatement.setString(2, user.getPassword());

      int affectedRows = preparedStatement.executeUpdate();
      if (affectedRows < MIN_AFFECTED_ROWS_COUNT) {
        throw new DataProcessingException("Expected to insert 1 row. But inserted 0 rows.");
      }

      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        Long id = generatedKeys.getObject(1, Long.class);
        user.setId(id);
      }
    } catch (SQLException e) {
      throw new DataProcessingException("Can't create instance of a user:"
        + user.toString()
        + " and add in to DB", e);

    }
    return user;

  }
}
