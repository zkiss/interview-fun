package kissz;


import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

        public static ListNode from(int... vals) {
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

        public List<Integer> toList() {
            LinkedList<Integer> res = new LinkedList<>();
            for (ListNode c = this; c != null; c = c.next) {
                res.add(c.val);
            }
            return res;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) throw new IllegalArgumentException();
        ListNode current = head;
        ListNode beforeNthBehind = null;
        int i = 0;
        while (current != null) {
            if (i >= n) {
                if (beforeNthBehind == null) beforeNthBehind = head;
                else beforeNthBehind = beforeNthBehind.next;
            }
            current = current.next;
            i++;
        }
        if (i >= n) {
            if (beforeNthBehind == null) head = head.next;
            else {
                beforeNthBehind.next = beforeNthBehind.next.next;
            }
        }
        return head;
    }


}
