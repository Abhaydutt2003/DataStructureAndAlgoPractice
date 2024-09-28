package arrays;
class myPair{
	int max;
	int min;
	myPair(int max, int min){
		this.max = max;
		this.min = min;
	}
}
class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
public class MaxAndMinInArray {
	static pair getMinMax(long []a) {
		if(a.length == 1) {
			pair ans = new pair(a[0],a[0]);
			return ans;
		}
		long max,min;
		
		if(a[0]>a[1]) {
			max = a[0];
			min = a[1];
		}else {
			max = a[1];
			min = a[0];
		}
		
		for(int i = 2;i<a.length;i++) {
			if(a[i]>max) {
				max =a[i];
			}else if(a[i]<min) {
				min = a[i];
			}
		}
		return new pair(max,min);
	}

	public static void main(String[] args) {
		long a[] = {3, 2, 1, 56, 1000, 167};
		pair ans = getMinMax(a);
		System.out.print(ans.first+" "+ans.second);
	}
	
	public static myPair maxAndMin(int arr[]) {
		if(arr.length == 1) {
			myPair ans = new myPair(arr[0],arr[0]);
			return ans;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				int temp = max;
				max = arr[i];
				if(temp != Integer.MIN_VALUE) {
					if(min>temp) {
						min = temp;
					}
				}
			}else if(arr[i] <min) {
				min = arr[i];
			}
		}
		if(max == Integer.MIN_VALUE) {
			max = 0;
		}if(min == Integer.MAX_VALUE) {
			min = 0;
		}
		myPair ans = new myPair(max,min);
		return ans;
	}
	

}
