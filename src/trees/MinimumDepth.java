package trees;

public class MinimumDepth {

    public static void main(String args[]) {

    }

    public static int util1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    public static int helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            int leftAns = helper(root.left);
            int rightAns = helper(root.right);
            return Math.min(leftAns, rightAns) + 1;
        } else if (root.left == null && root.right != null) {
            return helper(root.right) + 1;
        } else {
            return helper(root.left) + 1;
        }
    }
}
