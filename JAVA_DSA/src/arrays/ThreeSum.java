package arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String args[]) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = util2(arr);
        for (List<Integer> a : ans) {
            for (Integer b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        // HashSet<int[]> hs = new HashSet<>();
        // int arr[] = {1,2,3};
        // int arr2[] = {1,2,3};
        // hs.add(arr);
        // hs.add(arr2);
        // // hs.add(new int[]{1,2,3});
        // // hs.add(new int[]{1,2,3});
        // System.out.print(hs.size());
        // HashSet<List<Integer>> hs = new HashSet<>();
        // List<Integer> a = Arrays.asList(1,2,3);
        // List<Integer> b = Arrays.asList(1,2,3);
        // hs.add(a);
        // hs.add(b);
        // System.out.print(hs.size());
    }

    // apparently hashSet does not work as expected for int[]

    // public static List<List<Integer>> util1(int[] nums) {
    // Arrays.sort(nums);
    // HashSet<int[]> hs = new HashSet<>();
    // for (int i = 0; i < nums.length; i++) {
    // int j = i + 1, k = nums.length - 1;
    // while (j < k) {
    // int currSum = nums[i] + nums[j] + nums[k];
    // if (currSum == 0) {
    // hs.add(new int[] { nums[i], nums[j], nums[k]});
    // j++;
    // k--;
    // } else if (currSum < 0) {
    // j++;
    // } else {
    // k--;
    // }
    // }
    // }
    // List<List<Integer>> ans = new ArrayList<>();
    // for (int[] a : hs) {
    // ans.add(Arrays.asList(a[0], a[1], a[2]));
    // }
    // return ans;
    // }

    public static List<List<Integer>> util1(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum == 0) {
                    hs.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (currSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(hs);
        return ans;
    }

    // this one takes care of duplicates, no need of HashSet
    public static List<List<Integer>> util2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = arr.length - 2; i >= 0; i--) {
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        while (j < k && arr[j] == arr[j + 1])
                            j++;
                        while (k > i && arr[k] == arr[k - 1])
                            k--;
                        j++;
                        k--;
                    } else if (sum < 0) {
                        while (j < k && arr[j] == arr[j + 1])
                            j++;
                        j++;
                    } else {
                        while (k > i && arr[k] == arr[k - 1])
                            k--;
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
