package dynamicProgramming;

import java.util.PriorityQueue;

public class SuperUglyNumber {
    public static void main(String args[]){
        int n =30;
        int primes[] = {3,5,13,19,23,31,37,43,47,53};
        System.out.println(util3(n,primes));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
        ans.add(1);
        for(int i =1;i<=n-1;i++){
            int current = ans.poll();
            for(int j = 0;j<primes.length;j++){
                if(ans.contains(current*primes[j]) == false){
                    ans.add(current*primes[j]);
                }
            }
        }
        return ans.poll();
    }
    public static int util1(int n,int primes[]){
        PriorityQueue<Long> ans = new PriorityQueue<>();
        ans.add(1l);
        for(int i= 1;i<n;i++){
            long current = ans.poll();
            while((ans.isEmpty() == false) && current == ans.peek()){
                ans.poll();
            }
            for(int j = 0;j<primes.length;j++){
                ans.add(primes[j]*current);
            }
        }
        return ans.poll().intValue();
    }
    public static int util3(int n, int primes[]){
        long dp [] = new long[n+1];
        int indexTrack[] = new int[primes.length];
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j<primes.length;j++){
                dp[i] = Math.min(dp[i],dp[indexTrack[j]]*primes[j]);
            }
            for(int j = 0;j<primes.length;j++){
                if(dp[i] == dp[indexTrack[j]]*primes[j]){
                    indexTrack[j]++;
                }
            }
        }
        return (int)dp[n-1];
    }
    
}
