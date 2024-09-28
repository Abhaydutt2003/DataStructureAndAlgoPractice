package linkedList;
import java.util.Scanner;
class ListNode{
	int val;
	ListNode next;
	ListNode(){
		
	}
	ListNode(int val){
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}
public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}else if(head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);
		ListNode newTail = head.next;
		newTail.next = head;
		head.next = null;
		return newHead;
	}
	public static ListNode reverseIterative(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		if(head == null || head.next == null) {
			return head;
		}
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
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
	
	public static void main(String args[]) {
		ListNode list = takeInput();
		System.out.println("");
		print(list);
		System.out.println("");
		ListNode newHead = reverseList(list);
		print(newHead);
	}

}
