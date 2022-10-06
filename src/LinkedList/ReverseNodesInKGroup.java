package linkedList;

import java.util.Scanner;

public class ReverseNodesInKGroup {
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
	private static ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		if(head == null || head.next == null) {
			return head;
		}
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
//	public static ListNode reverse(ListNode head, int k) {
//		if(head == null || head.next == null || k == 1) {
//			return head;
//		}
//		ListNode tail = head;
//		int i = 1;
//		while(tail!=null) {
//			if(i == k) {
//				ListNode temp = tail.next;
//				tail.next = null;
//				ListNode newHead = reverse(head);
//				head.next = temp;
//				
//				i=1;
//			}else {
//				tail = tail.next;
//				i++;
//			}
//		}
//		
//	}
	public static ListNode reverseKGroup(ListNode head,int k) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		for(int i = 1;i<k;i++){
			temp = temp.next;
			if(temp == null) {
				return head;
			}
		}
		ListNode toSend = temp.next;
		temp.next = null;
		ListNode newHead = reverse(head);
		ListNode smallAns = reverseKGroup(toSend,k);
		head.next = smallAns;
		return newHead;
	}
	
	
	public static void main(String args[]) {
		ListNode list = takeInput();
		list =reverseKGroup(list,3);
		System.out.println("");
		print(list);
		
	}

}
