package trees;
import java.util.Queue;
import java.util.LinkedList;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class populatingNextRightPointer {
	//typical level order traversal problem...
	public static Node connect(Node root) {
		if(root == null||root.left == null) {return root;}
		Queue<Node> pending = new LinkedList<Node>();
		Node prev = root;
		pending.add(root);pending.add(null);
		while(pending.isEmpty()!=true) {
			Node current = pending.poll();
			if(current == null) {
				if(pending.isEmpty()==true) {
					break;
				}
				pending.add(null);
				prev.next = current;
				prev = current;
			}else {
				if(current.left!=null) {
					pending.add(current.left);
				}
				if(current.right!=null) {
					pending.add(current.right);
				}
				if(prev == null) {prev = current;}
				else {prev.next = current;prev = current;}
			}
		}
		return root;
	}
	//recursive code..
	public static Node connectR(Node root) {
		if(root == null) {return null;}
		Node left = root.left;Node right = root.right;
		while(left!=null) {
			left.next = right;
			left = left.right;right = right.left;
		}
		connect(root.left);connect(root.right);return root;
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		a.left = b;a.right = c;
		b.left = d;b.right = e;
		c.left = f;c.right = g;
		connect(a);

	}
	

}
