package Graphs;

import java.util.*;

public class JumpGame3 {

    public static void main(String args[]) {

    }

    public static boolean util1(int[] arr, int start) {
        // visited = new boolean[arr.length];
        return helper(arr, start);
    }

    public static boolean helper2(int arr[], int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        boolean v[] = new boolean[arr.length];
        while (q.isEmpty() == false) {
            int currIndex = q.poll();
            if (arr[currIndex] == 0) {
                return true;
            }
            v[currIndex] = true;
            int dir1 = currIndex + arr[currIndex];
            int dir2 = currIndex - arr[currIndex];
            if (dir1 >= 0 && dir1 < arr.length && v[dir1] == false) {
                q.add(dir1);
            }
            if (dir2 >= 0 && dir2 < arr.length && v[dir2] == false) {
                q.add(dir2);
            }
        }
        return false;
    }

    // dfs
    public static boolean helper(int arr[], int index) {
        if (arr[index] == 0) {
            return true;
        }
        visited[index] = true;
        int dir1 = index + arr[index];
        int dir2 = index - arr[index];
        if (dir1 >= 0 && dir1 < arr.length && visited[dir1] == false) {
            boolean ans = helper(arr, dir1);
            if (ans) {
                return ans;
            }
        }
        if (dir2 >= 0 && dir2 < arr.length && visited[dir2] == false) {
            boolean ans = helper(arr, dir2);
            if (ans) {
                return ans;
            }
        }
        return false;
    }

    static boolean visited[];

}
