package kissz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIdx = new HashMap<>(nums.length, 1.0f);
        for (int i = 0; i < nums.length; i++) {
            int needs = target - nums[i];
            Integer idx = valueIdx.get(needs);
            if (idx != null) return new int[]{idx, i};
            valueIdx.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
