import java.util.*;

public class validparentesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // 👇 ADD THIS
    public static void main(String[] args) {
        validparentesis sol = new validparentesis();

        String test = "()[]{}";
        System.out.println(sol.isValid(test)); // true

        test = "(]";
        System.out.println(sol.isValid(test)); // false
    }
}