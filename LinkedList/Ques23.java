import java.util.*;

public class Ques23 {

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

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode start, ListNode end) {
        if (start == null || start.next == null || start == end) {
            return start;
        }
        int pivot = start.val;
        ListNode left = start;
        ListNode right = start;
        ListNode curr = start.next;
        boolean sorted = true;

        while (curr != null && curr != end) {
            ListNode temp = curr.next;
            if (curr.val < pivot) {
                sorted = false;
                curr.next = left;
                left = curr;
                right.next = temp;
            } else if (curr.val < right.val) {
                sorted = false;
                right = curr;
            } else {
                right = curr;
            }
            curr = temp;
        }
        if (sorted) {
            return start;
        }
        start.next = sortList(start.next, end);
        left = sortList(left, start);
        return left;
    }
}

class Solution2 {

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            l.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(l);

        curr = head;
        for (int i = 0; i < l.size(); i++) {
            curr.val = l.get(i);
            curr = curr.next;
        }

        return head;
    }
}
