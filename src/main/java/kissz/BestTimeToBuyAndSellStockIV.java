package kissz;

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
        k = Math.min(k, prices.length / 2);

        if (n < 2) return 0;
        int[] memo = new int[prices.length];
        int[] memoPrev = new int[prices.length];
        int[] swap;


        // Don't iterate twice over the part of memo that is not changing.
        int stableTransactions = 0;
        for (int numberOfTransactions = 1; numberOfTransactions <= k; numberOfTransactions++) {
            System.out.println("number of transactions: " + numberOfTransactions);
            for (int priceHistoryLength = 2; priceHistoryLength <= n; priceHistoryLength++) {
                int[] maxAfter = new int[priceHistoryLength];
                int max = 0;
                for (int i = priceHistoryLength - 1; i >= 0; i--) {
                    max = Math.max(max, prices[i]);
                    maxAfter[i] = max;
                }

                int maxProfit = memoPrev[priceHistoryLength - 1];
                for (int lastTransactionStart = stableTransactions; lastTransactionStart < priceHistoryLength - 1; lastTransactionStart++) {

                    int profit = maxProfitForSlice(prices, maxAfter, lastTransactionStart, priceHistoryLength);
                    if (lastTransactionStart > 0) {
                        profit += memoPrev[lastTransactionStart - 1];
                    }
                    maxProfit = Math.max(maxProfit, profit);
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

    public int maxProfitForSlice(int[] prices, int[] maxAfter, int beginIndex, int endIndex) {
        int n = endIndex - beginIndex;
        if (n < 2) return 0;

        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int difference = maxAfter[beginIndex + i] - prices[beginIndex + i];
            if (difference > maxDifference) {
                maxDifference = difference;
            }
        }
        return maxDifference;
    }
}
