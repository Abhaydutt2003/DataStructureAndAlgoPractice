package greedy;

public class GetTheMaximumScore {
    public static void main(String args[]){
        int arr[] = {1,3,5,7,9};
        int arr2[] = {3,5,100};
        System.out.print(maxSum(arr,arr2));
    }
    // this algorithm is similar to merge sort....
    public static int maxSum(int nums1[], int nums2[]){
        int sum1=0,sum2=0,res=0,i=0,j=0;
        while(i<nums1.length && j<nums2.length){
             if(nums1[i]<nums2[j]){
                sum1+=nums1[i++];
             }else if(nums1[i]>nums2[j]){
                sum2+=nums2[j++];
             }else{
                int toAdd = Math.max(sum1,sum2);
                res+= toAdd+nums1[i];
                sum1=0;sum2=0;i++;j++;
             }
        }
        while(i<nums1.length){
            sum1+=nums1[i++];
        }
        while(j<nums2.length){
            sum2+=nums2[j++];
        }
        int toAdd= Math.max(sum1,sum2);
        res+= toAdd;
        return res;
    }
}
