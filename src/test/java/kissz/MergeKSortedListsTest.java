package kissz;

import org.junit.Test;

import java.util.Arrays;

import static kissz.ListNodeTestsUtils.listNode;
import static kissz.ListNodeTestsUtils.toList;
import static org.junit.Assert.*;

public class MergeKSortedListsTest {
    private MergeKSortedLists ml = new MergeKSortedLists();

    @Test
    public void example() {
        assertEquals(
                Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6),
                toList(ml.mergeKLists(new ListNode[]{
                        listNode(1, 4, 5),
                        listNode(1, 3, 4),
                        listNode(2, 6)
                }))
        );

        assertEquals(
                null,
                ml.mergeKLists(new ListNode[]{null})
        );
    }
}