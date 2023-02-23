package dynamicProgramming;

import java.util.*;

class Job{
    int startTime;
    int endTime;
    int profit;
    Job(int a, int b, int c){
        this.startTime=a;
        this.endTime=b;
        this.profit=c;
    }
    int getStartTime() {
        return startTime;
    }
    int getEndTime(){
        return endTime;
    }
    int getProfit(){
        return profit;
    }
}
public class MaximumProfitInJob {
    public static void main(String args[]){
        int startTimes[] = {1,2,3,4,6};
        int endTimes[] = {3,5,10,6,9};
        int profits[] = {20,20,100,70,60};
        System.out.println(jobScheduling3(startTimes,endTimes,profits));
    }
    //1-d dp , time complexity O(n^2).
    public static int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        Job[] allJobs = new Job[startTime.length];
        for(int i = 0;i<allJobs.length;i++){
            Job toPut = new Job(startTime[i],endTime[i],profit[i]);
            allJobs[i] = toPut;
        }
        Arrays.sort(allJobs,(a,b) -> a.getStartTime() == b.getStartTime()? a.getEndTime()-b.getEndTime():a.getStartTime()-b.getStartTime());
        int dp[] = new int[startTime.length];
        int ans = 0;
        dp[0] = allJobs[0].profit;
        for(int i = 1;i<dp.length;i++){
            dp[i] = allJobs[i].profit;
            for(int j = i-1;j>=0;j--){
                if(allJobs[j].getEndTime() <= allJobs[i].getStartTime()){
                    dp[i] = Math.max(dp[i],dp[j]+allJobs[i].getProfit());
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public static int jobScheduling2(int[] startTime, int[] endTime, int[] profit){
        Job[] allJobs = new Job[startTime.length];
        for(int i = 0;i<allJobs.length;i++){
            Job toPut = new Job(startTime[i],endTime[i],profit[i]);
            allJobs[i] = toPut;
        }
        Arrays.sort(allJobs,(a,b) -> a.getEndTime() == b.getEndTime() ? a.getStartTime()-b.getStartTime():a.getEndTime()-b.getEndTime());
        int dp[] = new int[startTime.length];
        dp[0] = allJobs[0].getProfit();
        for(int i = 1;i<dp.length;i++){
            dp[i] =Math.max(dp[i-1],allJobs[i].getProfit());
            for(int j = i-1;j>=0;j--){
                if(allJobs[j].getEndTime()<= allJobs[i].getStartTime()){
                    dp[i] = Math.max(dp[i],allJobs[i].getProfit()+dp[j]);
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    // method 2 from here..(similar to knapsack)
    public static int jobScheduling3(int[] startTime, int[] endTime, int[] profit){
        Job[] allJobs = new Job[startTime.length];
        for(int i = 0;i<allJobs.length;i++){
            Job toPut = new Job(startTime[i],endTime[i],profit[i]);
            allJobs[i] = toPut;
        }
        Arrays.sort(allJobs,(a,b) -> a.getStartTime() == b.getStartTime()? a.getEndTime()-b.getEndTime():a.getStartTime()-b.getStartTime());
        dp = new int[startTime.length+1];
        for(int i = 0;i<dp.length;i++){dp[i] = -1;}
        return recursiveUtil(allJobs,0);
    }
    static int dp[];
    public static int recursiveUtil(Job[] allJobs, int i){
        if(i>=allJobs.length){return 0;}
        if(dp[i]!=-1){return dp[i];}
        //to include
        int nextIndex = getIndexBs(allJobs,i);
        int include = allJobs[i].getProfit();
        if(nextIndex!=-1){
            include += recursiveUtil(allJobs,nextIndex);
        }
        //or not to include
        int exclude = recursiveUtil(allJobs,i+1);
        return dp[i] = Math.max(include, exclude);
    }
    public static int getIndex(Job[] allJobs,int i){
        for(int a = i+1;a<allJobs.length;a++){
            if(allJobs[a].getStartTime()>=allJobs[i].getEndTime()){
                return a;
            }
        }
        return -1;
    }
    public static int getIndexBs(Job [] allJobs, int i){
        int start = i+1,end = allJobs.length-1,mid=0,res=-1;
        while(start<=end){
            mid = start+(end-start)/2;
            if(allJobs[mid].getStartTime()>=allJobs[i].getEndTime()){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }

}
