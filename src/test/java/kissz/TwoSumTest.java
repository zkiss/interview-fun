package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private TwoSum ts = new TwoSum();

    @Test
    public void example() {
        var r = ts.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, r);
    }

    @Test
    public void test() {
        var r = ts.twoSum(new int[]{1, 2, 5, 3, 4, 5}, 10);
        assertArrayEquals(new int[]{2, 5}, r);
    }

}