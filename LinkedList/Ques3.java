package LinkedList;

public class Ques3 {

}

// 1 1 0 = 6
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

    public int getDecimalValue(ListNode head) {
        int length = 0;
        ListNode copy = head;

        while (copy != null) {
            length++;
            copy = copy.next;
        }

        length--;
        int val = 0;
        while (head != null) {
            val = val + (int) (head.val * Math.pow(2, length--));
            head = head.next;
        }

        System.out.println(length);
        return val;
    }
}
