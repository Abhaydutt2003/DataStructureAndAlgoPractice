package trees;

import java.util.*;
public class PathSum {
    public static void main(String args[]){
        TreeNode root = getInput();
        System.out.println(util1(root,22,0));
    }

    public static boolean util1(TreeNode root, int toGet, int currentSum){
        if(root == null){
            return false;
        }
        currentSum+=root.val;
        if(currentSum == toGet && (root.left == null && root.right == null)){
            return true;
        }
        boolean ans1 = util1(root.left,toGet,currentSum);
        boolean ans2 = util1(root.right, toGet, currentSum);
        return ans1||ans2 ;
    }

    public static TreeNode getInput() { 
		Scanner s = new Scanner(System.in);
		Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
		System.out.println("Enter the value of the root");
		int rootVal = s.nextInt(); 
		TreeNode root = new TreeNode(rootVal);
		pendingNodes.add(root);
		while(pendingNodes.isEmpty()!=true) {
			TreeNode temp = pendingNodes.poll();
			System.out.println("Enter the left child of " + temp.val);
			int leftData = s.nextInt();
			if(leftData != -1) {
				TreeNode leftChild = new TreeNode(leftData);
				temp.left = leftChild;
				pendingNodes.add(leftChild);
			}
			System.out.println("Enter the right child of " + temp.val);
			int rightData = s.nextInt();
			if(rightData!=-1) {
				TreeNode rightChild = new TreeNode(rightData);
				temp.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;
	}
    
}
