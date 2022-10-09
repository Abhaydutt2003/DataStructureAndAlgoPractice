package linkedList;
import java.util.HashSet;
import java.util.Scanner;
public class RemoveDuplicatesFromUnsorted {
	public static ListNode takeInput() {
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		ListNode head = null;
		ListNode tail = null;
		while(val!=-1) {
			ListNode temp = new ListNode(val);
			if(head == null) {
				head = temp;
				tail = temp;
			}else {
				tail.next = temp;
				tail = tail.next;
			}
			val = s.nextInt();
		}
		return head;
	}
	public static void print(ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		ListNode head = takeInput();
		head = remove(head);
		print(head);

	}
	
	public static ListNode remove(ListNode head) {
		ListNode dummy  = new ListNode();
		dummy.val = -1;
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;
		ListNode next = null;
		HashSet<Integer> nodes = new HashSet<Integer>();
		while(current != null ) {
			if(nodes.contains(current.val)) {
				next = current.next;
				prev.next = next;
				current = next;
			}else {
				nodes.add(current.val);
				prev = current;
				current = current.next;
			}
		}
		return dummy.next;
	}

}
