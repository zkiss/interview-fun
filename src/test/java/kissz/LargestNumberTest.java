package kissz;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LargestNumberTest {

    LargestNumber ln = new LargestNumber();

    @Test
    public void test() {
        assertEquals("210", ln.largestNumber(new int[]{10, 2}));
        assertEquals("9534330", ln.largestNumber(new int[]{3, 30, 34, 5, 9}));
        assertEquals("12121", ln.largestNumber(new int[]{12, 121}));
        assertEquals("8668866", ln.largestNumber(new int[]{866, 8668}));
        assertEquals("10", ln.largestNumber(new int[]{0, 1}));
        assertEquals("0", ln.largestNumber(new int[]{0, 0}));
    }

}