package greedy;
class pair{
	int start;
	int end;
	pair(int x, int y){
		start = x;end = y;
	}
}
public class NmeetingsInoneRoom {

	public static void main(String[] args) {
		int[] start = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
		int [] end = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
		System.out.println(maxMeetings(start,end,start.length));
	}
	public static int maxMeetings(int start[],int end[],int n) {
		if(n == 0) {return 0;}
		pair[] arr = new pair[n];
		for(int i = 0;i<n;i++)
			arr[i] = new pair(start[i],end[i]);
		sort2(arr);
		int ans = 1;int timeLimit = arr[0].end;
		for(int i = 1;i<n;i++) {
			if(arr[i].start>timeLimit) {
				ans++;timeLimit = arr[i].end;
			}
		}
		return ans;
	}

	//insertion sort...
	@SuppressWarnings("unused")
	private static void sort(pair[] arr) {
		for(int i = 1;i<arr.length;i++) {
			pair temp = arr[i];
			int j = i-1;
			while(j>=0 && temp.end<arr[j].end) {
				arr[j+1] =arr[j];j--;
			}
			arr[j+1] = temp;
		}
	}
	//merge sort
	private static void sort2(pair[] arr) {
		if(arr.length == 1) {return;}
		pair[] smallArr1 = new pair[arr.length/2];
		pair[] smallArr2 = new pair[arr.length-smallArr1.length];
		for(int i = 0;i<smallArr1.length;i++) {
			smallArr1[i] = arr[i];
		}
		for(int i = arr.length/2;i<arr.length;i++) {
			smallArr2[i-arr.length/2] = arr[i];
		}
		sort2(smallArr1);
		sort2(smallArr2);
	    mergeTwoSortedArrays(smallArr1,smallArr2,arr);
	}
	private static void mergeTwoSortedArrays(pair[] arr1, pair[] arr2,pair[]arr) {
		int i = 0,j = 0,k = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i].end<=arr2[j].end) {
				arr[k] = arr1[i];
				i++;k++;
			}else {
				arr[k] = arr2[j];
				j++;k++;
			}
		}
		while(i<arr1.length) {
			arr[k] = arr1[i];
			k++;i++;
		}
		while(j<arr2.length) {
			arr[k] = arr2[j];
			j++;k++;
		}
	}

}
