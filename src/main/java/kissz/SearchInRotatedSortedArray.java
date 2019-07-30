package kissz;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int offset = findOffset(nums);

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int check = (mid + offset) % nums.length;
            if (nums[check] == target) return check;
            if (nums[check] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private int findOffset(int[] nums) {
        if (nums.length < 2) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (nums[lo] > nums[hi]) {
            int mid = (lo + hi) / 2;
            if (mid == lo) {
                if (nums[lo] > nums[hi]) lo = hi;
                else hi = lo;
            } else if (nums[lo] > nums[mid]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

}
