package StackAndQueues;

import java.util.*;

public class MaxWidthRamp {

    public static void main(String args[]) {
        int arr[] = { 2, 1, 3 };
        System.out.print(util1(arr));
    }

    public static int util1(int arr[]){
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            if(s.isEmpty()){
                s.push(i);
            }else if(arr[i]<arr[s.peek()]){
                s.push(i);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = arr.length-1;i>=0;i--){
            while(s.isEmpty() == false && arr[s.peek()]<=arr[i]){
                ans = Math.max(ans,i-s.pop());
            }
        }
        return ans;
    }
    

    // public static int util1(int[] nums) {
    //     int prevMin = Integer.MAX_VALUE;
    //     int ans = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] < prevMin) {
    //             int farthestGreater = bs(nums, i + 1, nums[i]);
    //             System.out.println(farthestGreater);
    //             ans = Math.max(ans, (farthestGreater - i));
    //             prevMin = nums[i];
    //         }
    //     }
    //     return ans;
    // }

    // public static int bs(int[] arr, int start, int k) {
    //     int end = arr.length - 1, mid = 0, res = -1;
    //     while (start <= end) {
    //         mid = start + (end - start) / 2;
    //         if (arr[mid] >= k) {
    //             res = mid;
    //             start = mid + 1;
    //         } else {
    //             end = mid - 1;
    //         }
    //     }
    //     return res;
    // }

}
