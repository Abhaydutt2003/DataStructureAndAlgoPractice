package hashMapAndHeap;

import java.util.PriorityQueue;

public class CarPooling {

    public static void main(String[] args) {
        int matrix[][] = {
                { 2, 1, 5 },
                { 3, 3, 7 }
        };
        System.out.println(util1(matrix, 5));
    }

    public static boolean util1(int[][] trips, int limit) {
        PriorityQueue<int[]> incoming = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        for (int a[] : trips) {
            incoming.add(a);
        }
        PriorityQueue<int[]> outgoing = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int pos = 0;
        int currCap = limit;
        while (incoming.isEmpty() == false) {
            while (outgoing.isEmpty() == false && outgoing.peek()[0] <= pos) {
                currCap += outgoing.poll()[1];
            }
            while (incoming.isEmpty() == false && incoming.peek()[1] <= pos) {
                int[] arr = incoming.poll();
                if (currCap - arr[0] < 0) {
                    return false;
                }
                outgoing.add(new int[] { arr[2], arr[0] });
                currCap -= arr[0];
            }
            pos++;
        }
        return true;
    }

    // O(max)
    public static boolean util2(int[][] trips, int limit) {
        int max = Integer.MIN_VALUE;
        for (int a[] : trips) {
            max = Math.max(max, a[2]);
        }
        int numberLine[] = new int[max + 1];
        for (int a[] : trips) {
            numberLine[a[1]] += a[0];
            numberLine[a[2]] -= a[0];
        }
        int cap = 0;
        for (int i = 0; i < numberLine.length; i++) {
            cap += numberLine[i];
            if (cap > limit) {
                return false;
            }
        }
        return true;
    }

}
