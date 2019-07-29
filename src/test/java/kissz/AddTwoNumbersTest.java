package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    @Test
    public void example() {
        ListNode r = new AddTwoNumbers().addTwoNumbers(
                fromInt(342),
                fromInt(465)
        );
        assertEquals(807, toInt(r));
    }

    private static ListNode fromInt(int n) {
        if (n == 0) return new ListNode(0);

        final ListNode lastDigit = new ListNode(n % 10);
        ListNode c = lastDigit;
        do {
            n /= 10;
            c.next = new ListNode(n % 10);
            c = c.next;
        } while (n > 0);
        return lastDigit;
    }

    public int toInt(ListNode c) {
        int m = 1;
        int ret = 0;
        while (c != null) {
            ret += c.val * m;
            m *= 10;
            c = c.next;
        }
        return ret;
    }
}