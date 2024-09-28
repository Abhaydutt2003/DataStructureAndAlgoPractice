package graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        char matrix[][] = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.print(numIslands(matrix));
    }

    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ( grid[i][j] == '1' && visited[i][j] != true) {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static boolean visited[][];

    private static void bfs(char[][] grid, int i, int j) {
        if(grid[i][j] == '0'){return;}
        visited[i][j] = true;
        int xdir[] ={1,-1,0,0};
        int ydir[] = {0,0,1,-1};
        for(int a = 0;a<xdir.length;a++){
            int x = xdir[a]+i;
            int y = ydir[a]+j;
            if(x<grid.length && x>=0 && y< grid[0].length && y>=0 && visited[x][y]!=true){
                bfs(grid,x,y);
            }
        }
        return; 
    }

}
