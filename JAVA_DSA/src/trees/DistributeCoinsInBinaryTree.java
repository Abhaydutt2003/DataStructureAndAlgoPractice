package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DistributeCoinsInBinaryTree {
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
		s.close();
		return root;
	}
	

	public static void main(String[] args) {
		TreeNode root = getInput();
		System.out.print(distributeCoins(root));

	}
	static int moves = 0;
	public static int distributeCoins(TreeNode root) {
		getAnswer2(root);
		return moves;
	}
	public static int[] getAnswer(TreeNode root) {
		if(root == null) {return new int[] {0,0};}
		int[] left = getAnswer(root.left);
		int [] right = getAnswer(root.right);
		moves = moves + Math.abs(left[0]-left[1])+Math.abs(right[0]-right[1]);
		int toReturn[] = {left[0]+right[0]+1,left[1]+right[1]+root.val};
		return toReturn;
	}
	
	public static int getAnswer2(TreeNode root){
		if(root == null){return 0;}
		int left = getAnswer2(root.left);
		int right = getAnswer2(root.right);
		moves += Math.abs(left)+Math.abs(right);
		int toReturn = left+right+(root.val-1);
		return toReturn;
	}

}
