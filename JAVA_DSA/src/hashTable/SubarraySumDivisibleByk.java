package hashTable;
import java.util.HashMap;
public class SubarraySumDivisibleByk {
	
	public static void main(String args[]) {
		int arr[] = {4,5,0,-2,-3,1};
		System.out.print(subarrayDivByK(arr,5));
	}
	public static int subarrayDivByK(int [] nums,int k) {
		int sum = 0,result = 0;
		HashMap<Integer,Integer> helper = new HashMap<Integer,Integer>();
		helper.put(0,1);
		for(int i:nums) {
			sum +=i;
			int remainder = sum%k;
			if(remainder<0) {remainder+=k;}
			if(helper.containsKey(remainder)) {
				result += helper.get(remainder);
				helper.put(remainder,helper.get(remainder)+1);
			}
			helper.putIfAbsent(remainder,1);
		}
		return result;
	}

}
