package linkedList;

import java.util.Scanner;

public class AddTwoNumbersLinkedList {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//l1 = reverse(l1);
		//l2 = reverse(l2);
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode newHead = null,newTail= null;
		int carry = 0;
		while(temp1!=null && temp2 != null) {
			if(newHead == null) {
				int value = temp1.val+temp2.val+carry;
				carry = value/10;
				value = value%10;
				newHead = new ListNode ();
				newTail = new ListNode ();
				newHead.val = value;
				newTail = newHead;
			}else {
				int value = temp1.val+temp2.val+carry;
				carry = value/10;
				value = value%10;
				ListNode temp = new ListNode(value);
				newTail.next = temp;
				newTail = newTail.next;
			}
			temp1= temp1.next;
			temp2 = temp2.next;
		}
		while(temp1!=null) {
			int value = temp1.val+carry;
			carry = value/10;
			value = value%10;
			ListNode temp = new ListNode(value);
			newTail.next = temp;
			newTail = newTail.next;
			temp1 = temp1.next;
		}while(temp2!=null) {
			int value = temp2.val+carry;
			carry = value/10;
			value = value%10;
			ListNode temp = new ListNode(value);
			newTail.next = temp;
			newTail = newTail.next;
			temp2 = temp2.next;
		}if(carry!=0) {
			ListNode temp = new ListNode(carry);
			newTail.next =temp;
			newTail = newTail.next;
		}
		//newHead = reverse(newHead);
		return newHead;
	}
	@SuppressWarnings("unused")
	private static ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode current = head,next = null,prev =null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current ;
			current = next;
		}
		return prev;
	}
	//the digits are stored in reverse order...
	//so if the digits were not in reverse order just undo the commented lines in the 
	//method above.
	

	public static void main(String[] args) {
		ListNode head1 = takeInput();
		ListNode head2 = takeInput();
		ListNode head = addTwoNumbers(head1,head2);
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
