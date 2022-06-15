package Tree;

public class Ques1 {

}

class Solution {

    class Pair {
        int height;
        int dia;

        Pair(int h, int d) {
            height = h;
            dia = d;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = helper(root);
        return ans.dia;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            Pair p = new Pair(0, 0);
            return p;
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int leftHeight = left.height;
        int rightHeight = right.height;
        int leftDia = left.dia;
        int rightDia = right.dia;

        int height = 1 + Math.max(leftHeight, rightHeight);
        int dia = Math.max(Math.max(leftDia, rightDia), (leftHeight + rightHeight));

        Pair ans = new Pair(height, dia);
        return ans;
    }
}
