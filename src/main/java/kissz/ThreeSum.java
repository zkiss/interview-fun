package kissz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>(0);

        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        for (int first = 0; first < nums.length; ) {
            int second = first + 1;
            while (second < nums.length) {
                int secondNumber = nums[second];
                int searching = 0 - nums[first] - secondNumber;
                if (searching == secondNumber && second + 1 < nums.length && nums[second + 1] == secondNumber) {
                    res.add(Arrays.asList(nums[first], secondNumber, secondNumber));
                } else if (searching > secondNumber) {
                    int idx = Arrays.binarySearch(nums, searching);
                    if (idx > second) {
                        res.add(Arrays.asList(nums[first], secondNumber, searching));
                    }
                }
                while (second < nums.length && nums[second] == secondNumber) second++;
            }
            int firstNumber = nums[first];
            while (first < nums.length && nums[first] == firstNumber) first++;
        }
        return res;
    }
}
