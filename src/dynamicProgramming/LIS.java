package dynamicProgramming;

import java.util.ArrayList;
public class LIS {
    public static void main(String args[]){
        //int arr[] = {10,9,2,5,3,7,101,18};
        int arr[] = {7,7,7,7,7,7,7};
        //LongestIncreasingRec(arr,arr.length-1);
        // int ans2 = currentLis(arr,4,3);
        System.out.print(LisBinarySearch(arr));
    }
    
    //recursive code...
    //takes 2 methods
    static int ans=Integer.MIN_VALUE;
    public static void LongestIncreasingRec(int arr[],int i){
        if(i == 0){return;}
        int currentAns = currentLis(arr,i-1,arr[i])+1;
        ans = (ans>currentAns)?ans:currentAns;
        LongestIncreasingRec(arr,i-1);
    }
    private static int currentLis(int arr[],int i,int a){
        if(i <0){
            return 0;
        }
        if(arr[i]<a){
            int ans1 = currentLis(arr,i-1,a);
            int ans2 = currentLis(arr, i-1,arr[i])+1;
            return Math.max(ans1, ans2);
        }else{
            return currentLis(arr,i-1,a);
        }
    }
    //dp code...time complexity O(n^2)..
    public static int lengthOfLIS(int[] nums){
        int dp [] = new int[nums.length+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int ans = 1;
        for(int i:dp){
            ans = (ans>i)?ans:i;
        }
        return ans;
    }

    //optimize lis even further, use binarySearch too..
    //time complexity O(n logn).
    public static int LisBinarySearch(int [] nums){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i:nums){
            int size = ans.size();
            if(size ==0 || (size>0 && ans.get(size-1)<i)){
                ans.add(i);
            }else{
                int insetionIndex = getInsetionIndex(ans,i);
                ans.set(insetionIndex,i);
            }
        }
        return ans.size();
    }
    private static int getInsetionIndex(ArrayList <Integer> arr, int i){
        int start = 0,end = arr.size()-1,res=0,mid=0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(arr.get(mid) ==i ){
                res = mid;
                break;
            }else if(arr.get(mid)<i){
                start = mid+1;
            }else{
                res = mid;
                end = mid-1;
            }
        }
        return res;
    }

}
