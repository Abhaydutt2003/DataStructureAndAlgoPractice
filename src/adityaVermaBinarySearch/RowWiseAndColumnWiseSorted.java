package adityaVermaBinarySearch;

public class RowWiseAndColumnWiseSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean searchIterative(int matrix[][], int n, int m, int x) {
		int j = matrix[0].length-1,i=0;
		while(i<matrix.length && j>=0) {
			if(matrix[i][j] == x) {
				return true;
			}else if(matrix[i][j] <x) {
				i++;
			}else {
				j--;
			}
		}
		return false;
	}
	public static boolean searchRecursive(int matrix[][], int i, int j, int x) { 
		if(i== matrix.length || j < 0) {
			return false;
		}
		boolean ans = false;
		if(matrix[i][j] == x) {
			return true;
		}else if(matrix[i][j] < x) {
			ans = searchRecursive(matrix,i+1,j,x);
		}else {
			ans = searchRecursive(matrix,i,j-1,x);
		}
		return ans;
	}

}
