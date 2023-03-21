package trees;

public class NodesInCBT {
    public static void main(String args[]){

    }
    //brute force O(n) very easy code..
    //need to take advantage of cbt
    public static int countNodes(TreeNode root){
        return util1(root);
    }
    
    public static int util1(TreeNode root){
        if(root == null){return 0;}
        int leftHeight = calculateLeftHeight(root.left);
        int rightHeight = calculateRightHeight(root.right);
        if(leftHeight == rightHeight){
            int height = leftHeight+1;
            int ans =(int) Math.pow(2, height)-1;
            return ans;
        }else{
            int leftAns = util1(root.left);
            int rightAns = util1(root.right);
            return leftAns+rightAns+1;
        }
    }
    //we will need to make to seprate methods to calculate height of left and right subtree
    private static int calculateLeftHeight(TreeNode root){
        if(root == null){return 0;}
        return calculateLeftHeight(root.left)+1;
    }
    private static int calculateRightHeight(TreeNode root){
        if(root == null){return 0;}
        return calculateRightHeight(root.right)+1;
    }

}
