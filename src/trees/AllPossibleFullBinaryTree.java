package trees;

import java.util.*;

public class AllPossibleFullBinaryTree {

    public static void main(String args[]) {

    }

    static HashMap<Integer, List<TreeNode>> hm = new HashMap<>();

    public static List<TreeNode> util1(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }
        if (hm.containsKey(n)) {
            return hm.get(n);
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i <= (n - 2); i++) {
            List<TreeNode> left = util1(i);
            List<TreeNode> right = util1(n - i - 1);
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(0, leftRoot, rightRoot);
                    ans.add(root);
                }
            }
        }
        hm.put(n, ans);
        return ans;
    }

}
