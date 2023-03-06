package trees;

public class SortedArrayBst {
    public static void main(String [] args){
        int arr[] = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(arr);
        print(root);
    }
    public static void print(TreeNode root){
        if(root == null){return;}
        print(root.left);
        print(root.right);
        System.out.print(root.val+" ");
    }
    public static TreeNode sortedArrayToBST(int [] nums){
        TreeNode ans = helper1(nums,0,nums.length-1);
        return ans;
    }
    public static TreeNode helper1(int arr[],int i, int j){
        if(i>j){
            return null;
        }
        int mid = i + (j-i)/2;
        TreeNode newNode = new TreeNode();
        newNode.val=arr[mid];
        TreeNode leftNode = helper1(arr,i,mid-1);
        TreeNode rightNode  = helper1(arr,mid+1,j);
        newNode.left = leftNode;
        newNode.right = rightNode;
        return newNode;
    }
    
}
