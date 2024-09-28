package hashTable;
import java.util.HashMap;

public class SubarrayWithEqual01 {
	
	public static void main(String [] args) {
		int arr[] = {0,1,0,0,1,1,0};
		System.out.print(findMaxLength(arr));
	}
	public static int findMaxLength(int nums[]) {
		if(nums.length == 0||nums == null) {return 0;}
		int sum = 0,max = 0;
		HashMap<Integer,Integer> help = new HashMap<Integer,Integer>();
		help.put(0,-1);
		for(int i = 0;i<nums.length;i++) {
			int toAdd = (nums[i] == 0?-1:1);sum +=toAdd;
			if(help.containsKey(sum)) {
				max =Math.max(max,i-(help.get(sum)));
			}else {
				help.put(sum,i);
			}
		}
		return max;
	}

}
