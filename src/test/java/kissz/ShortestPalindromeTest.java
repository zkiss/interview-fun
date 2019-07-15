package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPalindromeTest {

    @Test
    public void shortestPalindrome_example1() {
        assertEquals("aaacecaaa", new ShortestPalindrome().shortestPalindrome("aacecaaa"));
    }

    @Test
    public void shortestPalindrome_example2() {
        assertEquals("dcbabcd", new ShortestPalindrome().shortestPalindrome("abcd"));
    }

    @Test
    public void shortestPalindrome_oozyrat() {
        assertEquals("oozyratinasanitaryzoo",
                new ShortestPalindrome().shortestPalindrome("zyratinasanitaryzoo"));
    }

    @Test
    public void shortestPalindrome_satan() {
        assertEquals("asatanseesnatasa",
                new ShortestPalindrome().shortestPalindrome("eesnatasa"));
    }
}