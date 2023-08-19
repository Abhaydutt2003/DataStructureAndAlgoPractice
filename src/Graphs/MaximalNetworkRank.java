package Graphs;

import java.util.*;

public class MaximalNetworkRank {

    public static void main(String args[]) {

    }

    // //based on indegree
    public static int util1(int n, int[][] roads) {
        // const the graph
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int v1 = roads[i][0];
            int v2 = roads[i][1];
            HashSet<Integer> v1Set = graph.getOrDefault(v1, new HashSet<Integer>());
            HashSet<Integer> v2Set = graph.getOrDefault(v2, new HashSet<Integer>());
            v1Set.add(v2);
            v2Set.add(v1);
            graph.put(v1, v1Set);
            graph.put(v2, v2Set);
        }
        // now check for all pairs for the answer, we are given that 0 <= ai, bi <= n-1
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int v1 = i;
            HashSet<Integer> v1Set = graph.getOrDefault(v1, new HashSet<Integer>());
            for (int j = i + 1; j < n; j++) {
                int v2 = j;
                HashSet<Integer> v2Set = graph.getOrDefault(v2, new HashSet<Integer>());
                int size1 = v1Set.size();
                int size2 = v2Set.size();
                if (v1Set.contains(v2)) {
                    size1 -= 1;
                }
                int candidate = size1 + size2;
                ans = Math.max(ans, candidate);
            }
        }
        return ans;
    }

    // using adj matrix
    public static int util2(int n, int roads[][]) {
        // construct indegree and graph
        int adjMatrix[][] = new int[n][n];
        int indegree[] = new int[n];
        for (int i = 0; i < roads.length; i++) {
            adjMatrix[roads[i][0]][roads[i][1]] = 1;
            adjMatrix[roads[i][1]][roads[i][0]] = 1;
            indegree[roads[i][0]]++;
            indegree[roads[i][1]]++;
        }
        // now traverse for all the pairs
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int candidate = indegree[i] + indegree[j];
                if (adjMatrix[i][j] == 1) {
                    candidate--;
                }
                ans = Math.max(ans, candidate);
            }
        }
        return ans;
    }

}
