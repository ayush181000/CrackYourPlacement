package LinkedList;

public class Ques12 {

}

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

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while (curr != null) {
            // Linking steps
            next = curr.next;
            curr.next = prev;

            // Advancement steps
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
