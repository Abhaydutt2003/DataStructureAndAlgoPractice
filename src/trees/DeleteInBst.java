package trees;

public class DeleteInBst {
    public static void main(String args[]) {
        // works..
    }

    public static TreeNode delete(TreeNode root, int key) {
        TreeNode newTree = helper1(root, key);
        return newTree;
    }

    public static TreeNode helper1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = helper1(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = helper1(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else {
                if (root.left == null && root.right != null) {
                    return root.right;
                } else if (root.right == null && root.left != null) {
                    return root.left;
                } else {
                    TreeNode a = findInorderSuccessor(root.right);
                    root.val = a.val;
                    root.right = helper1(root.right, a.val);
                    return root;
                }
            }
        }
    }

    private static TreeNode findInorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
