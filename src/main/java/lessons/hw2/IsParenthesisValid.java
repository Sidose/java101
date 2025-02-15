package lessons.hw2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Checks if parenthesis string is valid.
 */
public final class IsParenthesisValid {

  private IsParenthesisValid() {
  }

  /**
   * Checks if a string of parenthesis is valid.
   *
   * @param str A string to check.
   * @return true if correct, false - otherwise.
   */
  public static boolean isValid(String str) {
    if (str.isEmpty()) {
      throw new RuntimeException("String is empty");
    }

    if (str.length() > 10000) {
      throw new RuntimeException("String is out of range");
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>();
    pairs.put('{', '}');

    pairs.put('[', ']');

    pairs.put('(', ')');

    Stack<Character> deck = new Stack<>();
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (pairs.containsKey(chars[i])) {
        deck.push(chars[i]);
        Character search = pairs.get(chars[i]);
        chars[i] = '_';
        for (int j = 0; j < chars.length; j++) {
          if (search == chars[j]) {
            chars[j] = '_';
            deck.pop();
            break;
          }
        }
      }
    }
    for (char c : chars) {
      if (c != '_') {
        return false;
      }

    }
    return deck.isEmpty();

  }

  /**
   * Main method.
   *
   * @param args Arguments.
   */
  public static void main(String[] args) {
    String str1 = "()[]{}"; // correct
    String str2 = "{[]}()"; // correct
    String str3 = "([]){{"; // incorrect

    System.out.println(isValid(str1)); // true
    System.out.println(isValid(str2)); // true
    System.out.println(isValid(str3)); // false
  }
}
