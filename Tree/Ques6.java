package Tree;

public class Ques6 {

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

    public TreeNode bst(int l, int r, int[] arr) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = bst(l, mid - 1, arr);
        n.right = bst(mid + 1, r, arr);

        return n;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = bst(l, mid - 1, nums);
        root.right = bst(mid + 1, r, nums);

        return root;
    }
}
