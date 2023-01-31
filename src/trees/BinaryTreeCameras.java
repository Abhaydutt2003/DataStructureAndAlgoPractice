package trees;
import java.util.*;
public class BinaryTreeCameras {
    public static void main(String args[]){
		TreeNode root = getInput();
		System.out.print(minCameraCover(root));
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
    public static int minCameraCover(TreeNode root){
        int a = helper(root);
		if(a == 1){cameras++;}
        return cameras;
    }
    static int cameras = 0;
    //you will get 1 when the children nodes are not monitored..
    //you will get 2 when children are monitored and they do not have a camera..
    //you will get 3 when the children node has a camera
    public static int helper(TreeNode root){
        if(root == null){return 2;}
        int left = helper(root.left);
        int right = helper(root.right);
		if(left == 1 || right == 1){
			cameras++;return 3;
		}else if((left == 3 && right == 2) ||(left == 2 && right == 3) || (left == 3 && right ==3)){
			return 2;
		}else{
			return 1;
		}
    }
}
