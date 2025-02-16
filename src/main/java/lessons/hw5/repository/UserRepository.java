package lessons.hw5.repository;

import java.util.Optional;
import lessons.hw5.model.User;

/**
 * User repository.
 */
public interface UserRepository {
  /**
   * Creates user.
   *
   * @param user User object.
   * @return Created user object.
   */
  User create(User user);

  /**
   * Finds user by ID.
   *
   * @param id User ID.
   * @return User object.
   */
  Optional<User> findById(Long id);

  /**
   * Updates user.
   *
   * @param user User object.
   * @return Updated user object.
   */
  User update(User user);
}
