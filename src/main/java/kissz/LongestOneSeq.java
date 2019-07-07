package kissz;

public class LongestOneSeq {

    public static int lengthOfLongestPossibleOneSeqAfterOneBitSet(int input) {
        if (input == Integer.MIN_VALUE) return 32;
        int onesBefore = 0;
        int maxRunLength = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((input & mask) != 0) {
                onesBefore++;
            } else {
                int onesAfter = onesAfter(i, input);
                int runLength = 1 + onesBefore + onesAfter;
                if (runLength > maxRunLength) {
                    maxRunLength = runLength;
                }
                onesBefore = onesAfter;
                i += onesAfter;
            }
        }
        return maxRunLength;
    }

    private static int onesAfter(int index, int input) {
        if (index == 31) return 0;
        int ret = 0;
        for (int i = index + 1; i < 32; ++i) {
            if ((input & (1 << i)) != 0) ++ret;
            else break;
        }
        return ret;
    }
}
