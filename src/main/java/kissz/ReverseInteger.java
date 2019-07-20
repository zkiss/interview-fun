package kissz;

public class ReverseInteger {
    private static final int MAX = Integer.MAX_VALUE / 10;
    private static final int MIN = Integer.MIN_VALUE / 10;

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > MAX || res < MIN) return 0;
            int n = x % 10;
            if (res == MAX && n > 0b111) return 0;
            if (res == MIN && n < -8) return 0;
            res *= 10;
            res += n;
            x /= 10;
        }
        return res;
    }
}
