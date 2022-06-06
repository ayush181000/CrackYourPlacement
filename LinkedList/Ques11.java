public class Ques11 {

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

/**
 * In place, reverse starting with the middle point
 * 1->2->3->2->1 =====> 1->2->3<-2<-1
 * I dont have to keep count if the list is even or odd
 * as I compare the tail pointer with the median to stop
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        else if (head.next == null)
            return true;
        int size = 1;
        ListNode slowerP = head;
        ListNode fasterP = head.next;

        ListNode tempNode = slowerP.next;
        slowerP.next = null;

        while (fasterP != null) {
            for (int i = 0; i < 2; i++) {
                if (fasterP != null)
                    fasterP = fasterP.next;
                else
                    break;
                size++;
            }
            ListNode temp = slowerP;
            slowerP = tempNode;
            tempNode = slowerP.next;
            slowerP.next = temp;
        }

        fasterP = slowerP.next;
        if (size % 2 != 0) {
            slowerP = tempNode;
            tempNode = tempNode.next;
        }

        while (slowerP != null) {
            if (slowerP.val != fasterP.val)
                return false;
            fasterP = fasterP.next;
            slowerP = tempNode;
            tempNode = (tempNode == null) ? null : tempNode.next;
        }
        return true;
    }
}
