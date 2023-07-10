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

    public static int bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        while (q.isEmpty() == false) {
            int size = q.size();
            while (size > 0) {
                TreeNode current = q.poll();
                size--;
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right == null) {
                    q.add(current.right);
                }
            }
            depth++;
        }
        return -1;
    }
}
