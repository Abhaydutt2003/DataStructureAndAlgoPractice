package arrays;

public class MaximumSumCircularSubarray {
    public static void main(String args[]){
        int arr[] = {-3,-2,-3};
        System.out.println(maxCircularSubarray(arr));
        // System.out.println(kadane(arr));
    }

    //failed approach..
    public static int maxSubarraySumCircular(int[] nums) {
        int traversalNumber = 1;
        int i = 0;
        int ans = Integer.MIN_VALUE;
        while(traversalNumber == 1 && i<nums.length){
            int startIndex = i;
            int sum = 0;
            while(sum != -1){
                System.out.println(sum+" "+i);
                if(traversalNumber == 2 && i == startIndex){
                    return ans;
                }
                sum+=nums[i];
                i++;
                if(i == nums.length){
                    i=0;
                    traversalNumber++;
                }
                ans = Math.max(sum,ans);
            }
            sum=0;
            i++;
        }
        return ans;
    }
    
    public static int maxCircularSubarray(int [] nums){
        int ans1 = kadane(nums);
        int ArraySum = 0;
        for(int i=0;i<nums.length;i++){
            ArraySum+=nums[i];
            nums[i] = nums[i]* -1;
        }
        int minimumSubarray = kadane(nums);
        minimumSubarray = minimumSubarray*-1;
        int ans2 = ArraySum-minimumSubarray;
        if(ans2 == 0){return ans1;}
        return Math.max(ans1,ans2);
    }
    public static int kadane(int nums[]){
        int ans = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i:nums){
            currentSum+=i;
            if(currentSum>ans){
                ans = currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return ans;
    }
    
}
