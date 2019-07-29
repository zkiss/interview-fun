package kissz;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        int needleHash = 0;
        for (int i = 0; i < needle.length(); i++) needleHash += needle.charAt(i);

        int runningHash = 0;
        for (int i = 0; i < needle.length(); i++) runningHash += haystack.charAt(i);

        for (int matchEnd = needle.length(); matchEnd <= haystack.length(); matchEnd++) {
            if (needleHash == runningHash &&
                    matches(haystack, matchEnd - needle.length(), needle)) {
                return matchEnd - needle.length();
            }
            runningHash -= haystack.charAt(matchEnd - needle.length());
            if (matchEnd < haystack.length())
                runningHash += haystack.charAt(matchEnd);
        }
        return -1;
    }

    private boolean matches(String haystack, int start, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (start >= haystack.length()) return false;
            if (haystack.charAt(start++) != needle.charAt(i)) return false;
        }
        return true;
    }
}
