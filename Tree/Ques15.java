package Tree;

public class Ques15 {

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

    public boolean isBalanced(TreeNode root) {
        return isBalanced2(root) != -1;
    }

    private int isBalanced2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalanced2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalanced2(root.right);
        if (right == -1) {
            return -1;
        }
        if (right - left >= -1 && right - left <= 1) {
            return Math.max(left, right) + 1;
        }
        return -1;
    }
}

class Pair {
    int height;
    boolean balance;

    public Pair(int h, boolean b) {
        this.height = h;
        this.balance = b;
    }
}

class Solution2 {

    public boolean isBalanced(TreeNode root) {
        Pair ans = helper(root);
        return ans.balance;
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair leftPair = helper(root.left);
        Pair rightPair = helper(root.right);

        boolean bal = leftPair.balance && rightPair.balance && Math.abs(leftPair.height - rightPair.height) <= 1;
        int height = 1 + Math.max(leftPair.height, rightPair.height);

        return new Pair(height, bal);
    }
}

class Solution3 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftB = height(root.left);
        int rightB = height(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(rightB - leftB) <= 1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
