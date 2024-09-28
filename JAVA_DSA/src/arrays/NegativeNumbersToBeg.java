package arrays;
import java.util.Queue;
import java.util.LinkedList;
public class NegativeNumbersToBeg {
	public static void negativeBeg(int [] arr) {
		int nextPositiveIndex = 0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] <0) {
				int temp = arr[nextPositiveIndex];
				arr[nextPositiveIndex] = arr[i];
				arr[i] = temp;
				nextPositiveIndex++;
			}
		}
	}
	public static void seg(int arr[]) {
		int a[] = new int[arr.length];
		int k = 0;
		for(int i = 0;i<arr.length;i++)
			if(arr[i]>0) {
				a[k] = arr[i];
				k++;
			}
		
		for(int i = 0;i<arr.length;i++)
			if(arr[i]<0) {
				a[k] = arr[i];
				k++;
			}
		
		for(int i = 0;i<arr.length;i++)
			arr[i] = a[i];
	}
	
	public static void seg2(int arr[]) {
		Queue <Integer> negElements = new LinkedList<Integer>();
		for(int i = 0;i<arr.length;i++)
			if(arr[i]<0) {
				negElements.add(arr[i]);
			}
		
		for(int i = 0,k=0;i<arr.length;i++)
			if(arr[i]>=0) {
				arr[k] = arr[i];
				k++;
			}
		
		int a = arr.length- negElements.size();
		while(negElements.isEmpty() !=true) {
			arr[a] = negElements.poll();
			a++;
		}
			
	}

	public static void main(String[] args) {
		int arr[] = {-5, 7, -3, -4, 9, 10, -1, 11};
		seg2(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i]+" ");

	}

}
