package kissz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// https://leetcode.com/problems/largest-number/
class LargestNumber {

    private static final Comparator<String> CMP = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            // reverse comparator, high values first
            final int l = a.length() + b.length();
            for (int i = 0; i < l; i++) {
                int c = Character.compare(charAt(b, a, i), charAt(a, b, i));
                if (c != 0) return c;
            }
            return 0;
        }
        private char charAt(String first, String second, int i) {
            if (i < first.length()) return first.charAt(i);
            return second.charAt(i - first.length());
        }
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
