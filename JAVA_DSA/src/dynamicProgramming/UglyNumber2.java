package dynamicProgramming;

import java.util.*;
public class UglyNumber2 {
    public static void main(String args[]){
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n){
        return util2(n);
    }
    public static int util1(int n){
        PriorityQueue<Long> ans =new PriorityQueue<Long>();
        ans.add(1l);
        for(int i = 1;i<=n-1;i++){
            Long current = ans.poll();
            if(ans.contains(current*2) == false){
                ans.add(current*2);
            }
            if(ans.contains(current*3) == false){
                ans.add(current*3);
            }
            if(ans.contains(current*5) == false){
                ans.add(current*5);
            }
        }
        return ans.poll().intValue();
    }
    public static int util2(int n){
        int dp []= new int[n+1];
        dp[0] = 1;
        int j2 = 0,j3=0,j5=0;
        for(int i = 1;i<dp.length;i++){
            dp[i] = Math.min(dp[j2]*2,Math.min(dp[j3]*3,dp[j5]*5));
            if(dp[i] == dp[j2]*2){j2++;}
            if(dp[i] == dp[j3]*3){j3++;}
            if(dp[i] == dp[j5]*5){j5++;}
        }
        return dp[n-1];
    }
}
