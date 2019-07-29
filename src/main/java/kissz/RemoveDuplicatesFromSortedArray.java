package kissz;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l == 0 || nums[i] != nums[l - 1]) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
