package kissz;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int start = 0; start < s.length() - longestPalindrome.length(); start++) {
            for (int length = s.length() - start; length > longestPalindrome.length(); length--) {
                String candidate = s.substring(start, start + length);
                if (isPalindrome(candidate)) {
                    longestPalindrome = candidate;
                }
            }
        }
        return longestPalindrome;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
