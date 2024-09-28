package hashTable;

import java.util.*;

public class TopKFreq {

    public static void main(String args[]) {
        int arr[] = { 1, 1, 2, 2, 3 };
        int k = 2;
        int ans[] = util1(arr, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] util1(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, (hm.getOrDefault(i, 0) + 1));
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bucket = new ArrayList[arr.length + 1];
        for (Map.Entry<Integer, Integer> a : hm.entrySet()) {
            int element = a.getKey();
            int freq = a.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
                bucket[freq].add(element);
            } else {
                bucket[freq].add(element);
            }
        }
        int ans[] = new int[k];
        int counter = 0;
        for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    ans[counter++] = j;
                }
            }
        }
        return ans;
    }

}
