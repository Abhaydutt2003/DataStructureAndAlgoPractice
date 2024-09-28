package trees;

import java.util.Scanner;
import java.util.*;
class maxPathSumHelper{
    int pathSumTillNow;
    int maxPathSumm;
    maxPathSumHelper(int x, int y){this.pathSumTillNow = x;this.maxPathSumm = y;}
}
public class MaximumPathSum {
    public static void main(String args[]){
		TreeNode root =getInput();
		System.out.print(maxPathSum(root));
    }
    public static TreeNode getInput(){
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
    public static int maxPathSum(TreeNode root){
        maxPathSumHelper ans = helperMethod2(root);
		return ans.maxPathSumm;
		// helperMethod1(root);
		// return res;
    }
	//aditya verma way...
	static int res = Integer.MIN_VALUE;
	public static int helperMethod1(TreeNode root){
		if(root == null){return 0;}
		int left = helperMethod1(root.left);
		int right = helperMethod1(root.right);
		int candidate1 = Math.max(left, right)+root.val;
		int candidate2 = left+right+root.val;
		int candidate3 = root.val;
		int ans = Math.max(candidate2,Math.max(candidate1, candidate3));
		res = (res<ans)?ans:res;
		return Math.max(candidate1,candidate3);
	}
	//coding ninjas way...
	public static maxPathSumHelper helperMethod2(TreeNode root){
		if(root == null){return new maxPathSumHelper(0,0);}
		maxPathSumHelper left = helperMethod2(root.left);
		maxPathSumHelper right = helperMethod2(root.right);
		int candidate1 = root.val;
		int candidate2 = Math.max(left.pathSumTillNow,right.pathSumTillNow)+root.val;
		int candidate3 = left.pathSumTillNow+right.pathSumTillNow+root.val;
		int candidate = Math.max(candidate2,Math.max(candidate1, candidate3));
		int ans1 = Math.max(left.maxPathSumm,Math.max(right.maxPathSumm, candidate));
		int ans2 = Math.max(candidate1,candidate2);
		maxPathSumHelper ans = new maxPathSumHelper(ans2, ans1);
		return ans;
	}
	
}
