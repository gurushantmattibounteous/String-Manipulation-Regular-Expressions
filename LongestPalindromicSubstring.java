public class LongestPalindromicSubstring {

    // Helper: expand from center [l, r] outward, return the longest valid
    // palindrome
    private static String expandFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // Loop exits one step PAST the valid palindrome, so walk back with l+1, r-1
        return s.substring(l + 1, r); // substring(inclusive, exclusive)
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        String best = s.substring(0, 1); // at minimum, first char is a palindrome

        for (int i = 0; i < s.length(); i++) {
            // Case 1: odd-length palindrome — center is a single character
            String odd = expandFromCenter(s, i, i);

            // Case 2: even-length palindrome — center is between i and i+1
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > best.length())
                best = odd;
            if (even.length() > best.length())
                best = even;
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd")); // "bb"
        System.out.println(longestPalindrome("a")); // "a"
        System.out.println(longestPalindrome("racecar")); // "racecar"
        System.out.println(longestPalindrome("abacaba")); // "abacaba"
    }
}