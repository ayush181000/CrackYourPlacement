public class Ques26 {

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

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if (l1 == null && l2 != null) {
            node.next = l2;
        } else {
            node.next = l1;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = (start + end) / 2;
        ListNode fh = mergeLists(lists, start, mid);
        ListNode sh = mergeLists(lists, mid + 1, end);
        return mergeTwoLists(fh, sh);
    }
}

class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int currMin = Integer.MAX_VALUE;
        int minNode = -1;
        int counter = 0;
        int n = lists.length;
        while (true) {
            for (int i = 0; i < n; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    counter++;
                    continue;
                }
                if (node.val < currMin) {
                    currMin = node.val;
                    minNode = i;
                }
            }
            if (counter == n)
                break;
            ListNode newNode = new ListNode(currMin);
            dummy.next = newNode;
            dummy = dummy.next;
            lists[minNode] = lists[minNode].next;
            minNode = -1;
            currMin = Integer.MAX_VALUE;
            counter = 0;
        }
        return ans.next;
    }
}
