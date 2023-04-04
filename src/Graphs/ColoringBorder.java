package Graphs;

public class ColoringBorder {

    public static void main(String args[]) {
        int grid[][] = {
                // { 1, 1, 1, 1, 1 },
                // { 1, 2, 2, 2, 1 },
                // { 1, 2, 2, 2, 1 },
                // { 1, 2, 2, 2, 1 },
                // { 1, 1, 1, 1, 1 }

                // { 1, 1, 1 },
                // { 1, 1, 1 },
                // { 1, 1, 1 }

                { 1, 2, 2 },
                { 2, 3, 2 }

        };
        visited = new boolean[grid.length][grid[0].length];
        theColor = 3;
        dfs(grid, 0, 1, grid[0][1]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean visited[][];
    static int[] xdir = { 1, -1, 0, 0 };
    static int[] ydir = { 0, 0, 1, -1 };
    static int theColor;

    public static void dfs(int[][] grid, int i, int j, int originalColor) {
        if (grid[i][j] != originalColor) {
            return;
        }
        visited[i][j] = true;
        boolean isBorder = checkBorder(grid, i, j, originalColor);
        // completing the traversal part
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && visited[x][y] == false) {
                dfs(grid, x, y, originalColor);
            }
        }
        if (isBorder) {
            grid[i][j] = theColor;
        }
    }

    private static boolean checkBorder(int[][] grid, int i, int j, int originalColor) {
        if (i - 1 < 0 || grid[i - 1][j] != originalColor) {
            return true;
        }
        if (i + 1 >= grid.length || grid[i + 1][j] != originalColor) {
            return true;
        }
        if (j - 1 < 0 || grid[i][j - 1] != originalColor) {
            return true;
        }
        if (j + 1 >= grid[0].length || grid[i][j + 1] != originalColor) {
            return true;
        }
        return false;
    }
}
