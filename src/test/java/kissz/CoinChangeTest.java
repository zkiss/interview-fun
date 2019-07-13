package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void example() {
        CoinChange coinChange = new CoinChange();
        assertEquals(3, coinChange.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, coinChange.coinChange(new int[] {2}, 3));
    }
}