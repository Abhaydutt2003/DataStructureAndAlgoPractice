package trees;

import java.util.*;

public class PathSum3 {

    public static void main(String args[]) {
        TreeNode root = getInput();
        // util1(root, 3, 0);
        // util2(root,3);
        hm.put(0L, 1);
        util3(root, 0, 8);
        System.out.print(ans);
    }

    static int ans = 0;

    // failed approach..
    public static void util1(TreeNode root, int target, int sumTillNow) {
        if (root == null) {
            return;
        }
        sumTillNow += root.val;
        if (target == sumTillNow) {
            ans++;
        }
        util1(root.left, target, sumTillNow);
        util1(root.right, target, sumTillNow);
        util1(root.left, target, 0);
        util1(root.right, target, 0);
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
        s.close();
        return root;
    }

    public static void util2(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        helper1(root, target, 0);
        util2(root.left, target);
        util2(root.right, target);
    }

    private static void helper1(TreeNode root, int target, int sumTillNow) {
        if (root == null) {
            return;
        }
        sumTillNow += root.val;
        if (sumTillNow == target) {
            ans++;
        }
        helper1(root.left, target, sumTillNow);
        helper1(root.right, target, sumTillNow);
    }

    // amazing method to use hashMap and bactracking to get ans

    static HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

    public static void util3(TreeNode root, long sumTillNow, int target) {
        if (root == null) {
            return;
        }
        sumTillNow += root.val;
        if (hm.containsKey(sumTillNow - target)) {
            if (hm.get(sumTillNow - target) > 0) {
                ans += hm.get(sumTillNow - target);
            }
        }
        hm.put(sumTillNow, hm.getOrDefault(sumTillNow, 0) + 1);
        util3(root.left, sumTillNow, target);
        util3(root.right, sumTillNow, target);
        hm.put(sumTillNow, hm.get(sumTillNow) - 1);//backtrack.
    }

}
