package dynamicProgramming;

public class UniquePaths {

    public static void main(String args[]){

    }


    public static int util1(int m , int n){
        int grid[][] = new int[m][n];
        grid[0][0] = 1;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i-1 >=0){
                    grid[i][j]+=grid[i-1][j];
                }
                if(j-1>=0){
                    grid[i][j]+=grid[i][j-1];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1]; 
    }
    
}
