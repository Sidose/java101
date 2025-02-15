package lessons.hw4;

import lessons.hw4.dto.UserRegistrationDto;
import lessons.hw4.dto.UserResponseDto;
import lessons.hw4.repository.UserRepository;
import lessons.hw4.repository.impl.UserRepositoryImpl;
import lessons.hw4.service.UserService;
import lessons.hw4.service.impl.UserServiceImpl;

public final class Main {

  private Main() { }

  public static void main(String[] args) {

    UserRepository userRepository = new UserRepositoryImpl();
    UserService userService = new UserServiceImpl(userRepository);

    UserResponseDto userAdded = userService.registerUser(new UserRegistrationDto("mike@mail.com", "", "123456", "123456"));
    System.out.println("Added user: "
        + "id = " + userAdded.getId()
        + ", email = " + userAdded.getEmail()
        + ", phone number = " + userAdded.getPhoneNumber()
    );

    UserResponseDto userFound = userService.getUserById(userAdded.getId());
    System.out.println("Found by id user: "
        + "id = " + userFound.getId()
        + ", email = " + userFound.getEmail()
        + ", phone number = " + userFound.getPhoneNumber()
    );
  }
}
