package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ColoringGame {
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
		int n = 11,x=3;
		TreeNode root = getInput();
		System.out.print(btreeGameWinningMove(root,n,x));
		

	}
	public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		TreeNode choice1 = goTo(root,x);
		int left = noOfNodes(choice1.left);int right = noOfNodes(choice1.right);
		int parent = n-left-right-1;
		return Math.max(left,Math.max(right, parent))>n/2;
		
	}
	private static TreeNode goTo(TreeNode root, int x) {
		if(root == null) {return null;}
		if(root.val == x) {return root;}
		TreeNode ans1 = goTo(root.left,x),ans2 = goTo(root.right,x);
		if(ans1!=null) {return ans1;}
		else {return ans2;}
	}
	private static int noOfNodes(TreeNode root) {
		if(root == null) {return 0;}
		int ans1 = noOfNodes(root.left),ans2 = noOfNodes(root.right);
		return ans1+ans2+1;
	}

}
