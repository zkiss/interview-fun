package kissz;


/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
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
