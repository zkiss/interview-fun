package kissz;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Stores the least number of coins to change amount or current number of iterations whichever is lower.
        int[] result = new int[amount + 1];
        Arrays.fill(result, 1, amount + 1, -1);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    int prevIndex = i - coins[j];
                    int prevResult;
                    if (prevIndex >= 0) {
                        prevResult = result[prevIndex];
                    } else {
                        prevResult = -1;
                    }
                    if (prevResult >= 0 && (prevResult + 1 < result[i] || result[i] == -1)) {
                        result[i] = prevResult + 1;
                        changed = true;
                    }
                }
            }
        }
        return result[amount];
    }
}
