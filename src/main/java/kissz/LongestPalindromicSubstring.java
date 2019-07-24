package kissz;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int len = 0;
        for (int center = 0; center < s.length(); center++) {
            int s1 = expand(s, center, false);
            int s2 = expand(s, center, true);
            if (s2 <= s1) {
                int l2 = (center - s2 + 1) * 2;
                if (l2 > len) {
                    start = s2;
                    len = l2;
                }
            } else {
                int l1 = (center - s1) * 2 + 1;
                if (l1 > len) {
                    start = s1;
                    len = l1;
                }
            }
        }
        return s.substring(start, start + len);
    }

    private int expand(String s, int start, boolean doubleCenter) {
        int end = start + 1;
        if (!doubleCenter) start--;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return start + 1;
    }
}
