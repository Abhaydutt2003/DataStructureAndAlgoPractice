package trees;

import java.util.HashMap;

public class FlipEqui {

    public static void main(String[] args) {

    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        hm = new HashMap<>();
        return util1(root1, root2);
    }

    // easier solution
    public static boolean util2(TreeNode root1, TreeNode root2) {
        // bases cases
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null && root2 != null) {
            return false;
        } else if (root1 != null && root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }
        boolean case1 = (util2(root1.left, root2.left) && util2(root1.right, root2.right));
        if (case1) {
            return case1;
        }
        boolean case2 = (util2(root1.right, root2.left) && util2(root1.left, root2.right));
        return case2;
    }

    static HashMap<String, Boolean> hm;

    public static boolean util1(TreeNode root1, TreeNode root2) {
        // base cases
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null && root2 != null) {
            return false;
        } else if (root1 != null && root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }

        String key = root1 + "-" + root2;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        boolean ans = false;
        // the valid case
        boolean smallAns1 = util1(root1.left, root2.left);
        boolean smallAns2 = util1(root1.right, root2.right);
        if (smallAns1 == true && smallAns2 == true) {
            ans = true;
        }
        TreeNode left = root1.left;
        TreeNode right = root1.right;
        root1.left = right;
        root1.right = left;
        smallAns1 = util1(root1.left, root2.left);
        smallAns2 = util1(root1.right, root2.right);
        if (smallAns1 == true && smallAns2 == true) {
            ans = true;
        }
        root1.left = left;
        root1.right = right;
        hm.put(key, ans);
        return ans;
    }

}
