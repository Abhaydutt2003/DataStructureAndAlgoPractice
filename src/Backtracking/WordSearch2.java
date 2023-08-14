package backTracking;

import java.util.*;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class WordSearch2 {

    public static void main(String args[]) {
        char board[][] = {
                { 'a', 'b', 'c' },
                { 'a', 'e', 'd' },
                { 'a', 'f', 'g' }
        };
        String words[] = { "abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade" };
        List<String> ans = util2(board, words);
        for (String str : ans) {
            System.out.print(str + " ");
        }
    }

    // very epic trie solution
    public static List<String> util2(char[][] matrix, String words[]) {
        TrieNode root = buildTrie(words);
        ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, i, j, root);
            }
        }
        return ans;
    }

    static List<String> ans;

    // dfs
    public static void dfs(char[][] matrix, int i, int j, TrieNode root) {
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        char ch = matrix[i][j];
        if (ch == '!' || root.next[ch - 'a'] == null) {
            return;
        }
        root = root.next[ch - 'a'];
        matrix[i][j] = '!';
        for (int a = 0; a < xdir.length; a++) {
            int x = i + xdir[a];
            int y = j + ydir[a];
            dfs(matrix, x, y, root);
        }
        matrix[i][j] = ch;
    }

    // build trie
    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            char[] arr = word.toCharArray();
            for (char ch : arr) {
                int node = ch - 'a';
                if (current.next[node] == null) {
                    current.next[node] = new TrieNode();
                }
                current = current.next[node];
            }
            current.word = word;
        }
        return root;
    }

    // tle
    public static List<String> util1(char[][] matrix, String words[]) {
        // get all letters

        HashMap<Character, ArrayList<int[]>> hm = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hm.containsKey(matrix[i][j])) {
                    ArrayList<int[]> currentList = hm.get(matrix[i][j]);
                    currentList.add(new int[] { i, j });
                } else {
                    ArrayList<int[]> currentList = new ArrayList<>();
                    currentList.add(new int[] { i, j });
                    hm.put(matrix[i][j], currentList);
                }
            }
        }

        // now running dfs for every word

        for (String str : words) {
            if (hm.containsKey(str.charAt(0))) {
                ArrayList<int[]> currList = hm.get(str.charAt(0));
                for (int[] a : currList) {
                    int i = a[0];
                    int j = a[1];
                    boolean b = dfs(matrix, i, j, 0, str, new boolean[matrix.length][matrix[0].length]);
                    if (b) {
                        ans.add(str);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    static int[] xdir = { 1, -1, 0, 0 };
    static int[] ydir = { 0, 0, 1, -1 };

    public static boolean dfs(char[][] matrix, int i, int j, int index, String str, boolean visited[][]) {
        if (index >= str.length()) {
            return true;
        }
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || visited[i][j] == true
                || str.charAt(index) != matrix[i][j]) {
            return false;
        }
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = i + xdir[a];
            int y = j + ydir[a];
            boolean smallAns = dfs(matrix, x, y, index + 1, str, visited);
            if (smallAns) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
