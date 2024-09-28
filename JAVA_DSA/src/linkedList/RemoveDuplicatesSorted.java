package linkedList;

import java.util.Scanner;

public class RemoveDuplicatesSorted {
	public static  ListNode deleteDuplicatesIterative(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		while(temp.next!=null) {
			if(temp.val<temp.next.val) {
				temp = temp.next;
			}else {
				ListNode toRemove = temp.next;
				temp.next = toRemove.next;
			}
		}
		return head;
	}
	//recursive code
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		while(head.next!=null && head.val == head.next.val)
			head = head.next;
		
		head.next = deleteDuplicates(head.next);
		return head;
	}

	public static void main(String[] args) {
		ListNode head = takeInput();
		head  = deleteDuplicates(head);
		print(head);

	}
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
		s.close();
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

}
