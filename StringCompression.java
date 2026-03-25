public class StringCompression {

    public static String compress(String s) {
        if (s == null || s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder();
        char currentChar = s.charAt(0);
        int count = 1;

        // Start from index 1 — index 0 is already captured as currentChar
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                // Flush current run to the builder
                sb.append(currentChar);
                sb.append(count);
                // Start a new run
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        // Final flush — the last run never hits the else branch
        sb.append(currentChar);
        sb.append(count);

        // Only return compressed if it's actually shorter
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa")); // "a2b1c5a3"
        System.out.println(compress("abcd")); // "abcd" (a1b1c1d1 = same length, return original)
        System.out.println(compress("aab")); // "aab" (a2b1 longer, return original)
        System.out.println(compress("aaaa")); // "a4"
        System.out.println(compress("a")); // "a"
    }
}