package kissz;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * https://leetcode.com/problems/divisor-game/
 */
public class DivisorGame {

    //    private static final long[] ANSWERS = new long[1000/64+1];
    //    private static final long[] HAS_ANSWER = new long[1000/64+1];
    //
    private static boolean get(long[] array, int n) {
        int idx = n / 64;
        long mask = 1L << (n % 64);
        return (array[idx] & mask) != 0;
    }

    private static void set(long[] array, int n, boolean value) {
        int idx = n / 64;
        long bit = 1L << (n % 64);
        if (value) {
            array[idx] |= bit;
        } else {
            array[idx] &= ~bit;
        }
    }

    public boolean divisorGame(int n) {
        // ends up being equal to n % 2 == 0
        long[] canWin = new long[n / 64 + 1];
        long[] hasAnswers = new long[n / 64 + 1];
        return canWin(canWin, hasAnswers, n);
    }

    private boolean canWin(long[] canWin, long[] hasAnswers, int n) {
        if (get(hasAnswers, n)) return get(canWin, n);

        Iterator<Integer> divs = divisorsDecreasing(n);
        while (divs.hasNext()) {
            // checking answers in increasing order
            int answer = n - divs.next();
            if (get(hasAnswers, answer) && !get(canWin, answer)) {
                set(canWin, n, true);
                set(hasAnswers, n, true);
                return true;
            }
            if (!get(hasAnswers, answer)) {
                // see if this answer beats the opponent
                boolean answerWins = canWin(canWin, hasAnswers, answer);
                set(canWin, answer, answerWins);
                set(hasAnswers, answer, true);
                if (!answerWins) return true;
            }
        }
        return false;
    }

    private static int END = -1;

    static Iterator<Integer> divisorsDecreasing(int n) {
        return new Iterator<Integer>() {
            private int next = findNext(n / 2);

            private int findNext(int start) {
                for (int x = start; x >= 1; x--) {
                    if (n % x == 0) return x;
                }
                return END;
            }

            @Override
            public boolean hasNext() {
                return next != END;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                int ret = next;
                next = findNext(ret - 1);
                return ret;
            }
        };
    }
}
