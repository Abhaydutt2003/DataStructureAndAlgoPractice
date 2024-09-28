package trees;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import java.util.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
public class TraversalsIterative {
	static List<Integer> ans = new ArrayList<Integer>();
	public static void inorder(TreeNode root){
		if(root == null) {return;}
		inorder(root.left);ans.add(root.val);inorder(root.right);
	}
	
	public static List<Integer> inorderIterative(TreeNode root){
		if(root == null) {return new ArrayList<Integer>();}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode current = root;
		List<Integer> ans = new ArrayList<Integer>();
		while(current!= null || nodes.size()!=0 ) {
			while(current !=null) {
				nodes.push(current);current = current.left;
			}
			current = nodes.pop();
			ans.add(current.val);
			current = current.right;
		}
		return ans;
	}
	public static List<Integer> preOrderIterative(TreeNode root){
		if(root == null){return new ArrayList<Integer>();}
		Stack<TreeNode> rightNodes = new Stack<TreeNode>();
		Queue<TreeNode> toPrint = new LinkedList<TreeNode>();
		TreeNode current = root;
		while(true) {
			if(current.left == null && current.right == null && rightNodes.size() == 0) {break;}
			if(current.right!=null) {
				rightNodes.push(current.right);
			}
			if(current.left!=null) {
				toPrint.add(current.left);current = current.left;continue;
			}else {
				current = rightNodes.pop();
				toPrint.add(current);
			}
		}
		List<Integer> ans = new ArrayList<Integer>();
		ans.add(root.val);
		while(toPrint.isEmpty()!=true) {
			ans.add(toPrint.poll().val);
		}
		return ans;
	}
	public static List<Integer> postOrderIterative(TreeNode root){
		LinkedList<Integer> result = new LinkedList<Integer>();
		if(root == null) {return result;}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode current = root;nodes.push(current);
		while(true) {
			if(nodes.isEmpty() == true) {break;}
			if(current!=null) {
				nodes.push(current);result.addFirst(current.val);current = current.left;
			}else {
				TreeNode node = nodes.pop();
				current = node.right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = getInput();
		List<Integer> ans = postOrderIterative(root);
		for(int i:ans) {System.out.print(i+" ");}

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
		s.close();
		return root;
	}
	

}
