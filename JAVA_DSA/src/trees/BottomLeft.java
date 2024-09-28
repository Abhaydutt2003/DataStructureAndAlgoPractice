package trees;

import java.util.*;

public class BottomLeft {

    public static void main(String[] args) {

    }

    public static int util1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode ans = root;
        while (q.isEmpty() == false) {
            TreeNode current = q.poll();
            if (current == null) {
                if (q.isEmpty() == true) {
                    break;
                }
                q.add(null);
            } else {
                ans = current;
                if (ans.right != null) {
                    q.add(current.right);
                }
                if (ans.left != null) {
                    q.add(current.left);
                }
            }
        }
        return ans.val;
    }

}
