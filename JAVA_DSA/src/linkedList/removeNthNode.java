// import java.util.*;
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         //very easy to do in java
//         HashMap<Integer,ListNode> hm = new HashMap<>();
//         //call the func to fill the map 
//         int length = getLength(head,hm);
//         //do the necc removals
//         //check if the node to remove is the start node
//         if(n == length){
//             return head.next;
//         }else if(n == 1){
//             //check if the node to remove is the last node
//             hm.get(2).next = null;
//             return head;
//         }else{
//             //the node to remove is in between
//             hm.get(n+1).next = hm.get(n).next;
//             hm.get(n).next = null;
//             return head;
//         }
//     }

//     public int getLength(ListNode head,HashMap<Integer,ListNode>hm){
//         if(head == null){
//             //reached the end
//             return 0;
//         }
//         //add 1 to the pos from the back
//         int posFromBack = getLength(head.next,hm)+1;
//         //set the entry in the map
//         hm.put(posFromBack,head);
//         return posFromBack;
//     }
// }
