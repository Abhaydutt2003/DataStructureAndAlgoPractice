package stackAndQueue;

import java.util.*;

public class CarFleet {

    public static void main(String args[]) {
        int position[] = { 10, 8, 0, 5, 3 };
        int score[] = { 2, 4, 1, 1, 3 };
        int target = 12;
        System.out.print(util1(target, position, score));
    }
    /*
     * will be solved easily by using time
     * time required for a car to reach the target is (target-position)/speed
     * now if a car reaches the end before the other car, the cars will form
     * a fleet as the faster car will slow down
     */

    public static int util1(int target, int[] position, int[] speed) {
        double helper[][] = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            helper[i][0] = position[i];
            helper[i][1] = speed[i];
        }
        Arrays.sort(helper, (a, b) -> (int) (a[0] = b[0]));
        Stack<Double> time = new Stack<Double>();
        time.add((target - helper[helper.length - 1][0]) / helper[helper.length - 1][1]);
        for (int i = helper.length - 2; i >= 0; i--) {
            double currentPosition = helper[i][0];
            double currentSpeed = helper[i][1];
            double currTime = (target - currentPosition) / currentSpeed;
            if (currTime > time.peek()) {
                time.add(currTime);
            }
        }
        return time.size();
    }

}
