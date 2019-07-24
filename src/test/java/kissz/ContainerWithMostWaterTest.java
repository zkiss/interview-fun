package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    private ContainerWithMostWater cw = new ContainerWithMostWater();

    @Test
    public void example() {
        assertEquals(49, cw.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(2, cw.maxArea(new int[]{1, 2, 1}));
    }

}