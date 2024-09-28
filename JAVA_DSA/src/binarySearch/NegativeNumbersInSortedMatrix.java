package binarySearch;
import java.util.Scanner;
public class NegativeNumbersInSortedMatrix {
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m =s.nextInt(),n = s.nextInt();
		int [][] grid = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				grid[i][j] = s.nextInt();
			}
		}
		System.out.println(countNegatives(grid));
		s.close();
	}
	public static int countNegatives(int [][] grid) {
		int rows = grid.length,cols = grid[0].length;
		int ans = 0,lastNegIndex = cols-1;
		for(int i = 0;i<rows;i++) {
			//edge case 1, optimization1
			if(grid[i][0]<0) {
				ans = ans+((rows-i)*cols);
				break;
			}
			//edge case 2, optimization2
			if(grid[i][cols-1]>0) {
				continue;
			}
			int low = 0,high = lastNegIndex;
			while(low<=high) {
				int m = low+(high-low)/2;
				if(grid[i][m]<0) {
					high = m-1;
				}else {
					low = m+1;
				}
			}
			lastNegIndex = low;ans+=(cols-low);
		}
		return ans;
	}

}
