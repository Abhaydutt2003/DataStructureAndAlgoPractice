package linkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class LinkedListCycle {
	
	public static boolean hasCycle(ListNode head) {
		HashSet<ListNode> nextNodes = new HashSet<ListNode>();
		ListNode temp = head;
		while(temp!=null) {
			if(nextNodes.contains(temp)) {
				return true;
			}else {
				nextNodes.add(temp);
				temp = temp.next;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(6);
		ListNode e = new ListNode(7);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;
		System.out.print(hasCycle(a));

	}

}
