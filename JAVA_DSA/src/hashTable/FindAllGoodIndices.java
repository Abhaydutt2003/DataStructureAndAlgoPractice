package hashTable;

import java.util.*;

public class FindAllGoodIndices {

    public static void main(String args[]) {
        int arr[] = { 7, 6, 5, 3, 5, 6, 9 };
        List<Integer> l = util1(arr, 3);
        for (int i : l) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> util1(int arr[], int k) {
        int arr1[] = new int[arr.length];
        arr1[0] = 1;
        int currDecLen = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                arr1[i] = ++currDecLen;
            } else {
                arr1[i] = 1;
                currDecLen = 1;
            }
        }

        int arr2[] = new int[arr.length];
        arr2[arr.length - 1] = 1;
        currDecLen = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                arr2[i] = ++currDecLen;
            } else {
                arr2[i] = 1;
                currDecLen = 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            } else if (i == arr.length - 1) {
                continue;
            } else {
                if (arr2[i + 1] >= k && arr1[i - 1] >= k) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }

}
