package trees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class helper2{
    int height;
    int diameter;
    helper2(int x , int y){
        this.height = x;
        this.diameter = y;
    }
}
public class DiameterOfBinaryTree {
    public static void main(String args[]){
        TreeNode root = getInput();
        System.out.print(diameter(root));
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
    public static int diameter(TreeNode root){
       //helper2 ans = diameterHelper(root);
       //since we are required to print the number of edges we will return the no of nodes in diameter-1
       //return ans.diameter-1;
       helper1(root);
       return res-1;
    }
    public static helper2 diameterHelper(TreeNode root){
        if(root == null){
            helper2 ans  = new helper2(0,0);return ans;
        }
        helper2 left = diameterHelper(root.left);
        helper2 right = diameterHelper(root.right);
        int heightToReturn =Math.max(left.height,right.height)+1;
        int candidate1 = left.height+right.height+1;
        int candidate2 = Math.max(left.diameter,right.diameter);
        int diameterToReturn = Math.max(candidate1, candidate2);
        return new helper2(heightToReturn,diameterToReturn);
    }
    //aditya verma way...
    static int res = Integer.MIN_VALUE;
    public static int helper1(TreeNode root){
        if(root == null){return 0;}
        int left = helper1(root.left);
        int right = helper1(root.right);
        int candidate = left+right+1;
        res = (res>candidate)?res:candidate;
        int heightToReturn = Math.max(left,right)+1;
        return heightToReturn;
    }
    
}
