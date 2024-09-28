package dynamicProgramming;

public class StoneGame1 {

    public static void main(String args[]) {
        int arr[] = { 3, 7, 2, 3 };
        System.out.print(util1(arr));
    }

    public static boolean util1(int[] piles) {
        // return helper(piles, 0, piles.length - 1, 0, 0, true);
        return helper3(piles);
    }

    // what the hell is this question???
    // see alex plays optimally, so alex will always pick the one in which bob
    // looses

    public static boolean helper2(int piles[]) {
        return true;
    }

    // for better understanding
    public static boolean helper3(int[] piles) {
        int stonesBob = 0;
        int stonesAlice = 0;
        int i = 0, j = piles.length - 1;
        while (i < j) {
            if (piles[i] > piles[j]) {
                stonesAlice += piles[i];
                stonesBob += piles[j];
                i++;
                j--;
            } else {
                stonesAlice += piles[j];
                stonesBob += piles[i];
                i++;
                j--;
            }
        }
        if (stonesAlice > stonesBob) {
            return true;
        } else {
            return false;
        }
    }

    // false means the turn is of alice
    // true means the turn is of bob
    // wrong approach
    public static boolean helper(int[] piles, int i, int j, int stonesAlice, int stoneBob, boolean turn) {
        if (i == j) {
            System.out.print(stoneBob + " " + stonesAlice);
            if (stoneBob > stonesAlice) {
                return true;
            } else {
                return false;
            }
        }

        int toAdd = 0;
        if (piles[i] >= piles[j]) {
            toAdd = piles[i];
            i++;
        } else {
            toAdd = piles[j];
            j--;
        }

        if (turn) {
            stoneBob += toAdd;
            turn = false;
        } else {
            stonesAlice += toAdd;
            turn = true;
        }

        return helper(piles, i, j, stonesAlice, stoneBob, turn);
    }

}
