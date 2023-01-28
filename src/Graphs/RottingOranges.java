package Graphs;
import java.util.*;
class pair{
    int i,j,distance;
    pair(int i, int j, int distance){this.i = i;this.j = j;this.distance = distance;}
}
public class RottingOranges {
    public static void main(String args[]){
        int[][] grid  = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(grid));
    }
    static int Ones = 0;
    static Queue<pair> rottenOranges = new LinkedList<pair>();
    static boolean visitedMatrix[][];
    public static int orangesRotting(int [][] grid){
        firstTraversal(grid);
        visitedMatrix = new boolean[grid.length][grid[0].length];
        int ans = dfs(grid);
        if(Ones == 0){return ans;}
        return -1;
    }
    //put the oranges in a queue to know the start of an infection...
    //also count the number of ones to know weather we will infect all the oranges or not
    private static void firstTraversal(int [][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    Ones++;
                }else if(grid[i][j] == 2){
                    rottenOranges.add(new pair(i,j,0));
                }
            }
        }
    }
    public static int dfs(int [][] grid){
        if(rottenOranges.isEmpty() == true){return 0;}
        int ans = Integer.MIN_VALUE;
        int xdir[] = {1,-1,0,0};
        int ydir[] = {0,0,-1,1};
        while(!rottenOranges.isEmpty()){
            pair current = rottenOranges.poll();
            int i = current.i;
            int j = current.j;
            ans = (ans>current.distance)?ans:current.distance;
            for(int a =0;a<xdir.length;a++){
                int x = xdir[a]+i;
                int y = ydir[a]+j;
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && (visitedMatrix[x][y]== false) && grid[x][y]!=2 && grid[x][y]!=0){
                    rottenOranges.add(new pair(x, y,current.distance+1));
                    visitedMatrix[x][y] = true;
                    Ones--;
                }
            }
        }
        return ans;
    }

}
