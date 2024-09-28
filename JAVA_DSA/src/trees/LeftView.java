package trees;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class LeftView {
	//works..level order traversal..
	public static ArrayList<Integer> leftView(Node root){
		if(root == null) {return new ArrayList<Integer>();}
		Queue<Node> pending  = new LinkedList<Node>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		pending.add(root);pending.add(null);ans.add(root.data);
		boolean toAdd = false;
		while(pending.isEmpty()!=true) {
			Node current = pending.poll();
			if(current == null) {
				if(pending.isEmpty() == true) {break;}
				pending.add(null);
				toAdd = true;
			}else {
				if(current.left != null) {pending.add(current.left);}
				if(current.right!=null) {pending.add(current.right);}
				if(toAdd) {ans.add(current.data);toAdd = false;}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		

	}

}
