public class Ques18 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int l = 0;
        for (; tmp != null;) {
            l++;
            tmp = tmp.next;
        }
        if (l == 1)
            return null;
        if (l == n)
            return head.next;
        tmp = head;
        for (int i = 1; i < l - n; i++) {
            tmp = tmp.next;
        }
        ListNode node = tmp.next;
        tmp.next = node.next;
        node.next = null;
        return head;
    }
}
