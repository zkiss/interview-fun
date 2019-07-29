package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementStrStrTest {

    private ImplementStrStr s = new ImplementStrStr();

    @Test
    public void examples() {
        assertEquals(2, s.strStr("hello", "ll"));
        assertEquals(-1, s.strStr("aaaaa", "bba"));
    }

    @Test
    public void test() {
        assertEquals(2, s.strStr("hell", "ll"));
        assertEquals(0, s.strStr("aabb", "aa"));
        assertEquals(0, s.strStr("asd", ""));
        assertEquals(-1, s.strStr("abc", "abcde"));
    }

}