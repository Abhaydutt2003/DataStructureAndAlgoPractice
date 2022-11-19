package hashMapAndHeap;
import java.util.HashSet;
import java.util.HashMap;
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		//int arr[] = {15,-5,0,10,5,5,6,4,2,8,3,6,1};
		int arr[] = {15,-5,0,10,5,5,6,4};
		System.out.println(subarraySum(arr,10));
		//run this test case on both the 
	}
	public static int subarraySum1(int nums[], int k) {
		int sum = 0,result = 0;
		HashSet<Integer> preSum = new HashSet<Integer>();
		preSum.add(0);
		for(int i =0;i<nums.length;i++) {
			sum +=nums[i];
			if(preSum.contains(sum-k)) {
				result++;
			}
			preSum.add(sum);
		}
		return result;
	}
	public static int subarraySum(int nums[], int k) {
		int sum = 0,result =0;
		HashMap<Integer,Integer> preSum = new HashMap<Integer,Integer>();
		preSum.put(0,1);
		for(int i =0;i<nums.length;i++) {
			sum +=nums[i];
			if(preSum.containsKey(sum-k)) {
				result+=preSum.get(sum-k);
			}
			int toPut =1;
			if(preSum.containsKey(sum)) {
				toPut = preSum.get(sum)+1;
			}
			preSum.put(sum,toPut);
		}
		return result;
	}
	
	

}
