package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    private LongestCommonPrefix lcp = new LongestCommonPrefix();

    @Test
    public void examples() {
        assertEquals("fl", lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", lcp.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}