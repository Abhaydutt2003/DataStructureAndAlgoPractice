package linkedList;

public class DeleteLoopInALinkedList {

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
		e.next = c;
		removeLoop(a);
		ListNode head = a;
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}

	}
	public static void removeLoop(ListNode head) {
		if(head.next == head) {
			head.next = null;return;
		}
		ListNode slow = head,fast=head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {break;}
		}
		if(fast == null || fast.next == null) {System.out.print("There is no Loop");return;}
		ListNode looper = null,temp = head;
		while(slow!=temp) {
			slow =slow.next;
			temp = temp.next;
		}
		looper =temp;
		int count = 0;
		temp = head;
		while(true) {
			if(temp.next == looper) {
				count++;
				if(count == 2) {break;}
			}
			temp = temp.next;
		}
		temp.next = null;
	}

}
