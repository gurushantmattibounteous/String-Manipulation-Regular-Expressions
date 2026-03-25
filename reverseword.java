import java.util.*;

public class reverseword {

    public static String reverseWords(String s) {
        s = s.trim(); // remove leading/trailing spaces
        String[] words = s.split("\\s+"); // split by multiple spaces

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine(); // important: use nextLine()

        String output = reverseWords(input);

        System.out.println("Output: " + output);

        sc.close();
    }
}