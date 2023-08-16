package arrays;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String args[]) {
        int arr[] = { 1, 5, 34, 6, 7, 8, 45, 34, 3, 2, 4, 5, 6 };
        int k = 5;
        int ans[] = util3(arr, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    //in the dequeue solution, we are keeping a queue of large numbers

    // leetcode better solution
    public static int[] util3(int arr[], int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            while (dq.isEmpty() == false && arr[dq.peekLast()] < arr[end]) {
                dq.pollLast();
            }
            dq.add(end);                                                                                                  
            if (start > dq.peekFirst()) {
                dq.pollFirst();
            }
            if (end + 1 >= k) {
                ans.add(arr[dq.peekFirst()]);
                start++;
            }
            end++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
     }

    // O(nk) tle
    public static int[] util2(int arr[], int k) {
        // consider dq as the window
        Deque<Integer> dq = new ArrayDeque<>();
        // build the window
        for (int i = 0; i < k; i++) {
            dq.add(arr[i]);
        }
        int ans[] = new int[arr.length - k + 1];
        int ansIndex = 0;
        // handle the start
        ans[ansIndex++] = getBiggest(dq);
        // now start to slide the window
        for (int i = k; i < arr.length; i++) {
            dq.pollFirst();
            dq.add(arr[i]);
            ans[ansIndex++] = getBiggest(dq);
        }
        return ans;
    }

    private static int getBiggest(Deque<Integer> dq) {
        int max = Integer.MIN_VALUE;
        for (int i : dq) {
            max = Math.max(max, i);
        }
        return max;
    }

    // using the infamous treemap O(nlogn)
    public static int[] util1(int[] arr, int k) {
        // build the window
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int start = 0;
        int end = 0;
        tm.put(arr[start], 1);
        while (end + 1 < k) {
            end++;
            tm.put(arr[end], tm.getOrDefault(arr[end], 0) + 1);
        }

        int ans[] = new int[arr.length - k + 1];
        int ansIndex = 0;

        // now start sliding the window
        while (true) {
            ans[ansIndex++] = tm.lastKey();
            if (end + 1 >= arr.length) {
                break;
            }
            end++;
            tm.put(arr[end], tm.getOrDefault(arr[end], 0) + 1);
            tm.put(arr[start], tm.get(arr[start]) - 1);
            if (tm.get(arr[start]) == 0) {
                tm.remove(arr[start]);
            }
            start++;
        }
        return ans;
    }

    // priority queue approach will fail here because if i remove a element once,
    // all its
    // occurances will be removed, therefore giving wrong answer
    // for example [2,2,2,1]

}
