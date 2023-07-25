package trees;

import java.util.*;

import dynamicProgramming.pair2;

public class UniqueBst2 {

    public static void main(String args[]) {

    }

    static HashMap<pair2, List<TreeNode>> hm2;

    public static List<TreeNode> util2(int n) {
        hm = new HashMap<>();
        return helper2(1, n);
    }

    public static List<TreeNode> helper2(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        pair2 key = new pair2(start, end);
        if (hm2.containsKey(key)) {
            return hm2.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper2(start, i - 1);
            List<TreeNode> right = helper2(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    ans.add(new TreeNode(i, l, r));
                }
            }
        }
        hm2.put(key, ans);
        return ans;
    }

    static HashMap<Integer, List<TreeNode>> hm;

    public static List<TreeNode> util1(int n) {
        hm = new HashMap<>();
        List<TreeNode> l = new ArrayList<>();
        l.add(new TreeNode(1));
        hm.put(1, l);
        return helper(n);
    }

    // i am here working on the number of nodes, not on n being the value in the
    // tree
    public static List<TreeNode> helper(int n) {
        if (n == 0) {
            return null;
        }
        if (hm.containsKey(n)) {
            return hm.get(n);
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            List<TreeNode> left = helper(i);
            List<TreeNode> right = helper(n - i - 1);
            int nodeValue = i + 1;
            if (left == null) {
                for (TreeNode r : right) {
                    ans.add(new TreeNode(nodeValue, null, r));
                }
            } else if (right == null) {
                for (TreeNode l : left) {
                    ans.add(new TreeNode(nodeValue, l, null));
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        ans.add(new TreeNode(nodeValue, l, r));
                    }
                }
            }
        }
        hm.put(n, ans);
        return ans;
    }

}
