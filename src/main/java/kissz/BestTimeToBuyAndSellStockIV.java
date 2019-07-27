package kissz;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIV {
    static class Params {
        final int k, begin, end;

        Params(int k, int begin, int end) {
            this.k = k;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return k << 26 + begin << 13 + end;
        }

        @Override
        public boolean equals(Object obj) {
            Params params = (Params) obj;
            return params.k == k && params.begin == begin && params.end == end;
        }
    }

    Map<Params, Integer> memo = new HashMap<>();

    public int maxProfit(int k, int[] prices) {
        if (k == 1) {
            return maxProfitForSlice(prices, 0, prices.length);
        } else if (k == 2) {
            return maxProfitTwoTrades(prices, 0, prices.length);
        } else {
            return maxProfit(k, prices, 0, prices.length);
        }
    }

    public int maxProfit(int k, int[] prices, int beginIndex, int endIndex) {
        Params params = new Params(k, beginIndex, endIndex);
        if (memo.containsKey(params)) {
            return memo.get(params);
        }

        int ret;
        if (k < 1) {
            ret = 0;
        } else if (k == 1) {
            ret = maxProfitForSlice(prices, beginIndex, endIndex);
        } else if (k == 2) {
            ret = maxProfitTwoTrades(prices, beginIndex, endIndex);
        } else {
            int k2, k3;
            if (k % 2 == 0) {
                k3 = k2 = k / 2;
            } else {
                k2 = k / 2 + 1;
                k3 = k / 2;
            }
            int maxProfit = 0;
            for (int sliceIndex = beginIndex; sliceIndex < endIndex; sliceIndex++) {
                int profit = maxProfit(k2, prices, beginIndex, sliceIndex)
                        + maxProfit(k3, prices, sliceIndex, endIndex);
                maxProfit = Math.max(maxProfit, profit);
            }
            ret = maxProfit;
        }

        memo.put(params, ret);
        return ret;
    }

    public int maxProfitTwoTrades(int[] prices, int beginIndex, int endIndex) {
        int maxProfit = 0;
        for (int sliceIndex = beginIndex; sliceIndex < endIndex; sliceIndex++) {
            int profit = maxProfitForSlice(prices, beginIndex, sliceIndex)
                    + maxProfitForSlice(prices, sliceIndex, endIndex);
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public int maxProfitForSlice(int[] prices, int beginIndex, int endIndex) {
        int n = endIndex - beginIndex;
        if (n < 2) return 0;

        int[] maxAfter = new int[n];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[beginIndex + i]);
            maxAfter[i] = max;
        }

        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int difference = maxAfter[i] - prices[beginIndex + i];
            if (difference > maxDifference) {
                maxDifference = difference;
            }
        }
        return maxDifference;
    }
}
