public class Ques9 {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slow = headA;
        ListNode fast = headB;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
            if (slow == null) {
                slow = headB;
            }
            if (fast == null) {
                fast = headA;
            }
        }
        return slow;
    }
}
