package kissz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// https://leetcode.com/problems/largest-number/
class LargestNumber {

    // slow version

    private static final Comparator<String> CMP = (a, b) -> {
        // reverse comparator, high values first
        return (b + a).compareTo(a + b);
    };

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(s, CMP);

        StringBuilder sb = new StringBuilder();
        for (String value : s) {
            sb.append(value);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}

class NumsComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}

class LargestNumberFast {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, new NumsComparator());
        for (String str : strs) {
            sb.append(str);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

}