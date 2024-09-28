package arrays;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 2, 1 };
        System.out.println(util2(arr, 3));
    }

    // FINALLY
    // the size of the boat is at max 2
    // we sort the array,then we put the heaviest person in the boat
    // also see if can come with the smallest person available
    public static int util2(int[] people, int limit) {
        int i = 0, j = people.length - 1;
        int numBoats = 0;
        Arrays.sort(people);
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            numBoats++;
        }
        return numBoats;
    }

    // KCUF YM EFIL
    public static int util1(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int numBoats = 0, boatSum = 0;
        while (i <= j) {
            if (i == j) {
                if (people[i] + boatSum > limit) {
                    numBoats++;
                    boatSum += people[i];
                } else {
                    boatSum += people[i];
                }
                break;
            }
            if (boatSum + people[j] > limit) {
                numBoats++;
                boatSum = 0;
                continue;
            }
            boatSum += people[j--];
            if (boatSum + people[i] > limit) {
                numBoats++;
                boatSum = 0;
                continue;
            }
            boatSum += people[i++];
        }
        if (boatSum > 0) {
            return numBoats + 1;
        } else {
            return numBoats;
        }
    }

}
