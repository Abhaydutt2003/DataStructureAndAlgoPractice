package dynamicProgramming;

public class RemoveBoxes {

    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
        System.out.print(util1(arr));
    }

    static int dp[][][];

    public static int util1(int[] boxes) {
        // return recHelper(boxes, 0, boxes.length - 1,0);
        dp = new int[boxes.length][boxes.length][boxes.length];
        return helper(boxes, 0, boxes.length - 1, 0);
    }

    public static int helper(int arr[], int i, int j, int prevRemoved) {
        if (i > j) {
            return 0;
        }
        int tempi = i, tempPrev = prevRemoved;
        if (dp[i][j][prevRemoved] != 0) {
            return dp[i][j][prevRemoved];
        }
        while (i < j && arr[i] == arr[i + 1]) {
            prevRemoved++;
            i++;
        }
        int ans = ((prevRemoved + 1) * (prevRemoved + 1)) + helper(arr, i + 1, j, 0);
        for (int k = i + 1; k <= j; k++) {
            if (arr[i] == arr[k]) {
                int smallAns = helper(arr, i + 1, k - 1, 0) + helper(arr, k, j, prevRemoved + 1);
                ans = Math.max(ans, smallAns);
            }
        }
        dp[tempi][j][tempPrev] = ans;
        return ans;
    }

    // correct recursive function
    public static int recHelper(int[] arr, int i, int j, int prevRemoved) {
        if (i > j) {
            return 0;
        }
        while (i < j && arr[i] == arr[i + 1]) {
            i++;
            prevRemoved++;
        }
        int ans = recHelper(arr, i + 1, j, 0) + ((prevRemoved + 1) * (prevRemoved + 1));
        for (int k = i + 1; k <= j; k++) {
            if (arr[i] == arr[k]) {
                int smallAns = recHelper(arr, i + 1, k - 1, 0) + recHelper(arr, k, j, prevRemoved + 1);
                ans = Math.max(ans, smallAns);
            }
        }
        return ans;
    }

    // failed attempt..
    public static int helper(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int amtRemoved = 1;
        int start = i;
        while (start <= j) {
            int end = start;
            while ((end + 1 < j) && arr[end] == arr[end + 1]) {
                end++;
                amtRemoved++;
            }
            if (i == 0 && j == arr.length - 1) {
                System.out.println(end + 1 + " " + j + " " + i + " " + (start - 1));
            }
            int smallAns = helper(arr, end + 1, j) + helper(arr, i, start - 1) + (amtRemoved * amtRemoved);
            ans = Math.max(ans, smallAns);
            start++;
        }
        return ans;
    }

}
