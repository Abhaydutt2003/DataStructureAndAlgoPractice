package trees;

import java.util.*;
public class ValidateBst {
    public static void main(String args[]){
        TreeNode root = getInput();
        System.out.println(isValidBST(root));
    }
    //reverse inorder
    public static boolean isValidBST(TreeNode root){
        return helper1(root);
    }
    static TreeNode prev = null;
    public static boolean helper1(TreeNode root){
        if(root == null){
            return true;
        }
        boolean ans1 = helper1(root.right);
        if(ans1 == false || ((prev != null) && (prev.val<root.val)) ){
            return false;
        }
        prev = root;
        boolean ans2 = helper1(root.left);
        return ans2;
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
