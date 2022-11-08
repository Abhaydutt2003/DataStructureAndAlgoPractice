package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class helper {
	int total;int numNodes;
}
public class MaximumProductOfSplittedBinaryTree {
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

	public static void main(String[] args) {
		TreeNode root = getInput();
		int ans =maxProduct(root);
		System.out.print(ans+" ");
	}
	static long max = Integer.MIN_VALUE;
	public static int maxProduct(TreeNode root) {
		long allSum = findSum(root);
	    findAns(root,allSum);
//	    int mod =(int) 1e9+7;
	    int ans = (int)(max%(int)(Math.pow(10,9)+7));
	    return ans;
	}
	private static long findSum(TreeNode root) {
		if(root == null) {return 0;}
		long left = findSum(root.left);long right = findSum(root.right);
		return left+right+root.val;
	}
	private static long findAns(TreeNode root, long allSum) {
		if(root == null) {return 0;}
		long left = findAns(root.left,allSum);long right = findAns(root.right,allSum);
		long currentSum = left+right+root.val;
		max = Math.max(max,(currentSum * (allSum-currentSum)));
		return currentSum;
	}
	

}
