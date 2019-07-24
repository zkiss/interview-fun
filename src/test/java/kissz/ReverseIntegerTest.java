package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    private ReverseInteger ri = new ReverseInteger();

    @Test
    public void examples() {
        assertEquals(321, ri.reverse(123));
        assertEquals(-321, ri.reverse(-123));
        assertEquals(21, ri.reverse(120));
        assertEquals(0, ri.reverse(Integer.MIN_VALUE));
        assertEquals(0, ri.reverse(1534236469));
    }

}