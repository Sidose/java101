package lessons.hw4.service.impl;

import lessons.hw4.dto.UserRegistrationDto;
import lessons.hw4.dto.UserResponseDto;
import lessons.hw4.exception.ValidationException;
import lessons.hw4.model.User;
import lessons.hw4.repository.UserRepository;
import lessons.hw4.service.UserService;
import lessons.hw4.util.UserValidator;

/**
 * Class to manage users.
 */
public class UserServiceImpl implements UserService {

  /**
   * User repository instance.
   */
  private final UserRepository userRepository;

  /**
   * Constructor.
   *
   * @param userRepository User repository object.
   */
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponseDto registerUser(UserRegistrationDto user) throws ValidationException {
    UserValidator.checkUser(user);

    User userToSave = new User();
    userToSave.setEmail(user.getEmail());
    userToSave.setPhoneNumber(user.getPhoneNumber());
    userToSave.setPassword(user.getPassword());

    User userSaved = userRepository.save(userToSave);

    return new UserResponseDto(userSaved.getId(), userSaved.getEmail(), userSaved.getPhoneNumber());
  }

  @Override
  public UserResponseDto getUserById(Long userId) {
    return null;
  }
}
