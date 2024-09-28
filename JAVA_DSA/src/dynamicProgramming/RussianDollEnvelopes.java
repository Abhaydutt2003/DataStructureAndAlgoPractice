package dynamicProgramming;

import java.util.*;

public class RussianDollEnvelopes {
    public static void main(String args[]){
        int matrix[][] = {
            {5,4},
            {6,4},
            {6,7},
            {2,3}
        };
        System.out.println(envelopesBs(matrix));
    }
    //recursive , gives tle..
    public static int maxEnvelopes(int[][] envelopes){
        Arrays.sort(envelopes,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        findAnsRec(envelopes,0);
        return ans;
    }
    static int ans = Integer.MIN_VALUE; 
    public static void findAnsRec(int matrix[][], int i){
        if(i == matrix.length){
            return ;
        }
        int smallerAns = findSmallerEnvelopes(matrix,i-1,matrix[i])+1;
        ans = (ans>smallerAns)?ans:smallerAns;
        findAnsRec(matrix,i+1);
        return;
    }
    public static int findSmallerEnvelopes(int matrix[][], int i, int parent[]){
        if(i<0){return 0;}
        if(matrix[i][0]< parent[0] && matrix[i][1]<parent[1]){
            int ans1 = findSmallerEnvelopes(matrix,i-1,parent);
            int ans2 = findSmallerEnvelopes(matrix,i-1,matrix[i])+1;
            return Math.max(ans1, ans2);
        }else{
            return findSmallerEnvelopes(matrix,i-1,parent);
        }
    }
    //1-dp way.time complexity = O(n^2)..
    public static int envelopesMax(int [][] envelopes){
        Arrays.sort(envelopes,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int dp[] = new int[envelopes.length];
        int toReturn = 1;
        dp[0] = 1;
        for(int i = 1;i<envelopes.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            toReturn = (toReturn>dp[i])?toReturn:dp[i];
        }
        return toReturn;
    }
    //using binary search, O(n logn)
    public static int envelopesBs(int [][] envelopes){
        Arrays.sort(envelopes,(a,b) -> a[0] == b[0]?b[1]-a[1]:a[0]-b[0]);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(envelopes[0][1]);
        for(int i = 1;i<envelopes.length;i++){
            if(ans.get(ans.size()-1)<envelopes[i][1]){
                ans.add(envelopes[i][1]);
            }else{
                int insertionIndex = bs(ans,envelopes[i][1]);
                ans.set(insertionIndex,envelopes[i][1]);
            }
        }
        return ans.size();
    }
    private static int bs(ArrayList<Integer> ans, int x){
        int start = 0,end = ans.size()-1,mid=0,res=0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(ans.get(mid)==x){
                res=mid;break;
            }else if(ans.get(mid)<x){
                start=mid+1;
            }else{
                res=mid;
                end = mid-1;
            }
        }
        return res;
    }
}
