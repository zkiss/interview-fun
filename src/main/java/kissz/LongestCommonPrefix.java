package kissz;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        StringBuilder pf = new StringBuilder();
        boolean matching = true;
        for (int pos = 0; matching && pos < minLength; pos++) {
            char c = strs[0].charAt(pos);
            for (int current = 1; matching && current < strs.length; current++) {
                matching = strs[current].charAt(pos) == c;
            }
            if (matching) pf.append(c);
        }
        return pf.toString();
    }
}
