package trees;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class ReverseLevelOrder {
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
//		ArrayList<Integer> ans = reverseLevelOrder(root);
//		for(int i: ans) {System.out.print(i+" ");}
		List<List<Integer>> ans = levelOrderBottom(root);
		for(List<Integer> a:ans) {
			for(int i:a) {System.out.print(i+" ");}
			System.out.println("");
		}

	}
	//GFG
	public static ArrayList<Integer> reverseLevelOrder(TreeNode root){
		if(root == null) {return new ArrayList<Integer>();}
		Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
		Stack <TreeNode> a = new Stack<TreeNode>();
		pendingNodes.add(root);
		while(pendingNodes.isEmpty()!=true) {
			TreeNode current = pendingNodes.poll();
			if(current.right!=null) {pendingNodes.add(current.right);}
			if(current.left!=null) {pendingNodes.add(current.left);}
			a.push(current);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(a.isEmpty()!=true) {
			ans.add(a.pop().val);
		}
		return ans;
	}
	//LEETCODE
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		if(root == null){return new LinkedList<List<Integer>> ();}
        Stack<List<Integer>> a= new Stack<>();
        Queue<TreeNode> pending = new LinkedList<TreeNode>();
        pending.add(root);pending.add(null);
        List<Integer> smallAns = new LinkedList<Integer>();
        while(pending.isEmpty()!=true) {
        	TreeNode current = pending.poll();
        	if(current == null) {
        		a.push(smallAns);
        		if(pending.isEmpty() == true) {break;}
        		smallAns = new LinkedList<Integer>();
        		pending.add(null);
        	}else {
        		smallAns.add(current.val);
        		if(current.left!=null) {pending.add(current.left);}
        		if(current.right!=null) {pending.add(current.right);}
        	}
        }
        List<List<Integer>> ans = new LinkedList<>();
        while(a.isEmpty()!=true) {ans.add(a.pop());}
        return ans;
	}
	

}
