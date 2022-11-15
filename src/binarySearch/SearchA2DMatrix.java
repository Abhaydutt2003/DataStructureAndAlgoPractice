package binarySearch;
import java.util.Scanner;
public class SearchA2DMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt(),n = s.nextInt();
		int matrix[][] = new int [m][n];
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		System.out.println(searchMatrix(matrix,23));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row =  searchRow(matrix,target);
		if(matrix[row][0] == target) {return true;}
		boolean a = isPresent(matrix,target,row);
		return a;
	}
	private static int searchRow(int [][] matrix,int target) {
		if(matrix.length ==0) {return -1;}
		if(matrix.length == 1) {return 0;}
		int low = 0,high = matrix.length-1;
		while(low<high) {
			int mid = low + (high-low)/2;
			if(matrix[mid][0] > target) {
				high = mid-1;
			}else {
				if(matrix[mid+1][0]>target) {return mid;}
				low = mid+1;
			}
		}
		return low;
	}
	private static boolean isPresent(int matrix[][],int target,int row) {
		if(row == -1) {return false;}
		int low = 0,high = matrix[0].length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(matrix[row][mid]>target) {
				high = mid-1;
			}else if(matrix[row][mid]<target) {
				low = mid+1;
			}else {
				return true;
			}
		}
		return false;
	}

}
