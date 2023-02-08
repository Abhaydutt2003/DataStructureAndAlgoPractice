package hashMapAndHeap;

import java.util.*;
public class MaxEventAttend {
    public static void main(String args[]){
        int matrix[][] = {
            {1,2},
            {2,3},
            {3,4},
            {1,2}
        };
        System.out.print(maxEvents2(matrix));
    }
    //O(n^2) code....
    //sort the events basaed on end times, then greedly pick the events that end the earliest..
    public static int maxEvents(int[][] events){
        Arrays.sort(events,(a,b) -> a[1] == b[1]?a[0]-b[0]:a[1]-b[1]);
        HashSet<Integer> helper = new HashSet<Integer>();
        for(int i = 0;i<events.length;i++){
            // if(events[i][0] == events[i][1]){
            //     helper.add(events[i][0]);
            // }else{
            //     for(int j = events[i][0];j<=events[i][1];j++){
            //         if(helper.contains(j) != true){
            //             helper.add(j);break;
            //         }
            //     }
            // }
            for(int j = events[i][0];j<=events[i][1];j++){
                if(helper.contains(j) != true){
                    helper.add(j);break;
                }
            }
        }
        return helper.size();
    }
    
    //Greedy on the range of days...
    public static int maxEvents2(int[][] events){
        Arrays.sort(events,(a,b) -> a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);
        //finding the range of the days...
        int start = events[0][0];
        int end = Integer.MIN_VALUE;
        for(int i = 0;i<events.length;i++){
            end = (events[i][1]>end)?events[i][1]:end;
        }
        //Making a heap to store the end times of events by ascending order...
        PriorityQueue<Integer> helper = new PriorityQueue<Integer>();
        int ans=0;
        int i=0;
        //now we will iterate over each day
        for(int currentDay = start;currentDay<=end;currentDay++){
            //we discard the days which were ending in the past
            while(helper.isEmpty()!= true && helper.peek() <currentDay){
                helper.poll();
            }
            //we add the events end time time which are starting at the current day
            while (i < events.length && events[i][0] == currentDay) {
                helper.offer(events[i][1]);
                i++;
            }
            //now we greedily pick the events that is ending the earliest
            if(!helper.isEmpty()){
                ans++;
                helper.poll();//because that day cannot be used by us anymore
            }
        }
        return ans;
    }
}
