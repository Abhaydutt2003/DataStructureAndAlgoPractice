package trees;

import java.util.*;
public class RecoverBST {
    public static void main(String args[]){
        TreeNode root = getInput();
        revoverTree(root);
        System.out.print(first.val+" "+second.val);
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
    static TreeNode prev = null,first = null, second = null;
    public static void revoverTree(TreeNode root){
        helperMorris(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public static void helper(TreeNode root){
        if(root == null){return;}
        helper(root.left);
        if(prev!=null){
            if(prev.val>root.val){
                if(first == null){
                    first = prev;
                }else{
                    second = root;
                }
            }
        }
        prev = root;
        helper(root.right);
    }
    public static void helperMorris(TreeNode root){
        prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode parentNode = root;
        TreeNode current;
        while(parentNode != null){
            if(parentNode.left == null){
                if(parentNode.val < prev.val){
                    if(first == null){
                        first = prev;
                    }
                    second = parentNode;
                }
                prev = parentNode;
                parentNode = parentNode.right;
            }else{
                current = parentNode.left;
                while(current.right!= null && current.right != parentNode){
                    current = current.right;
                }
                if(current.right == null){
                    current.right =parentNode;
                    parentNode = parentNode.left;
                }else{
                    if(parentNode.val < prev.val){
                        if(first == null){
                            first = prev;
                        }
                        second = parentNode;
                    }
                    current.right = null;
                    prev = parentNode;
                    parentNode = parentNode.right;
                }
            }
        }
    }

    
}
