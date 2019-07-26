package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    GroupAnagrams underTest = new GroupAnagrams();

    @Test
    public void example() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        assertEquals(underTest.groupAnagrams(input).size(), 3);
    }
}