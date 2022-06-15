package Tree;

import java.util.*;

public class Ques9 {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Time: O(N^2) - N based on number of nodes in root and N based on String
// appending, O(N log N) for best case
// Space: O(N) - N based on number of nodes in root (due to list sizing)
// Recursive top down using StringBuilder
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        // Using a StringBuilder to avoid making a String copy for every node
        StringBuilder sb = new StringBuilder();
        traverse(root, paths, sb);
        return paths;
    }

    private void traverse(TreeNode root, List<String> paths, StringBuilder sb) {
        if (root == null)
            return;
        // This length is to allow the path to 'backtrack' back to the initial root
        // value with the String pathing
        int len = sb.length();
        // Add the root value to the String
        sb.append(root.val);
        // If the leaf node is found we will add the entire StringBuilder to the list
        if (root.left == null && root.right == null)
            paths.add(sb.toString());
        else {
            // We add the string pathing
            sb.append("->");
            // Traverse on left and right subtrees
            traverse(root.left, paths, sb);
            traverse(root.right, paths, sb);
        }
        // 'Backtrack' the String pathing to the original value of the root value
        sb.setLength(len);
    }
}

class Solution2 {
    List<String> output = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return output;
    }

    public void helper(TreeNode root, String currPath) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            output.add(currPath + root.val);
        }

        helper(root.left, currPath + root.val + "->");
        helper(root.right, currPath + root.val + "->");
    }
}
