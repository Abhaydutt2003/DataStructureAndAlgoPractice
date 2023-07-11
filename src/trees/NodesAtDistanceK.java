package trees;

import java.util.*;

class customTree {
    int val;
    ArrayList<customTree> adjNodes;

    customTree(int val) {
        this.val = val;
        adjNodes = new ArrayList<>();
    }
}

class customPair {
    customTree node;
    int distance;

    customPair(customTree node, int distance) {
        this.distance = distance;
        this.node = node;
    }
}

public class NodesAtDistanceK {

    public static void main(String args[]) {

    }

    // adj list approach will have really bad space complexity...
    // rather make a different data structure

    public static List<Integer> util1(TreeNode target, TreeNode root, int k) {
        constGraph(root, target.val, null);
        ans = new ArrayList<>();
        bfs(source, k);
        return ans;
    }

    static customTree source;
    static List<Integer> ans;

    public static void bfs(customTree source, int k) {
        HashSet<customTree> visited = new HashSet<>();
        visited.add(source);
        Queue<customPair> q = new LinkedList<>();
        q.add(new customPair(source, 0));
        while (q.isEmpty() == false) {
            customPair current = q.poll();
            customTree currentNode = current.node;
            int distance = current.distance;
            visited.add(currentNode);
            if (distance == k) {
                ans.add(currentNode.val);
                continue;
            } else {
                ArrayList<customTree> currentList = currentNode.adjNodes;
                for (customTree a : currentList) {
                    if (visited.contains(a) == false) {
                        q.add(new customPair(a, distance + 1));
                    }
                }
            }
        }
    }

    public static customTree constGraph(TreeNode root, int target, customTree parent) {
        if (root == null) {
            return null;
        }
        customTree customRoot = new customTree(root.val);
        if (root.val == target) {
            source = customRoot;
        }
        if (parent != null) {
            customRoot.adjNodes.add(parent);
        }
        customTree left = constGraph(root.left, target, customRoot);
        customTree right = constGraph(root.right, target, customRoot);
        if (left != null) {
            customRoot.adjNodes.add(left);
        }
        if (right != null) {
            customRoot.adjNodes.add(right);
        }
        return customRoot;
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

}
