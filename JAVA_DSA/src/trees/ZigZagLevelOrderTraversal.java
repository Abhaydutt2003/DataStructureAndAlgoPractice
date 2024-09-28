package trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static void main(String args[]) {

    }

    // using normal level order traversal
    public static List<List<Integer>> util1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ans.add(new ArrayList<>(Arrays.asList(root.val)));
        boolean RightToLeft = true;
        Deque<TreeNode> current = new ArrayDeque<>();
        while (q.isEmpty() == false) {
            TreeNode curr = q.poll();
            if (curr == null) {
                if (current.size() != 0) {
                    List<Integer> toAdd = new ArrayList<>();
                    for (TreeNode i : current) {
                        toAdd.add(i.val);
                    }
                    ans.add(toAdd);
                    current = new ArrayDeque<>();
                    RightToLeft = (!RightToLeft);
                }
                if (q.isEmpty() == true) {
                    break;
                }
                q.add(null);
            } else if (RightToLeft) {
                if (curr.left != null) {
                    q.add(curr.left);
                    current.addFirst(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    current.addFirst(curr.right);
                }
            } else {
                if (curr.left != null) {
                    q.add(curr.left);
                    current.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    current.addLast(curr.right);
                }
            }
        }
        return ans;
    }
}
