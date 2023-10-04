package hashMapAndHeap;

import java.util.ArrayList;

public class DesignHashMap {

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(3, 5);
        hm.put(2, 5);
        System.out.println(hm.get(2));        
    }
}

class mpNode<K, V> {
    K key;
    V value;
    mpNode<K, V> next;

    public mpNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    ArrayList<mpNode<Integer, Integer>> bucket;
    int count;
    int numBuckets;

    MyHashMap() {
        bucket = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) {
            bucket.add(null);
        }
        count = 0;
    }

    int getBucketIndex(int key) {
        Integer k = key;
        int hc = k.hashCode();
        int index = hc % bucket.size();
        return index;
    }

    void put(int key, int value) {
        int index = getBucketIndex(key);
        mpNode<Integer, Integer> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucket.get(index);
        mpNode<Integer, Integer> toInsert = new mpNode<>(key, value);
        toInsert.next = head;
        bucket.set(index, toInsert);
        count++;
        double loadFactor = (1.0 * count) / numBuckets;
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    int get(int key) {
        int index = getBucketIndex(key);
        mpNode<Integer, Integer> head = bucket.get(index);
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return Integer.MIN_VALUE;
    }

    void remove(int key) {
        int index = getBucketIndex(key);
        mpNode<Integer, Integer> prev = null;
        mpNode<Integer, Integer> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    bucket.set(index, head.next);
                }
                count--;
                return;
            }
        }
        return;
    }

    void reHash() {
        ArrayList<mpNode<Integer, Integer>> temp = bucket;
        bucket = new ArrayList<>();
        for (int i = 0; i < 2 * numBuckets; i++) {
            bucket.add(null);
        }
        count = 0;
        numBuckets *= 2;
        for (int i = 0; i < temp.size(); i++) {
            mpNode<Integer, Integer> head = temp.get(i);
            if (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }
}
