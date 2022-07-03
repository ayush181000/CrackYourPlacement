public class Ques20 {

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

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode();
        ListNode result = res;
        ListNode sol = new ListNode();
        ListNode solution = sol;
        ListNode p1 = head;
        while (p1 != null) {
            if (p1.val < x) {
                res.next = p1;
                res = res.next;
            } else {
                sol.next = p1;
                sol = sol.next;
            }
            p1 = p1.next;
        }
        res.next = solution.next;
        sol.next = null;
        return result.next;
    }
}
