package trees;

import java.util.*;
public class LongestZigZagPath {

    public static void main(String args[]){
        TreeNode root = getInput();
        System.out.println(longestZigZag(root));
    }
    //1 as right direction
    //0 as left direction
    public static int longestZigZag(TreeNode root) {
        util1(root,0,0);
        util1(root,1,0);
        return ans;
    }
    static int ans = Integer.MIN_VALUE;
    public static void util1(TreeNode root, int dir, int length){
        if(root == null){
            return ;
        }
        ans = Math.max(ans, length);
        if(dir == 1){
            util1(root.right,0,length+1);
            util1(root.left,1,1);
        }else{
            util1(root.left,1,length+1);
            util1(root.right,0,1);
        }
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
