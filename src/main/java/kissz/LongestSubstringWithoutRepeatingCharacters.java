package kissz;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Set<Character> chars = new HashSet<>(s.length(), 1.0f);
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (!chars.add(c)) {
                // not new char
                while (s.charAt(start++) != c) {
                    chars.remove(s.charAt(start - 1));
                }
            }
            int len = end + 1 - start;
            if (len > max) max = len;
        }
        return max;
    }
}
