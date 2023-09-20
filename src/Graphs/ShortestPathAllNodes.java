package Graphs;

import java.util.*;

public class ShortestPathAllNodes {

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 0 },
                { 0 },
                { 0 }
        };
        System.out.print(util2(matrix));
    }

    // easy peasy bfs code
    // O(n* 2^n)
    public static int util2(int[][] graph) {
        int allVisited = (1 << graph.length) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[allVisited + 1][graph.length];
        // keep every node as the start
        for (int i = 0; i < graph.length; i++) {
            int[] toAdd = new int[] { i, (1 << i), 1 };
            q.add(toAdd);
            visited[(1 << i)][i] = true;
        }
        // now start bfs
        while (q.isEmpty() == false) {
            int[] current = q.poll();
            int currentNode = current[0];
            int currentMask = current[1];
            int currentSteps = current[2];
            if (currentMask == allVisited) {
                return currentSteps - 1;
            }
            for (int i = 0; i < graph[currentNode].length; i++) {
                int ngh = graph[currentNode][i];
                int newMask = currentMask | (1 << ngh);
                if (visited[newMask][ngh] == true) {
                    continue;
                }
                q.add(new int[] { ngh, newMask, currentSteps + 1 });
                visited[newMask][ngh] = true;
            }
        }
        return -1;
    }

    // tried and utterly failed
    public static int util1(int[][] mat) {
        // construct graph
        ArrayList<ArrayList<Integer>> graph = getGraph(mat);
        // run bfs
        dp = new int[1 << mat.length];
        Arrays.fill(dp, -1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int smallAns = dfs(graph, i, (0 | (1 << i)), 1, 0);
            ans = Math.min(ans, smallAns);
        }
        return ans;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int start, int mask, int uniqueVisited, int stepsTaken) {
        if (dp[mask] != -1) {
            return dp[mask];
        } else if (uniqueVisited == graph.size()) {
            return stepsTaken;
        }
        ArrayList<Integer> current = graph.get(start);
        int ans = Integer.MAX_VALUE;
        for (int i : current) {
            int ifCalled = mask | (1 << i);
            if (ifCalled != mask) {
                int smallAns;
                if ((mask & (1 << i)) == 0) {
                    smallAns = dfs(graph, i, ifCalled, uniqueVisited, stepsTaken + 1);
                } else {
                    smallAns = dfs(graph, i, ifCalled, uniqueVisited + 1, stepsTaken + 1);
                }
                ans = Math.min(ans, smallAns);
            }
        }
        return dp[mask] = ans;
    }

    static int dp[];

    public static ArrayList<ArrayList<Integer>> getGraph(int mat[][]) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                graph.get(i).add(mat[i][j]);
            }
        }
        return graph;
    }

}
