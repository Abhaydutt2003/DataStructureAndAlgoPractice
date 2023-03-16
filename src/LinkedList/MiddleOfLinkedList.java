package linkedList;

import java.util.*;
public class MiddleOfLinkedList {
    public static void main(String args[]){
        ListNode head = takeInput();
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            if(fast.next == null ){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
