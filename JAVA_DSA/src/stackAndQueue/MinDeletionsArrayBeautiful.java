package stackAndQueue;

import java.util.*;

public class MinDeletionsArrayBeautiful {

    public static void main(String[] args) {
        System.out.println(util1(new int[] { 1, 1, 2, 3, 5 }));
    }

    public static int util1(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int operations = 0;
        for (int i : arr) {
            if (s.isEmpty() == false && (s.peek() == i && (s.size() - 1) % 2 == 0)) {
                operations++;
            } else {
                s.push(i);
            }
        }
        while (s.size() % 2 != 0) {
            operations++;
            s.pop();
        }
        return operations;
    }

    // public static void main(String[] args) {
    // int matrix[][] = {
    // { 1, 5 },
    // { 1, 2 },
    // { 5, 2 },
    // { 4, 5 },
    // { 3, 2 },
    // { 4, 3 },
    // { 4, 6 }
    // };
    // ArrayList<ArrayList<Integer>> graph = constGraph(matrix);
    // visited = new boolean[8];
    // dfs(graph, 1);
    // }

    // public static void dfs(ArrayList<ArrayList<Integer>> graph, int start) {
    // visited[start] = true;
    // System.out.println(start);
    // ArrayList<Integer> current = graph.get(start);
    // for (int i : current) {
    // if (visited[i] == false) {
    // dfs(graph, i);
    // }
    // }
    // }

    // static boolean visited[];

    // public static ArrayList<ArrayList<Integer>> constGraph(int[][] matrix) {
    // ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // for (int i = 0; i < 8; i++) {
    // graph.add(new ArrayList<>());
    // }
    // for (int a[] : matrix) {
    // graph.get(a[0]).add(a[1]);
    // graph.get(a[1]).add(a[0]);
    // }
    // return graph;
    // }

}
