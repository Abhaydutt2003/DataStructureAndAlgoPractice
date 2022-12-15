package linkedList;

public class LLCycle2 {

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
		ListNode looper = detectCycle(a);
//		ListNode head = a;
//		while(head!=null) {
//			System.out.print(head.val+" ");
//			head = head.next;
//		}
		System.out.print(looper.val);

	}
	//using the FLOYD two pointer algorithm..
	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;fast =fast.next.next;
			if(slow == fast) {break;}
		}
		if(fast == null || fast.next == null) {return null;}
		ListNode temp = head;
		while(temp !=slow) {
			temp = temp.next;
			slow = slow.next;
		}
		return temp;
	}
	

}
