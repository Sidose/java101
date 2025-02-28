package lessons.hw4.service;

import lessons.hw4.dto.UserRegistrationDto;
import lessons.hw4.dto.UserResponseDto;
import lessons.hw4.exception.ValidationException;

/**
 * Manage users.
 */
public interface UserService {

  /**
   * Registers user.
   *
   * @param user User registration object.
   * @return Registered user object.
   */
  UserResponseDto registerUser(UserRegistrationDto user) throws ValidationException;

  /**
   * Gets user by ID.
   *
   * @param userId User's ID.
   * @return User object.
   */
  UserResponseDto getUserById(Long userId);

}
