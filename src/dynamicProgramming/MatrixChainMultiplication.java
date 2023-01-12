package dynamicProgramming;

public class MatrixChainMultiplication {
    public static void main(String args[]){
        int arr[] = {40,20,30,10,30};
        System.out.print(mcm(arr));
    }
    public static int mcm(int arr[]){
        int i = 1,j = arr.length-1;
        int memo[][] = new int [arr.length+1][arr.length+1];
        for(int a = 0;a<memo.length;a++){
            for(int b = 0;b<memo[0].length;b++){
                memo[a][b] = -1;
            }
        }
        int ans = helperMemo(arr,i,j,memo);
      //  int ans = helper(arr,i,j);
        return ans;
    }
    public static int helper(int arr[], int i, int j){
        if(i>=j){return 0;}
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ans1 = helper(arr,i,k);
            int ans2 = helper(arr,k+1,j);
            int current = ans1+ans2+(arr[i-1]*arr[k]*arr[j]);
            ans =(ans>current)?current:ans;
        }
        return ans;
    }
    public static int helperMemo(int arr[], int i, int j, int[][] memo){
        if(i>=j){return 0;}
        if(memo[i][j]!=-1){return memo[i][j];}
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ans1 = helperMemo(arr,i,k,memo);
            int ans2 = helperMemo(arr,k+1,j,memo);
            int current = ans1+ans2+(arr[i-1]*arr[k]*arr[j]);
            ans =(ans>current)?current:ans;
        }
        memo[i][j] = ans;
        return ans;
    }
    // cost = matrix1 = 20*30, matrix2 = 30*10 , cost = 20*30*10.
    //the new dimension = matrix1 = 20*30, matrix2 = 30*10 , new = 20*10...


}
