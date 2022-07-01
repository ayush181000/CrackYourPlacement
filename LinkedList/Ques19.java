public class Ques19 {

}

/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node prev;
 * public Node next;
 * public Node child;
 * };
 */

class MySolution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node incoming = flatten(curr.child);

                curr.child = null;
                Node temp = curr.next == null ? null : curr.next;
                curr.next = incoming;
                incoming.prev = curr;

                while (incoming.next != null) {
                    incoming = incoming.next;
                }

                incoming.next = temp;
                if (temp != null)
                    temp.prev = incoming;
            }
            curr = curr.next;
        }

        return head;
    }
}

class Solution {

    public Node flatten(Node head) {
        if (head == null)
            return head;

        Node dummy = head;

        while (head != null) {
            if (head.child != null) {
                Node headNext = head.next;
                Node headChild = head.child;
                head.next = head.child;
                head.child = null;
                headChild.prev = head;

                while (headChild.next != null) {
                    headChild = headChild.next;
                }

                headChild.next = headNext;

                if (headNext != null) {
                    headNext.prev = headChild;
                }
            }

            head = head.next;
        }

        return dummy;
    }
}