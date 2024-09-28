package backtracking;

public class WordSearch {

    public static void main(String args[]) {

    }

    static int[] xdir = { 1, -1, 0, 0 };
    static int[] ydir = { 0, 0, 1, -1 };

    public static boolean util1(char board[][], String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean smallAns = dfs(board, i, j, 0, word, new boolean[board.length][board[0].length]);
                    if (smallAns) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

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
