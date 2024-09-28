package hashTable;

import java.util.*;

class lc373comp implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class KPairWithSmallestSum {

    public static void main(String args[]) {
        // int []a = {100,2,3};
        // int b[] = {99,4,5};
        // int c []= {103,6,7};
        // PriorityQueue<int[]> pq = new PriorityQueue<>(new lc373comp());
        // pq.add(a);
        // pq.add(b);
        // pq.add(c);
        // System.out.print(pq.poll()[0]);
        int arr1[] = { 1, 7, 11 };
        int arr2[] = { 2, 4, 6 };
        int k = 8;
        List<List<Integer>> ans = util1(arr1, arr2, k);
        for (List<Integer> l : ans) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> util1(int[] nums1, int nums2[], int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new lc373comp());
        for (int i = 0; i < k && i < nums1.length; i++) {
            int sum = nums1[i] + nums2[0];
            int toAdd[] = { sum, i, 0 };
            pq.add(toAdd);
        }

        while (k-- > 0 && pq.isEmpty() == false) {
            int[] current = pq.poll();
            List<Integer> l = new ArrayList<>();
            l.add(nums1[current[1]]);
            l.add(nums2[current[2]]);
            ans.add(l);
            if (current[2] + 1 < nums2.length) {
                int sum = nums1[current[1]] + nums2[current[2] + 1];
                pq.add(new int[] { sum, current[1], current[2] + 1 });
            }
        }
        return ans;
    }

}
