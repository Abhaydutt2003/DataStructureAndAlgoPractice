package trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BoundryTraversal {
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
		ArrayList<Integer> ans = boundry(root);
		for(int i:ans) {System.out.print(i+" ");}

	}
	static ArrayList<Integer> boundry = new ArrayList<Integer>();
	public static ArrayList<Integer> boundry(TreeNode root) {
		boundry.add(root.val);
		leftTraversal(root.left);leafTraversal(root.left);leafTraversal(root.right);rightTraversal(root.right);
		return boundry;
	}
	private static void leafTraversal(TreeNode root) {
		if(root == null) {return;}
		leafTraversal(root.left);
		if(root.left == null && root.right == null) {boundry.add(root.val);}
		leafTraversal(root.right);
	}
	private static void leftTraversal(TreeNode root) {
		if(root == null) {return;}
		if(root.left!=null) {
			boundry.add(root.val);leftTraversal(root.left);
		}else if(root.right!=null) {
			boundry.add(root.val);leftTraversal(root.right);
		}
	}
	private static void rightTraversal(TreeNode root) {
		if(root == null) {return;}
		if(root.right!=null) {
			rightTraversal(root.right);boundry.add(root.val);
		}else if(root.left!=null) {
			rightTraversal(root.left);boundry.add(root.val);
		}
	}
	


}
