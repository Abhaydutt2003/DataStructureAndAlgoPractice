package greedy;

public class JumpGame {

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 0, 2 };
        System.out.print(util2(arr));
    }

    public static boolean util1(int arr[]) {
        boolean dp[] = new boolean[arr.length];
        dp[arr.length - 1] = true;
        for (int i = arr.length - 2; i >= 0; i--) {
            boolean toPut = false;

            // checking if the current element can reach a valid index
            int limitIndex = i + arr[i];
            for (int a = i + 1; (a < dp.length) && (a <= limitIndex); a++) {
                if (dp[a]) {
                    toPut = true;
                    break;
                }
            }
            dp[i] = toPut;
        }
        return dp[0];
    }

    //expand boundry solution.
    public static boolean util2(int arr[]){
        int currentBoundry = 0;
        for(int i = 0;i<=currentBoundry;i++){
            currentBoundry = Math.max(currentBoundry,arr[i]+i);
            if(currentBoundry>= arr.length-1){
                return true;
            }
        }
        return false;
    }

    // public static boolean util1(int arr[], int i) {
    // if (i == arr.length - 1) {
    // return true;
    // }
    // int jump = getJump(arr, i);
    // if (jump == i) {
    // return false;
    // }
    // return util1(arr, jump);
    // }

    // public static int getJump(int arr[], int i) {
    // int jumpAmt = arr[i];
    // int index = i + jumpAmt;
    // while (index != i) {
    // if (index < arr.length && arr[index] != 0) {
    // return index;
    // } else {
    // index--;
    // }
    // }
    // return index;
    // }

}
