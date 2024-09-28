package trees;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
public class RightSideView {

	public static void main(String[] args) {
		TreeNode root = getInput();
		List<Integer> ans = rightSideView(root);
		for(int i:ans) {System.out.print(i+" ");}

	}
	//failed..
	public static List<Integer> right(TreeNode root){
		if(root == null) {return new LinkedList<Integer>();}
		List <Integer> rightNode = new LinkedList<Integer>();
		Queue <TreeNode> pending = new LinkedList<TreeNode>();
		pending.add(root);
		while(pending.isEmpty()!=true) {
			TreeNode current = pending.poll();
			rightNode.add(current.val);
			if(current.right!=null) {pending.add(current.right);}
			
		}
		return rightNode;
	}
	//a typical reverse level order traversal problem....
	public static List<Integer> right2(TreeNode root){
		if(root == null) {return new LinkedList<Integer>();}
		List<Integer> rightNodes = new LinkedList<Integer>();
		Queue<TreeNode> pending = new LinkedList<TreeNode>();
		pending.add(root);pending.add(null);rightNodes.add(root.val);
		boolean toAdd = false;
		while(pending.isEmpty()!=true) {
			TreeNode current = pending.poll();
			if(current == null) {
				if(pending.isEmpty()== true) {break;}
				pending.add(null);
				toAdd = true;
			}else {
				if(current.right!=null) {pending.add(current.right);}
				if(current.left!=null) {pending.add(current.left);}
				if(toAdd) {rightNodes.add(current.val);toAdd = false;}
			}
		}
		return rightNodes;
	}
	static List<Integer> rights = new ArrayList<Integer>();
	public static List<Integer> rightSideView(TreeNode root){
		helper(root,0); return rights;
	}
	public static void helper(TreeNode root, int depth ) { 
		if(root == null) {return;}
		if(depth == rights.size()) {rights.add(root.val);}
		helper(root.right,depth+1);helper(root.left,depth+1);
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
