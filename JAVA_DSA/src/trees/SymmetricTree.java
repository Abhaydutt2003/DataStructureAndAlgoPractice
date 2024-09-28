package trees;

import java.util.*;

public class SymmetricTree {

    public static void main(String args[]){

    }
    //two solutions usinf level order and using normal postOrder traversal

    //using level order traversal..
    public boolean isSymmetric(TreeNode root){
        if(root == null){return false;}
        if(root.left!=null && root.right != null){
            return util1(root.left,root.right);
        }else if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }

    //very easy recursive code....

    public static boolean util1(TreeNode left ,TreeNode right){
        if(right == null && left == null){
            return true;
        }
        if(right == null || left == null){
            if(left !=null){
                return false;
            }else if(right !=null){
                return false;
            }
        }
        if(left.val != right.val){
            return false;
        }
        boolean call1 = util1(left.right,right.left);
        boolean call2 = util1(left.left,right.right);
        return (call1 && call2)?true:false;
    }
    //same concept , level order traversal
    public static boolean util2(TreeNode root){
        if(root == null){
            return false;
        }else if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root.left.val != root.right.val){
            return false;
        }
        q.add(root.left);
        q.add(root.right);
        while(q.isEmpty() == false){
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if(node1.right == null && node2.left == null){
                //do nothing
            }else if(node1.right == null || node2.left == null){
                return false;
            }else if(node1.right.val != node2.left.val){
                return false;
            }else{
                q.add(node1.right);
                q.add(node2.left);
            }

            if(node1.left == null && node2.right == null){
                //do nothing
            }else if(node1.left == null || node2.right == null){
                return false;
            }else if(node1.left.val != node2.right.val){
                return false;
            }else{
                q.add(node1.left);
                q.add(node2.right);
            }
        }
        return true;
    }
}
