package dynamicProgramming;

public class RodCuttingGFG {
    public static void main(String args[]){
        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(tabulation(price,n));
    }
    public static int cutRod(int price[], int n){
        int arr[] = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i+1;
        }
        int memo[][] = new int[n+1][n+1];
        for(int i =0;i<memo.length;i++){
            for(int j =0;j<memo[0].length;j++){
                memo[i][j] = -1;
            }
        }
        int ans = helperMemo(price,arr,n,n,memo);
        return ans;
    }
    public static int helper(int price[],int length[],int len, int N ){
        if(N == 0){return 0;}
        if(len>=length[N-1]){
            int ans1 = helper(price,length,len,N-1);
            int ans2 = helper(price,length,len-length[N-1],N)+price[N-1];
            return Math.max(ans1, ans2);
        }else{
            return helper(price,length,len,N-1);
        }
    }
    public static int helperMemo(int price[],int length[],int len, int N, int memo[][]){
        if(len<=0){return 0;}
        if(N == 0){return 0;}
        if(memo[N][len]!=-1){return memo[N][len];}
        if(len>=length[N-1]){
            int ans1 = helperMemo(price,length,len,N-1,memo);
            int ans2 = helperMemo(price,length,len-length[N-1],N,memo)+price[N-1];
            return memo[N][len] = Math.max(ans1, ans2);
        }else{
            return memo[N][len] = helperMemo(price,length,len,N-1,memo);
        }
    }
    //what are the 2 things that are changing??
    //n and the length of the rod...
    public static int tabulation(int price[], int n){
        int cut[] =new int[n+1];
        for(int i =0;i<cut.length;i++){
            cut[i] = i+1;
        } 
        int t[][] = new int[n+1][n+1];
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                if(cut[i-1]<=j){
                    int ans1 = t[i-1][j];
                    int ans2 =t[i][j-cut[i-1]]+price[i-1];
                    t[i][j] = Math.max(ans1, ans2);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][n];
    }
    
}
