package arrays;

public class MergeTwoSortedArray {
	public static int[] merge(int nums1[], int nums2[]) {
		int arr[] = new int [nums1.length+nums2.length];
		int i = 0,j=0,k=0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i] >= nums2[j]) {
				arr[k++] = nums2[j++];
			}else {
				arr[k++] = nums1[i++];
			}
		}
		if(i<nums1.length) {
			while(i<nums1.length) {
				arr[k++] = nums1[i++];
			}
		}else {
			while(j<nums2.length) {
				arr[k++] = nums2[j++];
			}
		}
		return arr;
	}
	public static int[] merge(int nums1[],int m, int[] nums2, int n) {
		if(m == 0 || n == 0) {
			if(m==0) {
				return nums2;
			}else{
				return nums1;
			}
		}
		int arr[] = new int[m+n];
		int i = 0,j=0,k=0;
		while(i<m && j<n) {
			if(nums1[i] >= nums2[j]) {
				arr[k++] = nums2[j++];
			}else {
				arr[k++] = nums1[i++];
			}
		}
		if(i<m) {
			while(i<nums1.length) {
				arr[k++] = nums1[i++];
			}
		}else {
			while(j<nums2.length) {
				arr[k++] = nums2[j++];
			}
		}
		return arr;
	}
	public static void merge2(int nums1[], int m, int nums2[], int n) {
		int i=m-1,j=n-1,k=m+n-1;
		while(j>=0) {
			if(i>=0 && nums1[i] >nums2[j]) {
				nums1[k--] = nums1[i--];
			}else {
				nums1[k--] = nums2[j--];
			}
		}
	}
	

	public static void main(String[] args) {
		int arr1 [] = {1,2,3,0,0,0};
		int arr2 [] = {2,5,6};
//		int arr[] = merge(arr1,3,arr2,3);
//		for(int i: arr) {
//			System.out.print(i+" ");
//		}
		merge2(arr1,3,arr2,3);
		for(int i:arr1) {
			System.out.print(i+" ");
		}

	}

}
