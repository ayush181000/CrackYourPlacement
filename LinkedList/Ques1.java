package LinkedList;

public class Ques1 {

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

// Approach 1
class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
        }

        int mid = length / 2;

        int counter = 0;

        while (head != null) {
            if (counter == mid) {
                return head;
            }
            head = head.next;
            counter++;
        }
        return null;
    }
}

// // Approach 2
// class Solution {
// public ListNode middleNode(ListNode head) {
// ListNode f = head;
// ListNode s = head;
// while (f != null && f.next != null) {
// f = f.next.next;
// s = s.next;
// }
// return s;
// }
// }
