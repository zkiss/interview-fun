package kissz;

import kissz.RemoveNthNodeFromEndOfList.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndOfListTest {

    private RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();

    @Test
    public void example() {
        assertEquals(Arrays.asList(1, 2, 3, 5), r.removeNthFromEnd(ListNode.from(1, 2, 3, 4, 5), 2).toList());
        assertEquals(Arrays.asList(2, 3, 4, 5), r.removeNthFromEnd(ListNode.from(1, 2, 3, 4, 5), 5).toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), r.removeNthFromEnd(ListNode.from(1, 2, 3, 4, 5), 1).toList());
        assertNull(r.removeNthFromEnd(ListNode.from(2), 1));
        assertEquals(Arrays.asList(2), r.removeNthFromEnd(ListNode.from(1, 2), 2).toList());
    }

}