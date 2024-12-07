function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}

// /**
//  * @param {ListNode} head
//  * @return {ListNode}
//  */
// var removeZeroSumSublists = function(head) {
//     let dummyNode = new ListNode(0,head);
//     let temp = dummyNode;
//     let map = new Map();
//     let preSum = 0;
//     while(temp != null){
//         preSum += temp.val;
//         if(map.has(preSum)){
//             //the sum is seen previously, remove the zero conec nodes
//             removeNodes(map.get(preSum,map,preSum));
//         }else{
//             map.set(preSum,temp);
//         }
//         temp = temp.next;
//     }
//     return dummyNode.next;
// };

// /**
//  * remove all the concec nodes that have zero sum
//  * @param {ListNode} head
//  * @param {Map} map
//  * @param {Number} preSum
//  */
// let removeNodes = (head,map,preSum)=>{
//     let temp = head.next;
//     let newPreSum = temp.val;
//     while(newPreSum != preSum){
//         map.delete(newPreSum);
//         temp = temp.next;
//         newPreSum += temp.val;
//     }
//     temp = temp.next;
//     head.next = temp;
// }

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
let removeZeroSumSublists = (head) => {
  let map = new Map();
  let dummyNode = new ListNode(0, head);
  let current = dummyNode;
  let preSum = 0;
  while (current != null) {
    preSum += current.val;
    if (map.has(preSum)) {
      let start = map.get(preSum);
      let subNode = start.next;
      let p = preSum + subNode.val;
      while (p != preSum) {
        map.delete(p);
        subNode = subNode.next;
        p += subNode.val;
      }
      start.next = subNode.next;
      current = subNode;
    } else {
      map.set(preSum, current);
    }
    current = current.next;
  }
  return dummyNode.next;
};

//   1 2 4 5 6 -15

/**
 * convert an array of numbers to Linked List
 * @param {number[]} array
 * @returns {ListNode}
 */
let convertToLinkedList = (array) => {
  let head = null;
  let tail = null;
  array.map((node) => {
    if (head == null) {
      head = new ListNode(node);
      tail = head;
    } else {
      let newNode = new ListNode(node);
      tail.next = newNode;
      tail = newNode;
    }
  });
  return head;
};

/**
 * Traverse a LinkedList
 * @param {ListNode} head
 */
let traverseLl = (head) => {
  let temp = head;
  while (temp) {
    console.log(temp.val);
    temp = temp.next;
  }
};

let head = [1, 2, 3, -3, 4];
head = convertToLinkedList(head);
let ans = removeZeroSumSublists(head);
traverseLl(ans);
