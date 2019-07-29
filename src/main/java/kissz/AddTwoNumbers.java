package kissz;


/**
 * https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lastDigit = null;
        ListNode curr = null;
        int c = 0;
        do {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = a + b + c;
            if (curr != null) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            if (lastDigit == null) {
                lastDigit = new ListNode(0);
                curr = lastDigit;
            }
            curr.val = sum % 10;
            if (sum >= 10) c = 1;
            else c = 0;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        } while (l1 != null || l2 != null || c != 0);

        return lastDigit;
    }
}
