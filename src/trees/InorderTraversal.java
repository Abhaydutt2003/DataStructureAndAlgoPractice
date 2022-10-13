package trees;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (){}
	TreeNode (int val){this.val = val;}
	TreeNode (int val, TreeNode left, TreeNode right){
		this.val = val;this.left = left;this.right = right;
	}
}
public class InorderTraversal {
	public static List<Integer> levelOrderTraversal(TreeNode root){
		List<Integer> traverse  = new LinkedList<Integer>();
		Queue<TreeNode> pending = new LinkedList<TreeNode>();
		pending.add(root);
		while(pending.isEmpty()!=true) {
			TreeNode temp = pending.poll();
			traverse.add(temp.val);
			if(temp.left!=null) {pending.add(temp.left);}
			if(temp.right!=null) {pending.add(temp.right);}
		}
		return traverse;
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
	static List<Integer> inorder = new LinkedList<Integer>() ;
	public static List<Integer> inorderTraversal(TreeNode root){
		helper(root);return inorder;
	}
	public static void helper(TreeNode root) {
		if(root == null) {return;}
		helper(root.left);
		inorder.add(root.val);
		helper(root.right);
	}
	

	public static void main(String[] args) {
		TreeNode root = getInput();
		List<Integer> nodes = inorderTraversal(root);
		for(int i :nodes) {System.out.print(i+" ");}

	}

}
