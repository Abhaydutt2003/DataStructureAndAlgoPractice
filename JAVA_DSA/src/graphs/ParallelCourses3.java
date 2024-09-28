package graphs;

import java.util.*;

public class ParallelCourses3 {

    public static void main(String[] args) {
        int n = 3;
        int relations[][] = {
                { 1, 3 },
                { 2, 3 }
        };
        int time[] = { 3, 2, 5 };
        System.out.println(util1(n, relations, time));
    }

    // toposort
    // the nodes with outdegree 0 will have the answer
    public static int util1(int n, int[][] relations, int time[]) {
        ArrayList<ArrayList<Integer>> graph = constGraph(n, relations);
        for (ArrayList<Integer> al : graph) {
            for (int i : al) {
                System.out.print(i + " |");
            }
            System.out.println();
        }
        indegree = new int[n + 1];
        wt = new int[n + 1];
        constIndegree(graph);
        bfsMod(graph, time);
        return ans;
    }

    public static void bfsMod(ArrayList<ArrayList<Integer>> graph, int time[]) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                wt[i] = time[i - 1];
            }
        }
        while (q.isEmpty() == false) {
            int current = q.poll();
            ArrayList<Integer> currentList = graph.get(current);
            if (currentList.size() == 0) {
                ans = Math.max(ans, wt[current]);
            } else {
                for (int a : currentList) {
                    indegree[a]--;
                    wt[a] = Math.max(wt[a], (time[a - 1] + wt[current]));
                    if (indegree[a] == 0) {
                        q.add(a);
                    }
                }
            }
        }
    }

    public static void constIndegree(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 1; i < graph.size(); i++) {
            ArrayList<Integer> current = graph.get(i);
            for (int a : current) {
                indegree[a]++;
            }
        }
    }

    static int indegree[];
    static int wt[];
    static int ans = Integer.MIN_VALUE;

    public static ArrayList<ArrayList<Integer>> constGraph(int n, int relations[][]) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < relations.length; i++) {
            graph.get(relations[i][0]).add(relations[i][1]);
        }
        return graph;
    }

}