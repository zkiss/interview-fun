package kissz;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Let's try again with dynamic programming.
 * The problem looks like weighted jobs scheduling.
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        // Don't include non-increasing prices.
        int[] filtered = new int[prices.length];
        filtered[0] = prices[0];
        int n = 1;
        for (int i = 1; i < prices.length - 1; i++) {
            if (!(prices[i - 1] > prices[i] && prices[i] > prices[i + 1])) {
                filtered[n++] = prices[i];
            }
        }
        if (n < prices.length && prices[prices.length - 1] > prices[prices.length - 2]) {
            filtered[n] = prices[prices.length - 1];
            n++;
        }
        prices = filtered;

        // We don't need to calculate more than the maximum possible transactions.
        k = Math.min(k, n / 2);

        if (n < 2) return 0;
        int[] memo = new int[prices.length];
        int[] memoPrev = new int[prices.length];
        int[] swap;

        List<List<IntPair>> profitAndTradeLengths = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            profitAndTradeLengths.add(getProfitAndTradeRunLengths(i, prices));
        }

        // Don't iterate twice over the part of memo that is not changing.
        int stableTransactions = 0;
        for (int numberOfTransactions = 1; numberOfTransactions <= k; numberOfTransactions++) {
            for (int priceHistoryLength = 2; priceHistoryLength <= n; priceHistoryLength++) {

                int maxProfit = Math.max(memoPrev[priceHistoryLength - 1], memo[priceHistoryLength - 2]);
                List<IntPair> trades = profitAndTradeLengths.get(priceHistoryLength - 1);

                for (int i = 0, size = trades.size(); i < size; i++) {
                    IntPair trade = trades.get(i);
                    int profit = memoPrev[trade.b] + trade.a;
                    if (profit > maxProfit) maxProfit = profit;
                    if (trade.b < stableTransactions) break;
                }

                memo[priceHistoryLength - 1] = maxProfit;
            }

            while (memo[stableTransactions] == memoPrev[stableTransactions] && stableTransactions < n - 2)
                stableTransactions++;
            if (stableTransactions == n - 1)
                return memoPrev[n - 1];
            swap = memo;
            memo = memoPrev;
            memoPrev = swap;
        }

        return memoPrev[n - 1];
    }

    /**
     * Returns the profit of trades that are closed (sold) on the day. Longer running trades have higher profits or
     * they are not included. Only the highest profit for each length is included.
     */
    List<IntPair> getProfitAndTradeRunLengths(int position, int[] prices) {
        List<IntPair> ret = new ArrayList<>();

        int maxProfitSoFar = 0;
        for (int i = position - 1; i >= 0; i--) {
            int profit = prices[position] - prices[i];
            if (profit > maxProfitSoFar) {
                maxProfitSoFar = profit;
                ret.add(IntPair.of(profit, i));
            }
        }
        return ret;
    }

    public static final class IntPair {
        final int a;
        final int b;

        public static IntPair of(int a, int b) {
            return new IntPair(a, b);
        }

        public IntPair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
