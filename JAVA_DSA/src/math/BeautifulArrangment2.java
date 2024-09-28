package math;

//import java.util.*;

public class BeautifulArrangment2 {

    public static void main(String args[]) {
        int arr[] = util1(6, 4);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // pure greedy
    public static int[] util1(int n, int k) {
        int left = 1, right = n;
        int ans[] = new int[n];
        int a = 0;
        while (k != 1) {
            if (a % 2 == 0) {
                ans[a] = right;
                right--;
            } else {
                ans[a] = left;
                left++;
            }
            a++;
            k--;
        }

        if (a % 2 == 0) {
            while (right >= left) {
                ans[a] = right;
                right--;
                a++;
            }
        } else {
            while (right >= left) {
                ans[a] = left;
                left++;
                a++;
            }
        }
        return ans;
    }

    // static HashMap<Integer,Integer> hm;
    // static boolean visited[];

    // public static int[] util1(int n, int k){
    // visited = new boolean [n+1];
    // hm = new HashMap<>();
    // List<Integer> l = helper();
    // int a = 0;
    // int ans[] = new int[n];
    // for(int i:l){
    // ans[a++]= i;
    // }
    // return ans;
    // }

}
