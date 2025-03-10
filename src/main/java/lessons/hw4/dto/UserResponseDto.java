package lessons.hw4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
  private Long id;
  private String email;
  private String phoneNumber;
}
