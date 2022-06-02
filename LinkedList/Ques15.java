/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode sum = add(l1, l2);
        return reverse(sum);
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = null, current = head, follow = head.next;
        while (current != null) {
            current.next = prev;
            prev = current;
            current = follow;
            follow = follow == null ? null : follow.next;
        }
        return prev;
    }

    private ListNode add(ListNode first, ListNode second) {
        ListNode newHead = null, running = null;
        int carry = 0;
        while (first != null || second != null || carry == 1) {
            int sum = carry;
            if (first != null) {
                sum += first.val;
                first = first.next;
            }
            if (second != null) {
                sum += second.val;
                second = second.next;
            }

            ListNode temp = new ListNode(sum % 10);
            temp.next = null;
            carry = sum / 10;

            if (newHead == null) {
                newHead = temp;
                running = temp;
            } else {
                running.next = temp;
                running = temp;
            }
        }
        return newHead;
    }
}
