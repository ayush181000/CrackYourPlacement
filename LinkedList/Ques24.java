public class Ques24 {

}

// User function Template for Java

/*
 * class Node{
 * int data;
 * Node next;
 * 
 * Node(int x){
 * data = x;
 * next = null;
 * }
 * }
 */

class Solution {
    Node divide(int N, Node head) {
        Node curr = head;
        Node evenStart = new Node(0);
        Node evenEnd = evenStart;
        Node oddStart = new Node(0);
        Node oddEnd = oddStart;

        while (curr != null) {

            if (curr.data % 2 != 0) {
                oddEnd.next = curr;
                oddEnd = oddEnd.next;
            } else {
                evenEnd.next = curr;
                evenEnd = evenEnd.next;
            }

            curr = head.next;
        }

        evenEnd.next = oddStart.next;

        return evenStart.next;

    }
}