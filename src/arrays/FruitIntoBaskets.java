package arrays;

import java.util.*;

public class FruitIntoBaskets {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 2, 2 };
        System.out.print(util1(arr));
    }

    public static int util1(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int start = 0;
        int end = 1;
        hm.put(arr[start], 1);
        int ans = 1;
        while (end < arr.length) {
            hm.put(arr[end], hm.getOrDefault(arr[end], 0) + 1);
            if (hm.size() > 2) {
                while (hm.size() > 2) {
                    int c = hm.get(arr[start]);
                    if (c == 1) {
                        hm.remove(arr[start]);
                    } else {
                        hm.put(arr[start], c - 1);
                    }
                    start++;
                }
            }
            int currentSize = (end - start + 1);
            ans = Math.max(ans, currentSize);
            end++;
        }
        return ans;
    }

}
