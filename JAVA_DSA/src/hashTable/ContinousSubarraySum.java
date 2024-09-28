package hashTable;

import java.util.*;

public class ContinousSubarraySum {

    public static void main(String[] args) {
        int arr[] = { 6 };
        int k = 6;
        System.out.print(util1(arr, k));
    }

    // {}

    public static boolean util1(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum % k)) {
                if (hm.get(sum % k) < i) {
                    return true;
                }
            } else {
                hm.put(sum % k, i + 1);
            }
        }
        return false;
    }
}
