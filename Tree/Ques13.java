package Tree;

public class Ques13 {

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

class Solution {
    private int prevVal = Integer.MAX_VALUE;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;

        getMinimumDifference(root.left);
        minDiff = Math.min(minDiff, Math.abs(prevVal - root.val));
        prevVal = root.val;
        getMinimumDifference(root.right);

        return minDiff;
    }
}
