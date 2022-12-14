package searchingAndSorting;
import java.util.HashMap;
public class PrintAllSubarrayWith0Sum {

	public static void main(String[] args) {
		long arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
		System.out.println(findSubarray(arr,arr.length));
	}
	public static long findSubarray(long arr[], int n) {
		 HashMap<Integer,Integer> helper = new HashMap<Integer,Integer>();
		 int sum=0,ans=0;
		 helper.put(0,1);
		 for(int i=0;i<n;i++) {
			 sum+=arr[i];
			 if(helper.containsKey(sum)) {
				 int a = helper.get(sum);
				 ans+=a;a++;
				 helper.put(sum,a);
			 }
			 helper.putIfAbsent(sum,1);
		 }
		 return ans;
	}

}
