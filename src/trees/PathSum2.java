package trees;

import java.util.*;
public class PathSum2 {

    public static void main(String args[]){
        TreeNode root = getInput();
        List<Integer> l = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();
        util1(root,22,l,0);
        for(List<Integer> li : ans){
            for(int i:li){
                System.out.print(i+" ");
            }System.out.println();
        }
    }

    static List<List<Integer>> ans;
    public static void util1(TreeNode root, int target,List<Integer> nodesTillNow,int sumTillNow){
        if(root == null ){
            return;
        }
        List<Integer> newList= new ArrayList<Integer>(nodesTillNow);
        newList.add(root.val);
        sumTillNow+=root.val;
        if(sumTillNow == target && (root.left == null && root.right == null)){
            ans.add(newList);
            return;
        }
        util1(root.left,target,newList,sumTillNow);
        util1(root.right,target,newList,sumTillNow);
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
