package trees;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class DiagonalTraversal {
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
		ArrayList<Integer> ans = util(root);
		for(int i: ans) {System.out.print(i+" ");}

	}
	static HashMap<Integer,ArrayList<TreeNode>> map = new HashMap<>();
	public static void helper(TreeNode root,int d){
		if(root == null) {return;}
		ArrayList<TreeNode> nodes = map.get(d);
		if(nodes == null) {nodes = new ArrayList<TreeNode>();}
		nodes.add(root);map.put(d, nodes);
		helper(root.left,d+1);helper(root.right,d);
	}
	public static ArrayList<Integer> util(TreeNode root) {
		helper(root,0);
		int i = 0;ArrayList<Integer> ans = new ArrayList<Integer>();
		while(true) {
			ArrayList<TreeNode> smallAns = map.get(i);
			if(smallAns == null) {break;}
			for(TreeNode a : smallAns) {
				ans.add(a.val);
			}
			i++;
		}
		return ans;
	}
	

}
