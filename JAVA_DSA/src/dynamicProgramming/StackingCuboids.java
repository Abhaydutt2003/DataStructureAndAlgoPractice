package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class StackingCuboids {
    public static void main(String args[]){
        int matrix[][] = {
            {50,45,20},
            {95,37,53},
            {45,23,12}
        };
        System.out.println(maxHeight(matrix));
    }
    public static int maxHeight(int[][] cuboids){
        for(int[] a : cuboids){
            Arrays.sort(a);
        }
        Arrays.sort(cuboids,new Comparator<>() {
            @Override
            public int compare(int a[], int b[]){
                if(a[2]!=b[2]){
                    return a[2]-b[2];
                }else if(a[1]!=b[1]){
                    return a[1]-b[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });
        int dp[] = new int[cuboids.length];
        dp[0] = cuboids[0][2];
        int res = dp[0];
        for(int i = 1;i<cuboids.length;i++){
            dp[i] = cuboids[i][2];
            for(int j=i-1;j>=0;j--){
                if(isStackable(cuboids,i,j)){
                    dp[i] = Math.max(dp[i],cuboids[i][2]+dp[j]);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
    private static boolean isStackable(int cuboid[][], int i, int j){
        if(cuboid[j][0]<=cuboid[i][0] &&
           cuboid[j][1]<=cuboid[i][1] && 
           cuboid [j][2]<=cuboid[i][2])
           return true;

           return false;
    }
}
