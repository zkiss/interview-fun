package kissz;

public class StockBuying {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            if (p < min) {
                min = p;
                max = p;
            }
            if (p > max) max = p;
            int profit = max - min;
            if (maxProfit < profit) maxProfit = profit;
        }
        return maxProfit;
    }
}
