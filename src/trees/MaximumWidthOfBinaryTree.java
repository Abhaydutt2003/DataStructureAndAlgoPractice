package trees;

import java.util.*;

class helper3 {
    TreeNode current;
    int index;

    helper3(TreeNode current, int index) {
        this.current = current;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode root = getInput();
        System.out.println(util1(root));
    }

    public static int util1(TreeNode root) {
        Queue<helper3> q = new LinkedList<>();
        q.add(new helper3(root, 0));
        q.add(null);
        int leftMost = -1;
        int rightMost = -1;
        int ans = 0;
        while (q.isEmpty() == false) {
            helper3 h = q.poll();
            if (h == null) {
                ans = Math.max(ans, ((rightMost - leftMost) + 1));
                if (q.isEmpty() == true) {
                    continue;
                }
                leftMost = -1;
                rightMost = -1;
                q.add(null);
            } else {

                if (leftMost == -1) {
                    leftMost = h.index;
                    rightMost = h.index;
                } else {
                    rightMost = h.index;
                }

                if (h.current.left != null) {
                    helper3 toPut = new helper3(h.current.left, (h.index) * 2);
                    q.add(toPut);
                }

                if (h.current.right != null) {
                    helper3 toPut = new helper3(h.current.right, (((h.index) * 2) + 1));
                    q.add(toPut);
                }
            }
        }
        return ans;
    }

    public static TreeNode getInput() {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
        System.out.println("Enter the value of the root");
        int rootVal = s.nextInt();
        TreeNode root = new TreeNode(rootVal);
        pendingNodes.add(root);
        while (pendingNodes.isEmpty() != true) {
            TreeNode temp = pendingNodes.poll();
            System.out.println("Enter the left child of " + temp.val);
            int leftData = s.nextInt();
            if (leftData != -1) {
                TreeNode leftChild = new TreeNode(leftData);
                temp.left = leftChild;
                pendingNodes.add(leftChild);
            }
            System.out.println("Enter the right child of " + temp.val);
            int rightData = s.nextInt();
            if (rightData != -1) {
                TreeNode rightChild = new TreeNode(rightData);
                temp.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }

}
