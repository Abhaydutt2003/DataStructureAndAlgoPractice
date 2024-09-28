package binarySearch;

public class MaxRibbonCut {
    public static void main(String[] args){
        int arr[] = {9,7,5};int k = 4;
        System.out.println(ans(arr,k));
    }
    public static int ans (int arr[], int k){
        int min = Integer.MAX_VALUE;
        for(int i:arr){min = (min>i)?i:min;}
        int start = 0,end = min,mid = 0,res = 0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(isValid(mid,arr,k)){
                res = mid;
                start = mid+1;
            }else{
                end= mid-1;
            }
        }
        return res;
    }
    private static boolean isValid(int mid,int arr[], int k){
        int count = 0;
        for(int i:arr){
            count+=(i/mid);
        }
        return count>=k;
    }
    
}
