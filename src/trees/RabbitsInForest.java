package hashMapAndHeap;

import java.util.*;
public class RabbitsInForest {
    public static void main(String args[]){
        int arr[] = {1,0,1,0,0};
        System.out.println(numRabbits(arr));
    }
    public static int numRabbits(int [] answers){
        return util1(answers);
    }

    public static int util1(int [] answers){
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int minRabbits = 0;
        for(int i:answers){
            if(hm.containsKey(i)){
                int count = hm.get(i);
                if(count+1 == i+1){
                    hm.remove(i);
                }else{
                    hm.put(i,count+1);
                }
            }else{
                if(i == 0){
                    minRabbits+=1;
                    continue;
                }
                minRabbits+=(i+1);
                hm.put(i,1);
            }
        }
        return minRabbits;
    }
    
}
