package stackAndQueue;

import java.util.*;
public class NextGreaterElement2 {

    public static void main(String args[]){
        int arr[] = {1,2,3,4,3};
        int ans[] = nextGreaterElements(arr);
        for(int a:ans){
            System.out.println(a+" ");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        // int traversalNumber = 1;
        // int maximumNumberIndex = 0;
        // Stack<Integer> s = new Stack<Integer>();
        // HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        // int i = 0;
        // while(){
        //     if(i == nums.length){
        //         traversalNumber++;
        //     }
        //     if(nums[maximumNumberIndex]<nums[i]){
        //         maximumNumberIndex=i;
        //     }
        //     int current = nums[i];
        //     if(traversalNumber == 1){
        //         while((s.isEmpty() == false) && nums[s.peek()]<current){
        //             hm.put(s.peek(),current);
        //         }
        //     }else{
        //     }
        // }
        int traversalNumber = 1;
        int largestIndex = 0;
        int i = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        Stack<Integer> s = new Stack<Integer>();
        while(traversalNumber == 1){
            if(i == nums.length){
                traversalNumber=2;
                continue;
            }
            if(nums[i]>nums[largestIndex]){
                largestIndex=i;
            }
            while((s.isEmpty() == false) && (nums[s.peek()]<nums[i])){
                hm.put(s.pop(),nums[i]);
            }
            s.push(i);
            i++;
        }
        i=0;
        while(i<=largestIndex){
            while((s.isEmpty() == false) && (nums[s.peek()] < nums[i])){
                hm.put(s.pop(),nums[i]);
            }
            i++;
        }

        int ans[] = new int[nums.length];
        for(int a = 0;a<nums.length;a++){
            if(hm.containsKey(a)){
                ans[a] =hm.get(a);
            }else{
                ans[a] = -1;
            }
        }
        return ans;
    }
}
