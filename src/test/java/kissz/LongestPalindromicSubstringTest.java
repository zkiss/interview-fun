package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    @Test
    public void examples() {
        assertEquals("bab", lps.longestPalindrome("babad"));
        assertEquals("bb", lps.longestPalindrome("cbbd"));
    }

}