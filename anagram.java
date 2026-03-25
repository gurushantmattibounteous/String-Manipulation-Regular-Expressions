import java.util.*;

public class anagram {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "anagram";
        String t = "nagaram";

        boolean result = sol.isAnagram(s, t);
        System.out.println(result);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }

        for (int count : freq.values()) {
            if (count != 0)
                return false;
        }

        return true;
    }
}