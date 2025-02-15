package lessons.hw4.repository;

import lessons.hw4.model.User;
import java.util.Optional;

/**
 * Manage user repository.
 */
public interface UserRepository {
  /**
   * Saves user.
   *
   * @param user User object.
   */
  User save(User user);

  /**
   * Gets a user by ID.
   *
   * @param id ID of a user.
   * @return User.
   */
  Optional<User> findById(Long id);
}
