package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {

    private RegularExpressionMatching rem = new RegularExpressionMatching();

    @Test
    public void examples() {
        assertFalse(rem.isMatch("aa", "a"));
        assertTrue(rem.isMatch("aa", "a*"));
        assertTrue(rem.isMatch("ab", ".*"));
        assertTrue(rem.isMatch("aab", "c*a*b"));
        assertFalse(rem.isMatch("mississippi", "mis*is*p*."));
    }

}