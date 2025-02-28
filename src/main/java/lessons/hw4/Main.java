package lessons.hw4;

import lessons.hw4.dto.UserRegistrationDto;
import lessons.hw4.dto.UserResponseDto;
import lessons.hw4.exception.ValidationException;
import lessons.hw4.repository.UserRepository;
import lessons.hw4.repository.impl.UserRepositoryImpl;
import lessons.hw4.service.UserService;
import lessons.hw4.service.impl.UserServiceImpl;

public final class Main {

  private Main() {
  }

  public static void main(String[] args) throws ValidationException {

    UserRepository userRepository = new UserRepositoryImpl();
    UserService userService = new UserServiceImpl(userRepository);

    UserResponseDto userAdded = userService.registerUser(
        new UserRegistrationDto("mike@mail.com", "", "123456", "123456")
    );

    System.out.printf("""
        Added user:
        id = %s,
        email = %s,
        phone number = %s
        """, userAdded.getId(), userAdded.getEmail(), userAdded.getPhoneNumber());

    UserResponseDto userFound = userService.getUserById(userAdded.getId());

    System.out.printf("""
        Found by id user:
        id = %s,
        email = %s,
        phone number = %s
        """, userFound.getId(), userFound.getEmail(), userFound.getPhoneNumber()
    );
  }
}
