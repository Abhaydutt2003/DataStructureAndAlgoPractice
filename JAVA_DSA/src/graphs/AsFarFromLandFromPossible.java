package graphs;

import java.util.*;
public class AsFarFromLandFromPossible {
    public static void main(String agrs[]){
        int matrix[][] = {
            // {1,0,1},
            // {0,0,0},
            // {1,0,1}
            {1,0,0,0,0},
            {0,0,0,0,1},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,1,0,0,0}
        };
        System.out.println(maxDistance(matrix));
    }
    static Queue<pair> helper = new LinkedList<pair>();
    static boolean visitedMatrix[][]; 
    static boolean containsZero = false;
    static boolean containsOne = false;
    //in simple words we have to find the 0 whose nearest 1 has the maximum distance.
    public static int maxDistance(int [][] grid){
        // to find all the Ones..
        firstTraversal(grid);
        visitedMatrix = new boolean[grid.length][grid[0].length];
        //get the answer by applying bfs on each 1, the last 0 to be reached will be the answer..
        if(containsOne == false || containsZero == false){return -1;}
        int ans = bfs(grid);
        return ans;
    }
    public static void firstTraversal(int[][] grid){
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    helper.add(new pair(i,j,0));
                    containsOne = true;
                }else{
                    containsZero=true;
                }
            }
        }
    }
    public static int bfs(int[][] grid){
        int ans = Integer.MIN_VALUE;
        while(true){
            pair current = helper.poll();
            int xdir[] = {0,0,1,-1};
            int ydir[] = {1,-1,0,0};
            for(int a = 0;a<xdir.length;a++){
                int x = current.i+xdir[a];
                int y = current.j+ydir[a];
                if((x>=0 && y>=0) && (x<grid.length && y<grid[0].length) && (!visitedMatrix[x][y]) && (grid[x][y] != 1)){
                    helper.add(new pair(x,y,current.distance+1));
                    visitedMatrix[x][y] = true;
                }
            }
            if(helper.isEmpty()){
                int candidate = Math.max(ans,current.distance+1);
                ans = (ans>candidate)?ans:candidate;
                break;
            }
        }
        return ans-1;
    }
}
