package linkedList;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedList2 {
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
	public static void main(String args[]) {
		ListNode head = takeInput();
		head = deleteDuplicates(head);
		print(head);
		
	}
	//failed approach.
	public static ListNode deleteDuplicates(ListNode head,ListNode prev) {
		if(head == null|| head.next == null) {
			return head;
		}
		ListNode temp = head;
		boolean a = false;
		while(temp.next!=null && temp.next.val == temp.val) {
			temp = temp.next;
			a = true;
		}
		if(prev!=null) {
			prev.next = temp;
			temp.next = deleteDuplicates(temp.next,temp);
			return temp;
		}else {
			temp.next = deleteDuplicates(temp.next,temp);
			return temp;
		}
	}
	
	
	public static ListNode deleteDuplicates1(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode toReturn  = head;
		ListNode prev = null;
		ListNode current  =head;
		ListNode next = null;
		while(current != null && current.next!=null) {
			if(current.val == current.next.val) {
				if(current == toReturn) {
					int a = toReturn.val;
					while(toReturn !=null && toReturn.val==a) {
						toReturn  =toReturn.next;
					}
					current = toReturn;
					continue;
				}
				int a = current.val;
				next = current;
				while(next!= null && next.val==a) {
					next = next.next;
				}
				prev.next = next;
				current = next;
			}else {
				prev = current;
				current = current.next;
				continue;
			}
		}
		return toReturn;
	}
	//using the dummy node concept..
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1,head);
		ListNode prev = dummy;
		ListNode current = head;
		ListNode next = null;
		while(current!=null && current.next!=null) {
			if(current.val == current.next.val) {
				int a = current.val;
				next = current;
				while(next!=null && next.val == a) {
					next = next.next;
				}
				prev.next = next;
				current = next;
			}else {
				prev = current;
				current = current.next;
			}
		}
		return dummy.next;
	}
	//recursive...
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		if(head.val!= head.next.val) {
			head.next = deleteDuplicates(head.next);
			return head;
		}else {
			int temp = head.val;
			while(head!=null && head.val == temp)
				head =head.next;
			return deleteDuplicates(head);
		}
	}
	

}
