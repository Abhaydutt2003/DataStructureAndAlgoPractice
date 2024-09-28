package binarySearch;

public class KokoEatingBananas {
    public static void main (String args[]){
        int arr[] = {30,11,23,4,20};
        System.out.print(minEatingSpeed(arr,5));
    }
    public static int minEatingSpeed(int [] piles, int h){
        int max = Integer.MIN_VALUE;
        for(int i:piles){
            max = (max>i)?max:i;
        }
        //BinarySearch Part..
        int start = 1,end = max,mid = 0,res = Integer.MAX_VALUE;
        while(start<=end){
            mid = start + (end-start)/2;
            if(isPossible(piles,mid,h)){
                res = (res>mid)?mid:res;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    private static boolean isPossible(int piles[], int mid, int h){
        int hoursTaken = 0;
        for(int i = 0;i<piles.length;i++){
            hoursTaken += Math.ceil(piles[i]/(mid*1.0));
        }
        return hoursTaken<=h;
    }
    
}
