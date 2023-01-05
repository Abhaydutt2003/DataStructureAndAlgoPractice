package dynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String [] args){
        int weight[] = {1,3,4,5};
        int values [] = {1,4,5,7};
        int W = 8;
        System.out.println(unKnapsackDp(weight,values,weight.length,W));
    }
    public static int unKnapsack(int weight[], int values[],int N, int W ){
        if(N == 0){
            return 0;
        }
        if(weight[N-1] <= W){
            int ans1  = unKnapsack(weight,values,N-1,W);
            int ans2 = unKnapsack(weight,values,N,W-weight[N-1])+values[N-1];
            return Math.max(ans1, ans2);
        }else{
            return unKnapsack(weight,values,N-1,W);
        }
    }
    public static int unKnapsackDp(int weight[], int values[],int N, int W){
        int t[][] = new int[weight.length+1][W+1];
        for(int i =1;i<weight.length+1;i++){
            for(int j = 1;j<W+1;j++){
                if(weight[i-1]<=j){
                    int ans1 = t[i-1][j];
                    int ans2 = t[i][j-weight[i-1]]+values[i-1];
                    t[i][j] = Math.max(ans1, ans2);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[weight.length][W];
    }

    
}
