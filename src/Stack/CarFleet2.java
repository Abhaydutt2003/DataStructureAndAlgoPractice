package StackAndQueues;

import java.util.*;

public class CarFleet2 {

    public static void main(String args[]) {

    }

    // time = distance/speed
    // a very hard question indeed

    /*
     * Intution:-
     * 
     * to know weather two cars will collide or not we will use the formula
     * (position1-position2)/(speed2-speed1)
     * 
     * now will also need to make sure that the car has not merged before with
     * someone
     * before we merge with it , so i have used
     * 
     * if (ans[s.peek()] == -1 || ans[s.peek()] > timeTaken)
     * 
     * 
     * now i also need to see weather i am a valid candidate to merge with the other
     * car or not , so i have used
     * 
     * if (currentSpeed <= topSpeed) {
     * s.pop();
     * continue;
     * }
     * 
     * the real difference between this question and car fleet 1 is that here we need to 
     * actually know which car is going to collapse with which car, so things get different 
     * here
     * 
     * instead of just keeping the fleets in the stack , we will need to keep all the cars
     * because we so not know exactly with which car my current will collapse
     * 
     * 
     * rest if you see the code, you will understand
     * 
     * 
     * example like 
     * 
     * {2,4}
     * {3,1}
     * {4,3}
     * {7,2}
     * 
     * here 4 and 7 will merge and 2 and 3 will merge.
     * 
     * 
     */

    public static double[] util1(int[][] cars) {
        double[] ans = new double[cars.length];
        Arrays.fill(ans, -1.0);
        Stack<Integer> s = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            int currentSpeed = cars[i][1];
            int currentPosition = cars[i][0];
            while (s.isEmpty() == false) {
                int topSpeed = cars[s.peek()][1];
                int topPosition = cars[s.peek()][0];
                if (currentSpeed <= topSpeed) {
                    s.pop();
                    continue;
                }
                double timeTaken = (double) (topPosition - currentPosition) / (currentSpeed - topSpeed);
                if (ans[s.peek()] == -1 || ans[s.peek()] > timeTaken) {
                    ans[i] = timeTaken;
                    break;
                } else {
                    s.pop();
                }
            }
            s.push(i);
        }
        return ans;
    }

}
