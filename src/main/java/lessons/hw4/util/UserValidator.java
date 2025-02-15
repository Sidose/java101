package lessons.hw4.util;

import lessons.hw4.dto.UserRegistrationDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UserValidator {
  private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
  private static final String PHONE_REGEX = "^(\\+?\\d{1,3})?[-.\\s]?(\\(?\\d{2,3}\\)?)?[-.\\s]?\\d{3}[-.\\s]?\\d{2,3}[-.\\s]?\\d{2,3}$";

  private UserValidator() { }

  /**
   * Checks user.
   *
   * @param user User to check.
   */
  public static void checkUser(UserRegistrationDto user) {

    Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
    Matcher matcher = patternEmail.matcher(user.getEmail());
    if (!matcher.matches()) {
      throw new RuntimeException("Email is invalid.");
    }

    if (!user.getPhoneNumber().isEmpty()) {
      Pattern patternPhone = Pattern.compile(PHONE_REGEX);
      if (!patternPhone.matcher(user.getPhoneNumber()).matches()) {
        throw new RuntimeException("Phone is invalid.");
      }
    }

    if (user.getPassword().isEmpty()) {
      throw new RuntimeException("Password is empty.");
    }

    if (!user.getPassword().equals(user.getRepeatPassword())) {
      throw new RuntimeException("Password didn't match repeat password.");
    }
  }

}
