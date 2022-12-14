package searchingAndSorting;

public class FindMissingAndRepeating {

	public static void main(String[] args) {
		int arr[] = {13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 34, 46, 30, 26, 41, 18, 5, 17, 37, 39, 6, 4, 20, 27, 9, 3, 8, 40, 24, 44, 14, 36,7, 38, 12, 1, 42, 12, 28, 22, 45};
		//int arr[] = {5,4,3,4,1};
		arr =  findTwoElements2(arr,arr.length);
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}
	//index sort correct..
	public static int[] findTwoElements(int arr[], int n) {
		for(int i  =0;i<n;) {
			int temp = arr[i];
			if(arr[temp-1] == temp) {
				i++;
			}else {
				arr[i] = arr[temp-1];
				arr[temp-1] = temp;
			}
		}
		int ans[] = new int[2];
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]!= i+1) {
				ans[0] = arr[i];ans[1] = i+1;
			}		
		}
		return ans;
	}
	//mark the visited elements as negative approach...
	public static int[] findTwoElements2(int arr[], int n) {
		int repeating = -1;
		for(int i: arr) {
			int index = Math.abs(i);
			if(arr[index-1]<0) {
				repeating = index;
			}else {
				arr[index-1] = -arr[index-1];
			}
		}
		int missing = -1;
		for(int i = 0;i<n;i++) {
			if(arr[i]>0) {
				missing =i+1;
			}
		}
		int ans[] = {repeating, missing};
		return ans;
	}
	

}
