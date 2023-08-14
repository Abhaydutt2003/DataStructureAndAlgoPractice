package trees;

import java.util.*;

class Codec {
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper1(ans, root);
        return ans.toString();
    }

    public static void helper1(StringBuilder ans, TreeNode root) {
        if (root == null) {
            ans.append("N:");
            return;
        }
        ans.append(root.val);
        ans.append(':');
        helper1(ans, root.left);
        helper1(ans, root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(":")));
        return helper2(q);
    }

    public static TreeNode helper2(Queue<String> q) {
        String res = q.remove();
        if (res.equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(res));
        root.left = helper2(q);
        root.right = helper2(q);
        return root;
    }

}

// class Codec {

// //need to handle number of digits

// // Encodes a tree to a single string.
// public String serialize(TreeNode root) {
// if (root == null) {
// String ans = "N";
// return ans;
// }
// StringBuilder ans = new StringBuilder();
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);
// ans.append(root.val);
// while (q.isEmpty() == false) {
// TreeNode current = q.poll();
// if (current.left != null) {
// q.add(current.left);
// ans.append(current.left.val);
// } else {
// ans.append('N');
// }
// if (current.right != null) {
// q.add(current.right);
// ans.append(current.right.val);
// } else {
// ans.append('N');
// }
// }
// return ans.toString();
// }

// // Decodes your encoded data to tree.
// public TreeNode deserialize(String data) {
// return helper2(data, 0);
// }

// public static TreeNode helper2(String data, int index) {
// if (index >= data.length()) {
// return null;
// } else if (data.charAt(index) == 'N') {
// return null;
// }
// TreeNode root = new TreeNode(data.charAt(index) - 48);
// root.left = helper2(data, (2 * index + 1));
// root.right = helper2(data, (2 * index + 2));
// return root;
// }
// }

public class SeralizeAndDesBst {

}
