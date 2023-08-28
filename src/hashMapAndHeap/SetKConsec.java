package hashMapAndHeap;

import java.util.*;

public class SetKConsec {

    public static void main(String args[]) {
        int arr[] = { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };
        System.out.print(util1(arr, 3));
    }

    public static boolean util1(int arr[], int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i : arr) {
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }
        while (tm.isEmpty() == false) {
            int currentLength = 0;
            int toLookFor = -1;
            while (tm.isEmpty() == false && currentLength < k) {
                if (toLookFor == -1) {
                    int first = tm.firstKey();
                    if (tm.get(first) == 1) {
                        tm.remove(first);
                    } else {
                        tm.put(first, tm.get(first) - 1);
                    }
                    currentLength++;
                    toLookFor = first + 1;
                } else {
                    if (tm.containsKey(toLookFor) == false) {
                        return false;
                    } else {
                        if (tm.get(toLookFor) == 1) {
                            tm.remove(toLookFor);
                        } else {
                            tm.put(toLookFor, tm.get(toLookFor) - 1);
                        }
                        toLookFor = toLookFor + 1;
                        currentLength++;
                    }
                }
            }
            if (currentLength < k) {
                return false;
            }
        }
        return true;
    }

}
