package kissz;

import org.junit.Test;

import java.util.Arrays;

import static kissz.ListNodeTestsUtils.listNode;
import static kissz.ListNodeTestsUtils.toList;
import static org.junit.Assert.*;

public class RemoveNthNodeFromEndOfListTest {

    private RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();

    @Test
    public void example() {
        assertEquals(Arrays.asList(1, 2, 3, 5), toList(r.removeNthFromEnd(listNode(1, 2, 3, 4, 5), 2)));
        assertEquals(Arrays.asList(2, 3, 4, 5), toList(r.removeNthFromEnd(listNode(1, 2, 3, 4, 5), 5)));
        assertEquals(Arrays.asList(1, 2, 3, 4), toList(r.removeNthFromEnd(listNode(1, 2, 3, 4, 5), 1)));
        assertNull(r.removeNthFromEnd(listNode(2), 1));
        assertEquals(Arrays.asList(2), toList(r.removeNthFromEnd(listNode(1, 2), 2)));
    }

}