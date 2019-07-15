package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntegerTest {
    @Test
    public void testRomanToValue() {
        assertEquals(1998, new RomanToInteger().romanToInt("MCMXCVIII"));
    }
}