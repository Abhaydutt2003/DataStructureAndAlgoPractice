package trees;

public class ConstructFromInorderPostorder {
    public static void main(String args[]){
        //works..
    }
    public static TreeNode buildTree(int[] inorder, int []postOrder){
        TreeNode ans =  helper1(inorder, postOrder,0,postOrder.length-1,0,inorder.length-1);
        return ans;
    }
    public static TreeNode helper1(int []inorder,int[]postOrder,int postStart, int postEnd,int inStart, int inEnd){
        if(postStart>postEnd){return null;}
        TreeNode root = new TreeNode();
        root.val = postOrder[postEnd];
        //firstly i will declare all the variables
        int leftPostStart,leftPostEnd;
        int leftInStart,leftInEnd;
        int rightPostStart,rightPostEnd;
        int rightInStart,rightInEnd;
        //now putting the values to the variables we already know the answer for
        leftPostStart = postStart;
        rightPostEnd = postEnd-1;
        leftInStart = inStart;
        rightInEnd = inEnd;
        //now we will get the position of the root in the inorder array
        int rootPositionInInorder = -1;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == root.val){
                rootPositionInInorder = i;
                break;
            }
        }
        leftInEnd = rootPositionInInorder-1;
        rightInStart = rootPositionInInorder+1;
        //calculating the length of the leftSubtree
        int leftSubTreeLength = leftInEnd-leftInStart+1;
        leftPostEnd = leftPostStart+leftSubTreeLength-1;
        rightPostStart = leftPostEnd+1;
        root.left = helper1(inorder,postOrder,leftPostStart,leftPostEnd,leftInStart,leftInEnd);
        root.right = helper1(inorder,postOrder,rightPostStart,rightPostEnd,rightInStart,rightInEnd);
        return root;
    } 
    
}
