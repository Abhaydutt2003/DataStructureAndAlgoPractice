package trees;

public class ConstructFromInorderPreorder {
    public static void main(String args[]){
        int arr1[] = {3,9,20,15,7};
        int arr2[] = {9,3,15,20,7};
        TreeNode root = buildTree(arr1,arr2);
        print(root);
    }
    public static void print(TreeNode root){
        if(root == null){return;}
        System.out.print(root.val+" ");
        if(root.left!=null){
            System.out.print(root.left.val+" ");
        }
        if(root.right!=null){
            System.out.print(root.right.val+" ");
        }
        System.out.println(" ");
        print(root.left);
        print(root.right);
    }
    //startleftinorder
    //endleftinorder
    //startrightinorder
    //endrightinorder
    //startleftpreorder
    //endleftpreorder
    //startrightpreorder
    //endrightpreorder
    public static TreeNode buildTree(int[]preOrder,int[]inorder){
        return helper1(preOrder,inorder,0,preOrder.length-1,0,inorder.length-1);
    }
    public static TreeNode helper1(int[] pre, int[] in, int preStart,int preEnd, int inStart, int inEnd){
        if(preStart>preEnd){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = pre[preStart];
        //let us firstly declare the variables to work on..
        int leftPreStart,leftPreEnd;
        int leftInStart,leftInEnd;
        int rightPreStart,rightPreEnd;
        int rightInStart,rightInEnd;
        //now we will start putting the values accordingly
        leftPreStart = preStart+1;
        rightPreEnd = preEnd;
        leftInStart = inStart;
        rightInEnd = inEnd;
        int rootPosistionInInorder = -1;
        //starting a loop to find the position of the root in inorder
        for(int i = 0;i<in.length;i++){
            if(in[i] == root.val){
                rootPosistionInInorder = i;
                break;
            }
        }
        leftInEnd = rootPosistionInInorder-1;
        rightInStart = rootPosistionInInorder+1;
        int leftSubtreeLength = leftInEnd-leftInStart+1;
        leftPreEnd = preStart+leftSubtreeLength;
        rightPreStart = leftPreEnd+1;
        //now we will do the recrsive calls...
        root.left = helper1(pre,in,leftPreStart,leftPreEnd,leftInStart,leftInEnd);
        root.right = helper1(pre,in,rightPreStart,rightPreEnd,rightInStart,rightInEnd);
        return root;
    }
}
