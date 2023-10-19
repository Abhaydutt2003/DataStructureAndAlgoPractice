package trees;

import java.util.*;

public class ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        int leftChild[] = { 1, 0, 3, -1 };
        int rightChild[] = { -1, -1, -1, -1 };
        System.out.println(util2(4, leftChild, rightChild));
    }

    // find root node , build graph , bfs
    public static boolean util2(int n, int leftChild[], int rightChild[]) {
        int in[] = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // fill the graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < leftChild.length; i++) {
            // indegree part
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
                graph.get(i).add(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
                graph.get(i).add(rightChild[i]);
            }
        }
        // traverse to know root
        int root = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                root = i;
                break;
            }
        }
        // no root found
        if (root == -1) {
            return false;
        }
        // run bfs and check if cycle exists
        return bfs(graph, root);
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        boolean visited[] = new boolean[graph.size()];
        for (; (q.isEmpty() == false);) {
            int current = q.poll();
            if (visited[current] == true) {
                // found cycle
                return false;
            }
            visited[current] = true;
            ArrayList<Integer> currentList = graph.get(current);
            for (int i : currentList) {
                q.add(i);
            }
        }
        // every node should be a part
        for (boolean a : visited) {
            if (!a) {
                return false;
            }
        }
        return true;
    }

    // fails
    public static boolean util1(int n, int[] leftChild, int[] rightChild) {
        int visited[] = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                visited[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                visited[rightChild[i]]++;
            }
        }
        // traverse the visited array
        boolean rootFound = false;
        for (int i : visited) {
            if (i == 0) {
                if (!rootFound) {
                    rootFound = true;
                } else {
                    return false;
                }
            } else if (i != 1) {
                return false;
            }
        }
        return rootFound;
    }
}