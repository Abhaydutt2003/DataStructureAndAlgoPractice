package stackAndQueue;

import java.util.*;
public class NextGreaterElement1 {

    public static void main(String args[]){
        int arr1[] = {2,4};
        int arr2[] = {1,2,3,4};
        int ans[] = util2(arr1,arr2);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    //O(n^2)
    public static int[] util1(int arr1[], int arr2[]){
        int ans[] = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            int toPut = -1;
            for(int j=arr2.length-1;j>=0;j--){
                if(arr2[j] == arr1[i]){
                    break;
                }
                if(arr2[j]>arr1[i]){
                    toPut = arr2[j];
                }
            }
            ans[i] = toPut;
        }
        return ans;
    }

    //O(n)
    public static int[] util2(int arr1[], int arr2[]){
        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0;i<arr2.length;i++){
            while(s.isEmpty() == false){
                if(s.peek()<arr2[i]){
                    hm.put(s.pop(),arr2[i]);
                }else{
                    break;
                }
            }
            s.push(arr2[i]);
        }
        int ans[] = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            if(hm.containsKey(arr1[i])){
                ans[i] = hm.get(arr1[i]);
            }else{
                ans[i] = -1;
            }
        }
        return ans;
    }
    
}
