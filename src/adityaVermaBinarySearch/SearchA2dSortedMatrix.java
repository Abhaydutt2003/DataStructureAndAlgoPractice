package adityaVermaBinarySearch;

public class SearchA2dSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int searchRow(int [][] matrix, int target) {
		int res = 0, start = 0,end = matrix.length-1,mid = 0;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(matrix[mid][0] == target) {
				return mid;
			}else if(matrix[mid][0]<target) {
				res = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return res;
	}
	private static int searchColumn(int [][] matrix, int target, int row) {
		int mid =0,start = 0,end = matrix[0].length-1;
		while(start<=end) {
			mid = start+(start-end)/2;
			if(matrix[row][mid] == target) {
				return mid;
			}else if(matrix[row][mid] < target) {
				start = mid+1;
			}else {
				end =mid-1;
			}
		}
		return 0;
	}

}
