package graphs;

import java.util.*;

public class restoreArrayFromAdjacent {

    public static void main(String args[]) {
        int matrix[][] = {
            {4,-2},
            {1,4},
            {-3,1}
        };
        int ans[] = util1(matrix);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    public static int[] util1(int[][] matrix) {
        HashMap<Integer, ArrayList<Integer>> adj = constAdj(matrix);
        int[] ans = dfsCaller(adj);
        return ans;
    }

    private static HashMap<Integer, ArrayList<Integer>> constAdj(int[][] matrix) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int[] edge : matrix) {
            if (adj.containsKey(edge[0]) == false) {
                adj.put(edge[0], new ArrayList<Integer>());
            }
            adj.get(edge[0]).add(edge[1]);
            if (adj.containsKey(edge[1]) == false) {
                adj.put(edge[1], new ArrayList<Integer>());
            }
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    static Set<Integer> visited;
    static ArrayList<Integer> ansList;

    private static int[] dfsCaller(HashMap<Integer, ArrayList<Integer>> adj) {
        visited = new HashSet<>();
        ansList = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : adj.entrySet()) {
            int currentVertex = entry.getKey();
            ArrayList<Integer> currentList = entry.getValue();
            if (currentList.size() == 1) {
                dfs(currentVertex, adj);
                break;
            }
        }
        int ans[] = new int[ansList.size()];
        int k = 0;
        for (int i : ansList) {
            ans[k++] = i;
        }
        return ans;
    }

    private static void dfs(int currentVertex, HashMap<Integer, ArrayList<Integer>> adj) {
        ansList.add(currentVertex);
        visited.add(currentVertex);
        ArrayList<Integer> currentList = adj.get(currentVertex);
        for (int i : currentList) {
            if (visited.contains(i) == false) {
                dfs(i, adj);
            }
        }
    }
}
