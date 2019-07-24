package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSliceTest {
    private MaxSlice ms = new MaxSlice();

    @Test
    public void example() {
        assertEquals(10, ms.largestSumSlice(new int[]{5, -7, 3, 5, -2, 4, -1}));
    }

}