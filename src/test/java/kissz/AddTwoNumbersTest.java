package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    @Test
    public void example() {
        ListNode r = new AddTwoNumbers().addTwoNumbers(
                ListNode.fromInt(342),
                ListNode.fromInt(465)
        );
        assertEquals(807, r.toInt());
    }
}