package backTracking;

import java.util.*;

public class MatchSticksSquare {

	public static void main(String[] args) {
		int arr[] = {5,5,5,5,4,4,4,4,3,3,3,3};
		System.out.print(util1(arr));
	}
	
	
	
	
	
	public static boolean util1(int[] matchsticks) {
		int sum = 0;
		Integer arr[] = new Integer[matchsticks.length];
		int k = 0;
		for(int i:matchsticks) {
			sum+=i;
			arr[k++] = i;
		}
		if(sum%4 != 0) {
			return false;
		}
		int target = sum/4;
		Arrays.sort(arr,Collections.reverseOrder());
		return helper(arr,0,0,0,0,0,target);
	}
	
	public static boolean helper(Integer m[], int index, int side1, int side2, int side3, int side4, int target) {
		if(side1 == target && side2 == target && side3 == target && side4 == target) {
			return true;
		}else if(side1>target || side2>target ||side3>target ||side4>target ) {
			return false;
		}
		boolean ans1 = helper(m,index+1,side1+m[index],side2,side3,side4,target);
		if(ans1) {return true;}
		boolean ans2 = helper(m,index+1,side1,side2+m[index],side3,side4,target);
		if(ans2) {return true;}
		boolean ans3 = helper(m,index+1,side1,side2,side3+m[index],side4,target);
		if(ans3) {return true;}
		boolean ans4 = helper(m,index+1,side1,side2,side3,side4+m[index],target);
		if(ans4) {return true;}	
		return false;
	}

}
