package hashMapAndHeap;
import java.util.*;
public class ArrayOfDoubledPair {
    public static void main(String args[]){
        int arr[] = {3,1,3,6};
        System.out.println(canReorderDoubled(arr));
    }
    public static boolean canReorderDoubled(int [] arr){
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        for(int i:arr){
            int toPut = 0;
            if(freqMap.containsKey(i)){
                toPut = freqMap.get(i);
            }
            toPut++;
            freqMap.put(i,toPut);
        }
        Arrays.sort(arr);
        for(int i:arr){
            if(freqMap.get(i) == 0){continue;}
            if(i<0 && i%2 != 0){return false;}
            int j = (i>=0)?i*2:i/2;
            if(freqMap.containsKey(j)){
                if(freqMap.get(j)!=0){
                    freqMap.put(i,freqMap.get(i)-1);
                    freqMap.put(j,freqMap.get(j)-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
