package trees;

public class DeepestLeavesSum {

    public static void main(String args[]) {

    }

    static int maxHeight = Integer.MIN_VALUE;
    static int sum = 0;

    public static int util1(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public static void dfs(TreeNode root, int currHeight) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (currHeight > maxHeight) {
                maxHeight = currHeight;
                sum = root.val;
            } else if (currHeight == maxHeight) {
                sum += root.val;
            }
        }
        dfs(root.left, currHeight + 1);
        dfs(root.right, currHeight + 1);
    }

}
