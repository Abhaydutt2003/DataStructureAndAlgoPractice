package graphs;

import java.util.*;

public class FlowerPlanting {

    public static void main(String args[]) {
        int paths[][] = {
                // { 1, 2 },
                // { 2, 3 },
                // { 3, 1 }
                { 3, 4 },
                { 4, 5 },
                { 3, 2 },
                { 5, 1 },
                { 1, 3 },
                { 4, 2 }

        };
        int n = 5;
        int ans[] = util3(n, paths);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    // wrong
    public static int[] util1(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = getAdj(n, paths);
        int colorArray[] = new int[n + 1];
        colorArray[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            int currentColour = colorArray[currentNode];
            ArrayList<Integer> currentList = adj.get(currentNode);
            int childColour = 1;
            for (Integer node : currentList) {
                if (colorArray[node] == 0) {
                    if (childColour != currentColour) {
                        colorArray[node] = childColour++;
                    } else {
                        colorArray[node] = ++childColour;
                        childColour++;
                    }
                    q.add(node);
                }
            }
        }
        return colorArray;
    }

    public static ArrayList<ArrayList<Integer>> getAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }
        return adj;
    }

    public static int[] util2(int n, int paths[][]) {
        ArrayList<ArrayList<Integer>> adj = getAdj(n, paths);
        colArray = new int[n + 1];
        for (int i = 1; i < colArray.length; i++) {
            if (colArray[i] == 0) {
                bfs(adj, i);
            }
        }
        int ans[] = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = colArray[i + 1];
        }
        return ans;
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int source) {
        colArray[source] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (Integer node : currentList) {
                if (colArray[node] == 0) {
                    boolean canPut[] = new boolean[5];
                    ArrayList<Integer> nodeList = adj.get(node);
                    for (Integer i : nodeList) {
                        canPut[colArray[i]] = true;
                    }
                    int toPut = 1;
                    for (int i = 1; i < canPut.length; i++) {
                        if (canPut[i] == false) {
                            toPut = i;
                            break;
                        }
                    }
                    colArray[node] = toPut;
                    q.add(node);
                }
            }
        }
    }

    static int colArray[];

    // code similar to mcolor problem
    // we think we will backtrack , but we will not ACTUALLY BACKTRACK!!(refer to
    // the question)

    static ArrayList<ArrayList<Integer>> ADJ;

    public static int[] util3(int n, int[][] paths) {
        ADJ = getAdj(n, paths);
        colArray = new int[n + 1];
        if (dfs(1, n) == false) {
            return new int[] { 0 };
        } else {
            int ans[] = new int[n];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = colArray[i + 1];
            }
            return ans;
        }
    }

    public static boolean dfs(int node, int n) {
        if (node == n + 1) {
            return true;
        }

        for (int i = 1; i <= 4; i++) {
            if (isValid(node, i)) {
                colArray[node] = i;
                boolean smallAns = dfs(node + 1, n);
                if (smallAns) {
                    return true;
                }
                colArray[node] = 0;// this condition can never occur
            }
        }
        return false;//this condition can never occur
    }

    public static boolean isValid(int node, int toGive) {
        ArrayList<Integer> currentList = ADJ.get(node);
        for (Integer neighbours : currentList) {
            if (colArray[neighbours] == toGive) {
                return false;
            }
        }
        return true;
    }

}
