package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegersTest {

    private DivideTwoIntegers d = new DivideTwoIntegers();

    @Test
    public void examples() {
        assertEquals(3, d.divide(10,3));
        assertEquals(-2, d.divide(7,-3));
    }

}