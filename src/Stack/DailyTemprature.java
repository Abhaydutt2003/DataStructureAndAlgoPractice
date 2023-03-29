package StackAndQueues;

import java.util.*;

public class DailyTemprature {
    public static void main(String args[]) {
        int arr[] = {73,74,75,71,69,72,76,73};
        int ans[] = dailyTemperatures(arr);
        for(int i:ans){
            System.out.print(i+ " ");
        } 
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<Integer>();
        int ans[] = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            while(s.isEmpty() == false ){
                if(temperatures[s.peek()] < temperatures[i]){
                    ans[s.peek()] = i-s.pop();  
                }else{
                    break;
                }
            }
            s.push(i);
        }
        return ans;
    }

}
