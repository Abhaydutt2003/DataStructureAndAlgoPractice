package hashMapAndHeap;

import java.util.*;

public class DifferenceInTwoArrays {

    public static void main(String args[]) {

    }

    public static List<List<Integer>> util1(int arr1[], int arr2[]) {
        List<Integer> list1 = onlyInArr1(arr1, arr2);
        List<Integer> list2 = onlyInArr2(arr1, arr2);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);
        return ans;
    }

    private static List<Integer> onlyInArr1(int arr1[], int arr2[]) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr1) {
            s.add(i);
        }
        for (int i : arr2) {
            if (s.contains(i)) {
                s.remove(i);
            }
        }
        return new ArrayList<>(s);
    }

    private static List<Integer> onlyInArr2(int arr1[], int arr2[]) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr2) {
            s.add(i);
        }
        for (int i : arr1) {
            if (s.contains(i)) {
                s.remove(i);
            }
        }
        return new ArrayList<>(s);
    }
}
