package kissz;

import java.util.LinkedList;
import java.util.List;

public class ListNodeTestsUtils {
    public static ListNode listNode(int... vals) {
        ListNode head = null;
        ListNode current = null;
        for (int val : vals) {
            if (head == null) {
                head = new ListNode(val);
                current = head;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }
        return head;
    }

    public static List<Integer> toList(ListNode c) {
        LinkedList<Integer> res = new LinkedList<>();
        for (; c != null; c = c.next) {
            res.add(c.val);
        }
        return res;
    }
}
