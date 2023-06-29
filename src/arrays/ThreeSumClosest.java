package arrays;

import java.util.*;
public class ThreeSumClosest {

    public static void main(String args[]) {
        int arr[] = {4,0,5,-5,3,3,0,-4,-5};
        int ans = util1(arr,-2);
        System.out.print(ans);
    }

    public static int util1(int arr[], int target) {
        Arrays.sort(arr);
        // for(int i:arr){
        //     System.out.print(i+" ");
        // }System.out.println();
        int minDistance = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k) {
                    int currentSum = arr[i] + arr[j] + arr[k];
                    //System.out.println(arr[i] +" "+ arr[j] +" "+ arr[k]);
                    if (currentSum == target) {
                        return currentSum;
                    }
                    int currDistance = Math.abs(target - currentSum);
                    if (currDistance < minDistance) {
                        minDistance = currDistance;
                        ans = currentSum;
                    }
                    if (currentSum < target) {
                        while (j < k && arr[j] == arr[j + 1])
                            j++;
                        j++;
                    } else {
                        while (k > i && arr[k] == arr[k - 1])
                            k--;
                        k--;
                    }
                }System.out.println("new i");
            }
        }
        return ans;
    }

}
