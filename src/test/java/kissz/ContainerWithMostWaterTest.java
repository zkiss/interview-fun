package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    private final ContainerWithMostWater underTest = new ContainerWithMostWater();

    @Test
    public void example() {
        assertEquals(49, underTest.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}