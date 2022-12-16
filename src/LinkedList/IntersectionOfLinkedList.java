package linkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
class help{
	ListNode lastNode;
	int length;
	help(ListNode a,int b){
		this.lastNode = a;
		this.length = b;
	}
}
public class IntersectionOfLinkedList {
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
		ListNode head2 = takeInput();
		print(getIntersectionNode(head,head2));

	}
	//Ignore this code....
	public static ListNode get(ListNode headA, ListNode headB) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ListNode temp = headA;int i = 0;
		while(temp!=null) {
			map.put(i,temp.val);i++;temp = temp.next;
		}
		ListNode temp2 = headB,ans = null,ansTail = null;int j = 0;
		while(temp2!=null) {
			if(map.containsKey(j)) {
				if(map.get(j) == temp2.val) {
					if(ans == null) {
						ans = new ListNode(temp2.val);
						ansTail = ans;
					}else {
						ansTail.next = new ListNode(temp2.val);
						ansTail  =ansTail.next;
					}
				}
			}
			temp2 =temp2.next;j++;
		}
		return ans;
	}
	//works, very slow...
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		HashSet<ListNode> nodes = new HashSet<ListNode>();
		ListNode temp = headA,temp2 =headB;
		while(temp!=null) {nodes.add(temp);temp = temp.next;}
		while(temp2!=null) {
			if(nodes.contains(temp2)) {return temp2;}temp2 = temp2.next;
		}
		return null;
	}
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		//first traversal...
		help a = traversal(headA);
		help b = traversal(headB);
		if(a.lastNode.equals(b.lastNode)!=true) {
			return null;
		}
		int aLength = a.length,bLength = b.length;
		//second list traversal..
		int sTreversal = Math.abs(aLength-bLength);
		ListNode temp,temp2;
		if(aLength>bLength) {
			temp = headA;temp2 =headB;
		}else {
			temp =headB;temp2 = headA;
		}
		while(sTreversal!=0) {
			temp = temp.next;
			sTreversal--;
		}
		
		while(true) {
			if(temp.equals(temp2)) {
				break;
			}
			temp = temp.next;
			temp2 =temp2.next;
		}
		return temp;
	}
	private static help traversal(ListNode head) {
		ListNode temp = head;
		int length = 0;
		while(temp.next!=null) {
			length++;temp =temp.next;
		}
		length++;
		help ans = new help(temp,length);
		return ans;
	}
	
	

}
