package greedy;

public class GasStation {

    public static void main(String args[]) {
        int gas[] = { 2, 3, 4 };
        int cost[] = { 3, 4, 3 };
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int traversalNumber = 1;
        int i = 0, gasInTank = 0;
        while (traversalNumber == 1 && i < gas.length) {
            int currentCandidate = i;
            gasInTank += gas[i];
            while (gasInTank >= cost[i]) {
                if (traversalNumber == 2 && i == currentCandidate) {
                    return currentCandidate;
                }
                gasInTank -= cost[i];
                i++;
                if (i == gas.length) {
                    i = 0;
                    traversalNumber++;
                }
                gasInTank += gas[i];
            }
            gasInTank = 0;
            i++;
        }
        return -1;
    }
}
