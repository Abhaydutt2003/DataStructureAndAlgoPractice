package trees;

import java.util.*;

public class populatingNextRightPointer2 {

    public static void main(String args[]) {
        Node a1 = new Node(1);
        Node a2 = new Node(-9);
        Node a3 = new Node(8);
        Node a4 = new Node(4);
        Node a5 = new Node(-3);
        Node a6 = new Node(-3);
        Node a7 = new Node(-6);
        Node a8 = new Node(-6);
        Node a9 = new Node(-4);
        Node a10 = new Node(-9);
        Node a11 = new Node(6);
        a1.left = a2;
        a2.right = a3;
        a3.left = a4;
        a3.right = a5;
        a5.left = a6;
        a6.right = a7;
        a7.right = a8;
        a8.left = a9;
        a8.right = a10;
        a10.left = a11;
        bfs(a1);
        System.out.println(a4.next.val);
    }

    public static Node bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node prev = root;
        while (q.isEmpty() == false) {
            Node current = q.poll();
            if (current == null) {
                if (q.isEmpty() == true) {
                    break;
                }
                prev.next = null;
                prev = null;
                q.add(null);
            } else {
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                if (prev == null) {
                    System.out.println("Null" + " " + current.val);
                    prev = current;
                } else {
                    System.out.println(prev.val + " " + current.val);
                    prev.next = current;
                    prev = current;
                }
            }
        }
        return root;
    }

    // do not know why the above solution does not work on leetcode, but works here

    // other solution which works
    public static Node bfs2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() == false) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return root;
    }

}
