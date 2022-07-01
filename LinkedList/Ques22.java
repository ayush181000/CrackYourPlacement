public class Ques22 {

}

/*
 * Node is as follows:
 * 
 * class Node {
 * int data;
 * Node next;
 * Node(int d) {
 * data = d;
 * next = null;
 * }
 * }
 * 
 */

class Solution {
    public static Node zigZag(Node head) {
        boolean leftBig = false;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (leftBig) {
                if (prev.data < curr.data) {
                    swap(prev, curr);
                }
            } else {
                if (prev.data > curr.data) {
                    swap(prev, curr);
                }
            }

            prev = curr;
            curr = curr.next;
            leftBig = !leftBig;
        }

        return head;
    }

    public static void swap(Node head1, Node head2) {
        int temp = head1.data;
        head1.data = head2.data;
        head2.data = temp;
    }
}