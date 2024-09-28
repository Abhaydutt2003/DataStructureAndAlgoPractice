package hashTable;

import java.util.*;

public class FlowersInFullBloom {

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 6 },
                { 3, 7 },
                { 9, 12 },
                { 4, 13 }
                // { 1, 10 },
                // { 3, 3 }
        };
        int arr[] = { 2, 3, 7, 11 };
        int ans[] = util2(matrix, arr);
        for (int i : ans) {
            System.out.println(i + " ");
        }
    }

    public static int[] util2(int[][] flowers, int[] people) {
        // will need to use map
        HashMap<Integer, Integer> hm = new HashMap<>();
        // sort flowers
        Arrays.sort(flowers, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        // sort people
        int arr[] = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            arr[i] = people[i];
        }
        Arrays.sort(people);
        // pq to keep the flowers
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        int k = 0;
        for (int i = 0; i < people.length; i++) {
            // put the flowers which are in bloom
            while (k < flowers.length && flowers[k][0] <= people[i]) {
                pq.add(new int[] { flowers[k][0], flowers[k][1] });
                k++;
            }
            // pop the flowers which are not in bloom
            while (pq.isEmpty() == false && pq.peek()[1] < people[i]) {
                pq.poll();
            }
            if (hm.containsKey(people[i])) {
                // do nothing
            } else {
                hm.put(people[i], pq.size());
            }
        }
        int ans[] = new int[people.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }

    // wrong,but almost correct
    public static int[] util1(int[][] flowers, int[] people) {
        // sort flowers
        Arrays.sort(flowers, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        // sort people
        Arrays.sort(people);
        // pq to keep the flowers
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        int k = 0;
        int ans[] = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            // pop the flowers which are not in bloom
            while (pq.isEmpty() == false && pq.peek()[1] < people[i]) {
                pq.poll();
            }
            // put the flowers which are in bloom
            while (k < flowers.length && flowers[k][0] <= people[i]) {
                pq.add(new int[] { flowers[i][0], flowers[i][1] });
                k++;
            }
            ans[i] = pq.size();
        }
        return ans;
    }

}
