package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {

    private HouseRobber hr = new HouseRobber();

    @Test
    public void examples() {
        assertEquals(4, hr.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, hr.rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(4, hr.rob(new int[]{2, 1, 1, 2}));
    }

}