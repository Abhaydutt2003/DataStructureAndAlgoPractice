package arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class Node <K,V>{
	K key;
	V value;
	Node<K,V> next;
	Node(K key, V value){
		this.key = key;
		this.value = value;
	}
}
class myMap<K,V>{
	 ArrayList <Node<K,V>> bucket;
	 int count;
	 int numBuckets;
	myMap(){
		bucket = new ArrayList<>();
		numBuckets= 10;
		for(int i = 0;i<numBuckets;i++) {
			bucket.add(null);
		}
		count =0;
	}
	void insert(K key, V value) {
		int index = getIndex(key);
		Node<K,V> head = bucket.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head =head.next;
		}
		head =bucket.get(index);
		Node<K,V> toInsert = new Node<K,V>(key,value);
		toInsert.next = head;
		bucket.set(index, toInsert);
		count++;
		double loadFactor = (1.0 * count)/numBuckets;
		if(loadFactor >0.7) {
			reHash();
		}
	}
	private void reHash() {
		ArrayList<Node<K,V>> temp = bucket;
		bucket = new ArrayList<>();
		for(int i = 0;i< 2*numBuckets;i++) {
			bucket.add(null);
		}
		count = 0;
		numBuckets = numBuckets*2;
		for(int i = 0;i<temp.size();i++) {
			Node<K,V> head = temp.get(i);
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
		}
	}
	V getValue(K key) {
		int index = getIndex(key);
		Node<K,V> head = bucket.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
		}
		return null;
	}
	V removeKey(K key) {
		int index = getIndex(key);
		Node<K,V> prev = null;
		Node<K,V> head = bucket.get(index);
		while(head!= null) {
			if(head.key.equals(key)) {
				if(prev == null) {
					bucket.set(index,head.next);
				}else {
					prev.next = head.next;
				}
				count--;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
	private int getIndex(K key) {
		int hc = key.hashCode();
		int index = hc%bucket.size();
		return index;
	}
	boolean isPresent(K key) {
		int index = getIndex(key);
		Node<K,V> head = bucket.get(index);
		while(head!= null) {
			if(head.key.equals(key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
}
public class IntersectionOfArrays {
	public static int[] intersection(int [] nums1, int nums2[]) {
		myMap<Integer,Integer> hp = new myMap<>();
		for(int i = 0;i<nums1.length;i++) {
			int toBeInserted = 0;
			if(hp.getValue(nums1[i]) != null) {
				toBeInserted = hp.getValue(nums1[i]);
			}
			toBeInserted++;
			hp.insert(nums1[i],toBeInserted);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0;i<nums2.length;i++) {
			int toLook = nums2[i];
			if(hp.isPresent(toLook) && hp.getValue(toLook) != 0) {
				ans.add(toLook);
				//int prev = hp.getValue(toLook);
				hp.insert(toLook,0);
			}
		}
		int a[] = new int[ans.size()];
		for(int i = 0;i<a.length;i++)
			a[i] = ans.get(i);
		
		return a;
	}
	public static int[] intersection2(int nums1[], int nums2[]) {
		HashSet <Integer> hp = new HashSet<>();
		for(int i = 0;i<nums1.length;i++) {
			for(int j = 0;j<nums2.length;j++) {
				if(nums1[i] == nums2[j]) {
					hp.add(nums1[i]);
					break;
				}
			}
		}
		int arr[] = new int[hp.size()];
		int j = 0;
		for(int i : hp)
			arr[j++] = i;
		
		return arr;
	}
	public static int[] intersection3 (int nums1[], int nums2[]){
		HashSet<Integer> a = new HashSet<Integer>();
		HashSet<Integer> b = new HashSet<>();
		for(int i = 0;i<nums1.length;i++)
			a.add(nums1[i]);
		
		for(int i = 0;i<nums2.length;i++)
			if(a.contains(nums2[i]))
				b.add(nums2[i]);
		
		int arr[] = new int[b.size()];
		int j = 0;
		for(int i: b) {
			arr[j++] = i;
		}
		return arr;
	}

	public static void main(String[] args) {
		int nums1[] = {4,9,5};
		int nums2[] = {9,4,9,8,4};
		int ans[] = intersection3(nums1,nums2);
		
		for(int i = 0;i<ans.length;i++)
			System.out.print(ans[i]+" ");

	}

}
