package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters lss = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void examples() {
        assertEquals(3, lss.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lss.lengthOfLongestSubstring("b"));
        assertEquals(3, lss.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, lss.lengthOfLongestSubstring("dvdf"));
        assertEquals(6, lss.lengthOfLongestSubstring("ohvhjdml"));
    }

}