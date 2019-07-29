package kissz;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (end < start) throw new IllegalArgumentException();
        if (start == end) return null;
        if (start + 1 == end) return lists[start];

        ListNode a = merge(lists, start, (start + end) / 2);
        ListNode b = merge(lists, (start + end) / 2, end);
        if (a == null && b == null) return null;

        ListNode head = null;
        ListNode last = null;
        while (a != null && b != null) {
            ListNode min;
            if (a.val < b.val) {
                min = a;
                a = a.next;
            } else {
                min = b;
                b = b.next;
            }
            if (head == null) {
                head = min;
                last = head;
            } else {
                last.next = min;
                last = last.next;
            }
        }
        ListNode remaining = a != null ? a : b;
        if (head == null) head = remaining;
        else last.next = remaining;

        return head;
    }
}