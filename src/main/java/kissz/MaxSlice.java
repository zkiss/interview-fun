package kissz;

public class MaxSlice {
    public int largestSumSlice(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(0, current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
