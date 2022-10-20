package trees;

public class LCAOfNormalBinaryTree {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b= new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(0);
		TreeNode g = new TreeNode(8);
		TreeNode h = new TreeNode(7);
		TreeNode i = new TreeNode(4);
		a.left = b;a.right = c;b.left = d;b.right = e;c.left = f;c.right=g;e.left=h;e.right= i;
		System.out.print(lowestCommonAncestor(a,b,c).val);
		

	}
	//failed , but i tried.
	static boolean pPresent = false,qPresent = false;
	public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p, TreeNode q) {
		if(root == null) {return null;}
		TreeNode ans1 = lowestCommonAncestor(root.left,p,q);
		TreeNode ans2 = lowestCommonAncestor(root.right,p,q);
		if(ans1!=null) {return ans1;}else if(ans2!=null) {return ans2;}
		if(root.val == p.val) {pPresent = true;}else if(root.val == q.val) {qPresent = true;}
		if(pPresent == true && qPresent == true) {return root;}
		return null;
	}
	//here is the correct code
	public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {
		if(root == null||root.val == p.val || root.val == q.val) {return root;}
		TreeNode ans1 = lowestCommonAncestor(root.left,p,q);
		TreeNode ans2 = lowestCommonAncestor(root.right,p,q);
		if(ans1 == null && ans2 == null) {return null;}
		if(ans1 != null && ans2 != null) {return root;}
		return ans1 == null ? ans2 : ans1;
	}
	

}
