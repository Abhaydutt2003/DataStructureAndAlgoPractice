package dynamicProgramming;

import java.util.*;

// class lc740Helper {
//     int no;
//     int freq;

//     lc740Helper(int no, int freq) {
//         this.freq = freq;
//         this.no = no;
//     }
// }

public class DeleteAndEarn {

    public static void main(String agrs[]) {
        int arr[] = { 1, 2, 3, 15, 16, 17, 18 };
        System.out.print(util2(arr));
    }

    public static int util2(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int freq[] = new int[max + 1];
        for (int i : arr) {
            freq[i]++;
        }
        dp = new int[freq.length];
        Arrays.fill(dp, -1);
        return helper2(freq, 0);
    }

    static int dp[];

    public static int helper2(int arr[], int i) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans1 = helper2(arr, i + 1);
        int ans2 = helper2(arr, i + 2) + (i * arr[i]);
        return dp[i] = Math.max(ans1, ans2);
    }

    public static int util1(int[] arr) {
        hm = new HashMap<>();
        return helper(arr, 0);
    }

    static HashMap<Integer, Boolean> hm;

    public static int helper(int[] arr, int i) {
        if (i == arr.length) {
            return 0;
        }
        if (hm.containsKey(arr[i])) {
            if (hm.get(arr[i]) == false) {
                return helper(arr, i + 1);
            } else {
                return helper(arr, i + 1) + arr[i];
            }
        } else {
            hm.put(arr[i] - 1, false);
            hm.put(arr[i] + 1, false);
            hm.put(arr[i], true);
            int ans1 = helper(arr, i + 1) + arr[i];
            hm.remove(arr[i] - 1, false);
            hm.remove(arr[i] + 1, false);
            hm.remove(arr[i], true);
            hm.put(arr[i], false);
            int ans2 = helper(arr, i + 1);
            return Math.max(ans1, ans2);

        }
    }

    // house robber approach..

    // apparantly this happens when the array is already sorted

    // public static int util2(int arr[]) {
    // HashMap<Integer, Integer> hm2 = new HashMap<>();
    // for (int i = 0; i < arr.length; i++) {
    // if (hm2.containsKey(arr[i]) == false) {
    // hm2.put(arr[i], 1);
    // } else {
    // hm2.put(arr[i], hm2.get(arr[i]) + 1);
    // }
    // }
    // lc740Helper[] arr2 = new lc740Helper[hm2.size()];
    // int i = 0;
    // for (Map.Entry<Integer, Integer> en : hm2.entrySet()) {
    // lc740Helper a = new lc740Helper(en.getKey(), en.getValue());
    // arr2[i++] = a;
    // }
    // for(lc740Helper a: arr2){
    // System.out.println(a.no+" "+a.freq);
    // }
    // return 0;
    // }

    // static int dp[];

    // public static int helper2(lc740Helper[] arr, int i) {
    // if (i == arr.length) {
    // return 0;
    // }

    // if (dp[i] != -1) {
    // return dp[i];
    // }

    // int ans1 = helper2(arr, i + 1);
    // int ans2 = (arr[i].no) * (arr[i].freq);
    // if (i + 1 != arr.length && arr[i + 1].no == arr[i].no + 1) {
    // // System.out.print("aloo");
    // ans2 += helper2(arr, i + 2);
    // } else {
    // ans2 += helper2(arr, i + 1);
    // }

    // return dp[i] = Math.max(ans1, ans2);
    // }

}
