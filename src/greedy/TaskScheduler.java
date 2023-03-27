package greedy;

import java.util.*;

class TaskSchedulerHelper {
    int a;
    int b;

    TaskSchedulerHelper(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class TaskScheduler {
    public static void main(String args[]) {
        // int a = 65;
        // char b = (char)a;
        // System.out.print(b);
        char[] task = { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println(leastInterval(task, 2));
    }
    // public static int leastInterval(char[] tasks, int n) {
    // int frequencyArray[] = new int[26];
    // for(char ch:tasks){
    // int index = ch-'A';
    // frequencyArray[index]++;
    // }
    // PriorityQueue<freq> pq = new
    // PriorityQueue<freq>((a,b)->b.frequency-a.frequency);
    // int toAdd = (int)'A';
    // for(int i = 0;i<frequencyArray.length;i++){
    // char toPut = (char)(toAdd+i);
    // int b = frequencyArray[i];
    // if(b!=0){
    // // System.out.println(toPut+" "+b+" ");
    // freq f =new freq(toPut,b);
    // pq.add(f);
    // }
    // }
    // Queue<Character> q = new LinkedList<Character>();
    // int time = 0;
    // while(pq.isEmpty() == false && q.isEmpty() == false){
    // if(pq.isEmpty() == false){
    // freq current =pq.poll();
    // if(q.isEmpty() == false){
    // if(current.theChar == q.peek()){
    // q.poll();
    // if(q.size() == n){

    // }else{

    // }
    // }else{
    // q.add(current.theChar);
    // }
    // }
    // }else{

    // }
    // }
    // return time;
    // }

    public static int leastInterval(char[] tasks, int n) {
        int[] freqArray = new int[26];
        for (char ch : tasks) {
            int index = ch - 'A';
            freqArray[index]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i : freqArray) {
            if (i > 0) {
                pq.add(i);
            }
        }
        Queue<TaskSchedulerHelper> q = new LinkedList<TaskSchedulerHelper>();
        int time = 0;
        while ((pq.isEmpty() == false) || (q.isEmpty() == false)) {
            time++;
            if (pq.isEmpty() == false) {
                int currentFreq = pq.poll();
                currentFreq -= 1;
                if (currentFreq > 0) {
                    TaskSchedulerHelper toPut = new TaskSchedulerHelper(currentFreq, time + n);
                    q.add(toPut);
                }
            }
            if((q.isEmpty() == false) && (q.peek().b == time)){
                pq.add(q.poll().a);
            }
        }
        return time;
    }

}
