package kissz;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    /*

    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]

     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double r = myPow(x, n / 2);
        r *= r;
        if (n % 2 != 0) {
            if (n > 0) r *= x;
            else r /= x;
        }
        return r;
    }
}
