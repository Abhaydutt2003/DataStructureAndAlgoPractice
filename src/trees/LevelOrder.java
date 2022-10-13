package trees;
import java.util.Scanner;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
public class LevelOrder {
	public  static List<List<Integer>> levelOrder(TreeNode root){
		Queue <TreeNode> pending = new LinkedList<TreeNode>();
		List <List<Integer>> ans = new LinkedList<List<Integer>>();
		List<Integer> small = new LinkedList<Integer>();
		pending.add(root);pending.add(null);
		while(pending.isEmpty()!=true) {
			TreeNode current = pending.poll();
			if(current == null) {
				ans.add(small);
				if(pending.isEmpty() == true) {break;}
				else {
					small = new LinkedList<Integer>();
					pending.add(null);
				}
			}else{
				small.add(current.val);
				if(current.left!=null) {pending.add(current.left);}
				if(current.right!=null) {pending.add(current.right);}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = getInput();
		List<List<Integer>> ans = levelOrder(root);
		

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
