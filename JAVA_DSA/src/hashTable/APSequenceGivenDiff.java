package hashTable;

import java.util.*;

public class APSequenceGivenDiff {

    public static void main(String args[]) {
        int arr[] = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
        int k = -2;
        System.out.print(util1(arr, k));
    }

    public static int util1(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int toLookFor = arr[i] + k;
            if (hm.containsKey(toLookFor)) {
                int currentAns = hm.get(toLookFor) + 1;
                ans = Math.max(ans, currentAns);
                hm.put(arr[i], currentAns);
            } else {
                hm.put(arr[i], 1);
            }
        }
        return ans;
    }

    // public static int helper(int arr[], int k, int i){

    // }

}
