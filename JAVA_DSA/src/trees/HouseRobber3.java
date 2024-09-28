package trees;

import java.util.*;

class lc337 {
    Integer parentLooted;
    Integer parentNotLooted;

    lc337(int parentLooted, int parentNotLooted) {
        this.parentLooted = parentLooted;
        this.parentNotLooted = parentNotLooted;
    }
}

public class HouseRobber3 {

    public static void main(String args[]) {

    }

    static HashMap<TreeNode, Integer> hm1;
    static HashMap<TreeNode, Integer> hm2;

    public static int util1(TreeNode root) {
        // hm1 = new HashMap<>();
        // hm2 = new HashMap<>();
        // return helper2(root, false);
        // return helper(root, false);
        hm1 = new HashMap<>();
        return helper3(root);
    }

    public static int helper3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (hm1.containsKey(root)) {
            return hm1.get(root);
        }
        int lootSelf = root.val;
        if (root.left != null) {
            lootSelf += helper3(root.left.left) + helper3(root.left.right);
        }
        if (root.right != null) {
            lootSelf += helper3(root.right.left) + helper3(root.right.right);
        }
        int notLootSelf = helper3(root.left) + helper3(root.right);
        int ans = Math.max(lootSelf, notLootSelf);
        hm1.put(root, ans);
        return ans;
    }

    public static int helper(TreeNode root, boolean parentLooted) {
        if (root == null) {
            return 0;
        }

        if (parentLooted) {
            int ans1 = helper(root.left, false);
            int ans2 = helper(root.right, false);
            return ans1 + ans2;
        } else {
            int ans1 = helper(root.left, false);
            int ans2 = helper(root.right, false);
            int smallAns1 = ans1 + ans2;
            int ans3 = helper(root.left, true);
            int ans4 = helper(root.right, true);
            int smallAns2 = ans3 + ans4 + root.val;
            return Math.max(smallAns1, smallAns2);
        }
    }

    public static int helper2(TreeNode root, boolean parentLooted) {
        if (root == null) {
            return 0;
        }

        if (parentLooted) {
            if (hm1.containsKey(root)) {
                return hm1.get(root);
            }
            int ans1 = helper2(root.left, false);
            int ans2 = helper2(root.right, false);
            hm1.put(root, ans1 + ans2);
            return ans1 + ans2;
        } else {
            if (hm2.containsKey(root)) {
                return hm2.get(root);
            }
            int ans1 = helper2(root.left, false);
            int ans2 = helper2(root.right, false);
            int smallAns1 = ans1 + ans2;
            int ans3 = helper2(root.left, true);
            int ans4 = helper2(root.right, true);
            int smallAns2 = ans3 + ans4 + root.val;
            int ans = Math.max(smallAns1, smallAns2);
            hm2.put(root, ans);
            return ans;
        }
    }

}
