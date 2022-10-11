package linkedList;

import java.util.Scanner;

public class IntersectionLinkedList {
	public static ListNode intersection(ListNode head,ListNode head2) {
		if(head == null || head2 == null) {return null;}
		ListNode newHead;
		if(head.val>head2.val) {
			newHead = intersection(head,head2.next);
		}else if(head.val<head2.val) {
			newHead = intersection(head.next,head2);
		}else {
			newHead = new ListNode(head.val);
			newHead.next = intersection(head.next,head2.next);
		}
		return newHead;
	}
	public static ListNode intersection2(ListNode head, ListNode head2) {
		if(head == null || head2 == null) {return head;}
		ListNode newHead = null, newTail = null,temp1 = head,temp2 = head2;
		while(temp1!=null || temp2 != null) {
			if(temp1.val>temp2.val){temp2 = temp2.next;}
			else if(temp1.val<temp2.val){temp1 =temp1.next;}
			else {
				if(newHead == null){
					newHead = new ListNode(temp1.val);
					newTail = newHead;
				}else {
					ListNode temp = new ListNode(temp1.val);
					newTail = temp;
					newTail = newTail.next;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return newHead;
	}
	
	

	public static void main(String[] args) {
		ListNode head = takeInput();
		ListNode head2 =takeInput();
		head = intersection(head,head2);
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
