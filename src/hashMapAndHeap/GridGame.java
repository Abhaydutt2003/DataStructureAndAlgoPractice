package hashMapAndHeap;



public class GridGame {

	public static void main(String[] args) {
		int matrix[][] = {
				{1,3,1,15},
				{1,3,3,1},
		};
		System.out.print(util2(matrix));
	}
	
	
	
	
	//what does player 1 want?? low score for player 2
	//what does player 2 want?? max score for player2
	//DP solution
	
	
	
	public static long util2(int[][] grid){
		long suffix[] = new long[grid[0].length];
		long prefix[] = new long[grid[0].length];
		suffix[suffix.length-1] = grid[0][grid[0].length-1];
		prefix[0] = grid[1][0];
		for(int i = 1;i<suffix.length;i++) {
			prefix[i] = grid[1][i]+prefix[i-1];
		}
		for(int i = grid[0].length-2;i>=0;i--) {
			suffix[i] = suffix[i+1]+grid[0][i];
		}
		long result = Long.MAX_VALUE;
		for(int i = 0;i<prefix.length;i++) {
			long current = Math.max((i-1>=0)?prefix[i-1]:0,(i+1<suffix.length)?suffix[i+1]:0);
			result = Math.min(current,result);
		}
		return result;
	}
	
	
	public static long util1(int[][] grid) {
		long dp[][] = new long[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		long sum = 0;
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				sum+=grid[i][j];
				long sum1 = grid[i][j];
				if(i-1>=0) {
					sum1 += dp[i-1][j];
				}
				long sum2 = grid[i][j];
				if(j-1>=0) {
					sum2 += dp[i][j-1];
				}
				dp[i][j] = Math.max(sum1, sum2);
			}
		}
		long robo1Sum = dp[dp.length-1][dp[0].length-1];
		long robo2Sum = sum-robo1Sum;
		return robo2Sum;
	}
	
	

}
