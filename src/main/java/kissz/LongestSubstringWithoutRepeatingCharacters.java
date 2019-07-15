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
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.add(c)) {
                // not new char
                while (s.charAt(start++) != c) {
                    chars.remove(s.charAt(start - 1));
                }
            }
            int len = i + 1 - start;
            if (len > max) max = len;
        }
        return max;
    }
}
