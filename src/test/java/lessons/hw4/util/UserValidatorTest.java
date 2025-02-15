package lessons.hw4.util;

import lessons.hw4.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

  @Test
  void checkUser_InvalidEmail() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("mike");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Email is invalid."
    );
  }

  @Test
  void checkUser_InvalidPhone() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("mike@mail.com");
    user.setPhoneNumber("123invalid");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Phone is invalid."
    );
  }

  @Test
  void checkUser_PasswordEmpty() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("mike@mail.com");
    user.setPhoneNumber("+380123456789");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Password is empty."
    );
  }

  @Test
  void checkUser_PasswordNotEqual() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("mike@mail.com");
    user.setPhoneNumber("+380123456789");
    user.setPassword("123456");
    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkUser(user),
      "Password didn't match repeat password."
    );
  }

  @Test
  void checkUser_Ok() {
    UserRegistrationDto user = new UserRegistrationDto();
    user.setEmail("mike@mail.com");
    user.setPhoneNumber("+380123456789");
    user.setPassword("123456");
    user.setRepeatPassword("123456");
    UserValidator.checkUser(user);
  }
}