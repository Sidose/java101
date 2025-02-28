package lessons.hw4.service.impl;

import lessons.hw4.dto.UserRegistrationDto;
import lessons.hw4.dto.UserResponseDto;
import lessons.hw4.exception.ValidationException;
import lessons.hw4.model.User;
import lessons.hw4.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private static UserServiceImpl userService;

  @Test
  void registerUser() throws ValidationException {
    Mockito.when(userRepository.save(Mockito.any(User.class)))
      .thenReturn(new User(
          1L,
          "mike@mail.com",
          "+380123456789",
          "123456"
        )
      );

    UserResponseDto user = userService.registerUser(new UserRegistrationDto("mike@mail.com", "+380123456789", "123456", "123456"));
    assertEquals(1L, user.getId());
    assertEquals("mike@mail.com", user.getEmail());
    assertEquals("+380123456789", user.getPhoneNumber());
  }

  @Test
  void getUserById() {

    Mockito.when(userRepository.findById(1L))
      .thenReturn((Optional.of(new User(
          1L,
          "mike@mail.com",
          "+380123456789",
          "123456"
        )
      )));

    Mockito.when(userRepository.findById(2L))
      .thenReturn(Optional.empty());

    UserResponseDto user = userService.getUserById(1L);
    assertEquals(1L, user.getId());
    assertEquals("mike@mail.com", user.getEmail());
    assertEquals("+380123456789", user.getPhoneNumber());
  }
}
