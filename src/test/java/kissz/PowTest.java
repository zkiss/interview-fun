package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {

    private Pow p = new Pow();

    @Test
    public void examples() {
        assertEquals(1024, p.myPow(2, 10), 0.00001);
        assertEquals(9.261, p.myPow(2.1, 3), 0.00001);
        assertEquals(0.25, p.myPow(2, -2), 0.00001);
    }

    @Test
    public void test() {
        assertEquals(1 << 30, p.myPow(2, 30), 0.00001);
        assertEquals(27, p.myPow(3, 3), 0.00001);
        assertEquals(1d / 27, p.myPow(3, -3), 0.00001);
    }
}