package kissz;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 1; i >= 0; i--) {
            int costStep1 = 0;
            if (i + 1 < cost.length) costStep1 = cost[i + 1];
            int costStep2 = 0;
            if (i + 2 < cost.length) costStep2 = cost[i + 2];
            cost[i] = cost[i] + Math.min(costStep1, costStep2);
        }
        return Math.min(cost[0], cost[1]);
    }
}
