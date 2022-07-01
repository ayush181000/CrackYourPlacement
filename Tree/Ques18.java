package Tree;

public class Ques18 {

}

/*
 * class Node {
 * int data;
 * Node left, right;
 * 
 * Node(int item) {
 * data = item;
 * left = right = null;
 * }
 * }
 */

// Function should return true if a deadEnd is found in the bst otherwise return
// false.
class GFG {
    public static boolean isDeadEnd(Node root) {
        return helper(0, root, Integer.MAX_VALUE);
    }

    public static boolean helper(int min, Node root, int max) {
        // base case
        if (root == null) {
            return false;
        }

        // main case
        if (root.data == max - 1 && root.data == min + 1)
            return true;

        return helper(min, root.left, root.data) || helper(root.data, root.right, max);
    }

}