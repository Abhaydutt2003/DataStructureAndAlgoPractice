package trees;

public class GoodNodes {

    public static void main(String args[]) {

    }

    static int ans = 0;

    public static int util1(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    public static void dfs(TreeNode root, int maxNode) {
        if (root == null) {
            return;
        }
        maxNode = Math.max(maxNode, root.val);
        if (root.val >= maxNode) {
            ans++;
        }
        dfs(root.left, maxNode);
        dfs(root.right, maxNode);
    }

}
