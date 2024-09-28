package hashTable;

import java.util.*;

public class ContinousSub {

    public static void main(String args[]) {

    }

    // can be done with deque too
    public static long util2(int arr[]) {
        int start = 0, end = 0;
        long ans = 0;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        while (end < arr.length) {
            // handling max deque
            while (max.isEmpty() == false && arr[max.peekLast()] < arr[end]) {
                max.pollLast();
            }
            max.addLast(end);
            // handling min queue
            while (min.isEmpty() == false && arr[min.peekLast()] > arr[end]) {
                min.pollLast();
            }
            min.addLast(end);

            // shrink start pointer if the window exceeds limit
            while (max.isEmpty() == false && min.isEmpty() == false
                    && arr[max.peekFirst()] - arr[min.peekFirst()] > 2) {
                if (max.peekFirst() == start) {
                    max.pollFirst();
                }
                if (min.peekFirst() == start) {
                    min.pollFirst();
                }
                start++;
            }

            ans += (end - start) + 1;
            end++;
        }
        return ans;
    }

    // sliding window and TreeMap

    public static long util1(int[] arr) {
        long ans = 0;
        int start = 0, end = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        while (end < arr.length) {
            tm.put(arr[end], tm.getOrDefault(arr[end], 0) + 1);
            while (tm.size() > 1 && tm.lastKey() - tm.firstKey() > 2) {
                tm.put(arr[start], tm.get(arr[start]) - 1);
                if (tm.get(arr[start]) <= 0) {
                    tm.remove(arr[start]);
                }
                start++;
            }
            ans += (end - start + 1);
            end++;
        }
        return ans;
    }

}
