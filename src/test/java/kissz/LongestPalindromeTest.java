package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void testPalindrome() {
        LongestPalindrome lp = new LongestPalindrome();
        assertEquals("asatanseesnatasa", lp.longestPalindrome("asatanseesnatasa"));
        assertEquals("asatanseesnatasa", lp.longestPalindrome("afdsfsdasatanseesnatasafdsfd"));
    }
}