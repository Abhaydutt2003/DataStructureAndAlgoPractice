package linkedList;

import java.util.*;
public class MergeKLinkedList {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ListNode[] lists = new ListNode[n];
        int k=0;
        for(int i = 0;i<n;i++){
            lists[k++] = takeInput();
        }
        ListNode ans = mergeKLists(lists);
        print(ans);
        // double a = Math.ceil(3/(2*1.0));
        // System.out.println(a+" ");
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

    public static ListNode mergeKLists(ListNode [] lists){
        if(lists.length == 0){return null;}
        return util2(lists);
    }

    //using heap, comparing every k nodes, optimizing it by heap.
    public static ListNode util1(ListNode [] lists){
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> (a.val-b.val));
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while(pq.isEmpty() == false){
            ListNode popped = pq.poll();
            ListNode toInsert = popped.next;
            if(toInsert != null){
                pq.add(toInsert);
            }
            if(head == null){
                head = popped;
                tail = popped;
            }else{
                tail.next = popped;
                tail = tail.next;
            }
        }
        return head;
    }
    //using divide and conquer
    public static ListNode util2(ListNode [] lists){
        if(lists.length == 1){
            return lists[0];
        }
        int newListLength = (int)Math.ceil(lists.length/(2*1.0));
        ListNode [] newLists = new ListNode[newListLength];
        int k = 0;
        for(int i = 0;i<lists.length;){
            ListNode a = lists[i];
            if(i+1 == lists.length){
                newLists[k] = a;
                break;
            }
            ListNode b = lists[i+1];
            ListNode toPut = merge2Lists(a, b);
            i +=2;
            newLists[k++] = toPut;
        }
        return util2(newLists);
    }
    //code for merging two sorted lists
    public static ListNode merge2Lists(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null && list2 != null){
            return list2;
        }if(list1 != null && list2 == null){
            return list1;
        }

        ListNode head = null;
        ListNode tail = null;
        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                if(head == null){
                    head = list1;
                    tail = list1;
                }else{
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = list2;
                    tail = list2;
                }else{
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }
        while(list1!=null){
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }
        while(list2!=null){
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }
        return head;
    }
}
