package backTracking;

public class MaxTransferRequests {

    public static void main(String args[]) {
        int matrix[][] = {
                { 0, 1 },
                { 1, 0 },
                { 0, 1 },
                { 1, 2 },
                { 2, 0 },
                { 3, 4 }
        };
        int n = 5;
        System.out.print(util1(n, matrix));
    }

    static int houses[];

    public static int util1(int n, int requests[][]) {
        houses = new int[n];
        helper(requests, 0, 0);
        return ans;
    }

    static int ans = 0;

    public static void helper(int[][] requests, int i, int requestsHandled) {
        if (i == requests.length) {
            for (int a : houses) {
                if (a != 0) {
                    return;
                }
            }
            ans = Math.max(ans, requestsHandled);
            return;
        }
        int leaveFrom = requests[i][0];
        int joinTo = requests[i][1];
        houses[leaveFrom]--;
        houses[joinTo]++;
        helper(requests, i + 1, requestsHandled + 1);
        houses[leaveFrom]++;
        houses[joinTo]--;
        helper(requests, i + 1, requestsHandled);
    }

}