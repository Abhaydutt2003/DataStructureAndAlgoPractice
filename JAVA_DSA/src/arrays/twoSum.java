package arrays;

import java.util.*;

public class twoSum {

    public static void main(String args[]) {
        int arr[] = { 2, 7, 11, 15 };
        arr = util1(arr, 9);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] util1(int nums[], int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toLookFor = target - nums[i];
            if (hm.containsKey(toLookFor)) {
                int ans[] = new int[] { hm.get(toLookFor), i };
                return ans;
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[] { -1 };
    }

}