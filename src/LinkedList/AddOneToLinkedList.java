package linkedList;

import java.util.Scanner;

public class AddOneToLinkedList {
	public static ListNode add1(ListNode head) {
		if(head == null) {
			return head;
		}
		head =reverse(head);
		int carry = 1;
		ListNode temp =head;
		while(temp!=null) {
			temp.val = temp.val+carry;
			if(temp.val>9) {
				carry = 1;
				temp.val = 0;
				temp = temp.next;
			}else {
				break;
			}
		}
		if(temp == null) {
			ListNode new1 = new ListNode();
			new1.val = 1;
			new1.next = head;
			return new1;
		}else {
			return reverse(head);
		}
	}
	private static ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {return head;};
		ListNode current = head,prev = null,next = null;
		while(current!=null) {
			next =current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	//thisd approach will fail in some test cases...
	public static ListNode addOne(ListNode head) {
		ListNode ln = null;
		if(head.next == null) {
			if(head.val>=9) {
				head.val = 0;
				head.next =new ListNode(0,null);
			}else {
				head.val = head.val+1;
				return head;
			}
		}
		ListNode temp = head;
		while(temp.next!=null) {
			if(temp.val!=9) {
				ln = temp;
			}
			temp = temp.next;
		}
		 if(temp.val == 9 && ln !=null ) {
			temp = ln;
			temp.val = temp.val+1;
			temp = temp.next;
			while(temp!=null) {
				temp.val = 0;
				temp = temp.next;
			}
		}else {
			temp.val =temp.val+1;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = takeInput();
		head = addOne(head);
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
