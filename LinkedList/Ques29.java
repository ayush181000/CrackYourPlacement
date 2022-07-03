import java.util.*;

public class Ques29 {

}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

/*
 * Function which returns the root of
 * the flattened linked list.
 */

class GfG {
    Node flatten(Node root) {
        Node result = new Node(-1);

        while (root != null) {
            result = sortedMerge(result, root);
            root = root.next;
        }

        return result.bottom;
    }

    Node sortedMerge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        Node result = null;

        if (left.data <= right.data) {
            result = left;
            result.bottom = sortedMerge(left.bottom, right);
        } else {
            result = right;
            result.bottom = sortedMerge(left, right.bottom);
        }

        return result;
    }
}

class GfG2 {
    Node flatten(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        Node curr = root;

        while (curr != null) {
            list.add(curr.data);
            if (curr.bottom != null) {
                Node temp = curr.bottom;
                while (temp != null) {
                    list.add(temp.data);
                    temp = temp.bottom;
                }
            }
            curr = curr.next;
        }

        Collections.sort(list);
        // System.out.println(list);

        Node dummy = new Node(-1);
        Node ans = dummy;

        for (int i = 0; i < list.size(); i++) {
            Node temp = new Node(-1);
            temp.data = list.get(i);
            dummy.bottom = temp;
            dummy = dummy.bottom;
        }

        return ans.bottom;
    }
}