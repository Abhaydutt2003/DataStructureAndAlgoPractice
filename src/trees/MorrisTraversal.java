package trees;

import java.util.*;
public class MorrisTraversal {
    public static void main(String agrs[]){
        TreeNode root = getInput();
        traversal(root);
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
    public static void traversal(TreeNode root){
        if(root == null){return;}
        TreeNode current = root;
        TreeNode previous;
        while(current!=null){
            if(current.left == null){
                System.out.print(current.val+ " ");
                current = current.right;
            }else{
                previous = current.left;
                while(previous.right!=null && previous.right !=current){
                    previous = previous.right;
                }
                if(previous.right == null){
                    previous.right = current;
                    current = current.left;
                }else{
                    System.out.print(current.val+" ");
                    previous.right = null;
                    current = current.right;
                }
            }
        }
    }
    
}
