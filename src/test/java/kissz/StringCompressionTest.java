package kissz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void tests() {
        assertEquals("a2b1c5a3", StringCompression.compress("aabcccccaaa"));
        assertEquals("a", StringCompression.compress("a"));
        assertEquals("a2", StringCompression.compress("aa"));
    }

}