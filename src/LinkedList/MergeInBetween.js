function ListNode(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
}




/**
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function(list1, a, b, list2) {
    //traverse and get the tail of list2  
    let temp = list2;
    while(temp.next!=null){
        temp = temp.next;
    }
    let dummyNode = new ListNode(0,list1),tail = temp,prev = dummyNode,index = 0;
    temp = list1;
    while(index != a){
        index++;
        prev = temp;
        temp = temp.next;
    }
    prev.next = temp;
    while(index<b){
        index++;
        temp = temp.next;
    }
    tail.next = temp;
    return dummyNode.next;
};





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

  
