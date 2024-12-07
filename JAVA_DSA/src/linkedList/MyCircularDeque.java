package linkedList;


class Node641 {
    Node641 next;
    Node641 prev;
    int value;
    Node641(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }   
}


public class MyCircularDeque {

    Node641 head;
    Node641 tail;
    int length;
    int lengthLimit;
    
    public MyCircularDeque(int k) {
        this.length = 0;
        this.lengthLimit = k;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        Node641 current = new Node641(value);
        if(isFull()){
            return false;
        }else if(length == 0){
            this.head = current;
            this.tail = current;
            this.length++;
            return true;
        }else{
            current.prev = head;
            this.head.next = current;
            this.head = current;
            this.length++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        Node641 current = new Node641(value);
        if(isFull()){
            return false;
        }else if(length == 0){
            this.head = current;
            this.tail = current;
            this.length++;
            return true;
        }else{
            current.next = this.tail;
            this.tail.prev = current;
            this.tail = current;
            this.length++;
            return true;
        }
    }

    public boolean deleteFront() {
        if(this.length == 0){
            return false;
        }else{
            Node641 p = this.head.prev;
            p.next = null;
            this.head = p;
            this.length--;
            return true;
        }
    }

    public boolean deleteLast() {
        if(this.length == 0){
            return false;
        }else{
            Node641 n = this.tail.next;
            this.length--;
            return true;
        }
    }

    // public int getFront() {

    // }

    // public int getRear() {

    // }

    // public boolean isEmpty() {

    // }

    public boolean isFull() {
        return this.length == this.lengthLimit;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
