package kissz;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // idx:0 = 2 * divisor
        // idx:1 = 2*2 * divisor
        // idx:2 = 2*2*2 * divisor
        ArrayList<Integer> divisorTimesTwoOnNth = new ArrayList<>(31);
        ArrayList<Integer> multipliers = new ArrayList<>(31);
        int sum = divisor;
        int res = 0;
        int currentMultiplier = 1;
        while (sum < dividend) {
            currentMultiplier += currentMultiplier;
            multipliers.add(currentMultiplier);
            if (divisorTimesTwoOnNth.isEmpty()) {
                divisorTimesTwoOnNth.add(divisor + divisor);
            } else {
                int last = divisorTimesTwoOnNth.get(divisorTimesTwoOnNth.size() - 1);
                divisorTimesTwoOnNth.add(last + last);
            }
            if (sum <= dividend - divisorTimesTwoOnNth.get(divisorTimesTwoOnNth.size() - 1)) {
                sum += divisorTimesTwoOnNth.get(divisorTimesTwoOnNth.size() - 1);
                res += currentMultiplier;
            } else {
                // go backwards
                for(int i=divisorTimesTwoOnNth.size()-1;i>-1;i--) {
                    if(sum <= dividend - divisorTimesTwoOnNth.get(i)) {
                        sum += divisorTimesTwoOnNth.get(i);
                        res += multipliers.get(i);
                    }
                }
            }
        }
        return res;
    }


}
