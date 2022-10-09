package linkedList;

import java.util.Scanner;

public class LastElementToFirst {
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
		head = move(head);
		print(head);

	}
	 public static ListNode move (ListNode head) {
		 if(head == null || head.next == null) {
			 return head;
		 }
		 ListNode dummy = new ListNode();dummy.next = head;dummy.val = -1;
		 ListNode temp = head,prev = dummy;
		 while(true) {
			 prev = temp;
			 temp = temp.next;
			 if(temp.next == null) {
				 prev.next = null;
				 break;
			 }
		 }
		 ListNode temp2 = dummy.next;
		 dummy.next = temp;
		 temp.next = temp2;
		 return temp;
	 }

}
