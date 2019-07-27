package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockIVTest {
    BestTimeToBuyAndSellStockIV underTest = new BestTimeToBuyAndSellStockIV();

    @Test
    public void example1() {
        assertEquals(2, underTest.maxProfit(2, new int[] {2,4,1}));
    }

    @Test
    public void example2() {
        assertEquals(7, underTest.maxProfit(2, new int[] {3,2,6,5,0,3}));
    }
}