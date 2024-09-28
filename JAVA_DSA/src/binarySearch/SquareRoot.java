package binarySearch;

public class SquareRoot {

	public static void main(String[] args) {
		int x = 9;
		int ans = mySqrt(x);
        System.out.print(ans);
	}
	
	public static int mySqrt(int x) {
		if(x == 0) {return x;}
		//take low because mid * mid might cause overflow...
		long low = 1,high = x;
		while(true) {
			long mid =low + (high-low)/2;
			if((mid * mid)>x) {
				high = mid-1;
			}else {
				long next = mid+1;
				if((next*next) >x) {return (int)mid;}
				low =mid+1;
			}
		}
	}
	
}
