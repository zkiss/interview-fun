package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockBuyingTest {

    private StockBuying sb = new StockBuying();

    @Test
    public void example1() {
        var r = sb.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(5, r);
    }

    @Test
    public void example2() {
        var r = sb.maxProfit(new int[]{7, 6, 4, 3, 1});
        assertEquals(0, r);
    }

}