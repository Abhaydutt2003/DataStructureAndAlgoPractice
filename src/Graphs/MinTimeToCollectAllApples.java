package Graphs;

import java.util.*;

public class MinTimeToCollectAllApples {

    public static void main(String args[]) {

    }

    public static int util1(int n, int edges[][], List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = getAdj(edges, n);
        visited = new boolean[n];
        apples = hasApple;
        int ans = dfs(adj, 0);
        if (ans == 0) {
            return 0;
        } else {
            return ans - 2;
        }
    }

    static List<Boolean> apples;
    static boolean[] visited;

    public static int dfs(ArrayList<ArrayList<Integer>> adj, int source) {
        int toSend = 0;
        visited[source] = true;
        ArrayList<Integer> currentList = adj.get(source);
        for (int i : currentList) {
            if (visited[i] == false) {
                int smallAns = dfs(adj, i);
                if (smallAns >= 2) {
                    toSend += smallAns;
                }
            }
        }
        if (toSend >= 2) {
            return toSend + 2;
        } else if (apples.get(source)) {
            return 2;
        } else {
            return 0;
        }
    }

    public static ArrayList<ArrayList<Integer>> getAdj(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return adj;
    }

}
