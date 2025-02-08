package lessons.hw2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsParenthesisValid {

    public static boolean isValid(String str) {

        if (str.isEmpty()) {
            throw new RuntimeException("String is empty");
        }

        if (str.length() > 10000) {
            throw new RuntimeException("String is out of range");
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Stack<Character> deck = new Stack<>();
        char[] chArr = str.toCharArray();

        for(int i = 0; i < chArr.length; i++) {
            if(pairs.containsKey(chArr[i])) {
                deck.push(chArr[i]);
                Character search = pairs.get(chArr[i]);
                chArr[i] = '_';
                for(int j = 0; j < chArr.length; j++) {
                    if(search == chArr[j]) {
                        chArr[j] = '_';
                        deck.pop();
                        break;
                    }
                }
            }

        }

        for (char c : chArr) {
            if (c != '_')
                return false;
        }

        return deck.isEmpty();

    }

    public static void main(String[] args) {
       String str1 = "()[]{}}{"; // correct
       String str2 = "}]){[("; // correct
       String str3 = "(][}){{"; // incorrect

       System.out.println(isValid(str1)); // true
       System.out.println(isValid(str2)); // true
       System.out.println(isValid(str3)); // false
    }
}
